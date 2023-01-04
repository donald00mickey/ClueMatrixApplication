package com.example.cluematrix.retrofold.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cluematrix.R;
import com.example.cluematrix.retrofold.model.Informations;

import java.util.ArrayList;

public class InformationRecyclerAdapter extends RecyclerView.Adapter<InformationRecyclerAdapter.ViewHolder> {
    ArrayList<Informations> informationsArrayList;

    public InformationRecyclerAdapter(ArrayList<Informations> informationsArrayList) {
        this.informationsArrayList = informationsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.info_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.baseIc.setImageResource(informationsArrayList.get(position).getImage());
        holder.retIc.setImageResource(informationsArrayList.get(position).getImage2());
        holder.msg.setText(informationsArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return informationsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView baseIc, retIc;
        TextView msg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            baseIc = itemView.findViewById(R.id.imageView);
            retIc = itemView.findViewById(R.id.imageView2);
            msg = itemView.findViewById(R.id.textView9);
        }
    }
}
