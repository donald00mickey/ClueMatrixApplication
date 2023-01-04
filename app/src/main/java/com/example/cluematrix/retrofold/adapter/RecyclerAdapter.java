package com.example.cluematrix.retrofold.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cluematrix.R;
import com.example.cluematrix.retrofold.model.Data;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<Data> dataList;

    public RecyclerAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.api_res_list_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText("id:\t"+ dataList.get(position).getId());
        holder.rf_id.setText("rf_id:\t"+dataList.get(position).getRf_id());
        holder.created_at.setText("created_at:\t"+dataList.get(position).getCreated_at());
        holder.updated_at.setText("updated_at:\t"+dataList.get(position).getUpdated_at());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, rf_id, created_at, updated_at;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.idTextView);
            rf_id = itemView.findViewById(R.id.rf_idTextView);
            created_at = itemView.findViewById(R.id.createdAtTextView);
            updated_at = itemView.findViewById(R.id.updatedAtTextView);
        }
    }
}
