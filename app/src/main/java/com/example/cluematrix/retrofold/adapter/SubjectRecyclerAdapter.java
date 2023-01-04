package com.example.cluematrix.retrofold.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cluematrix.R;
import com.example.cluematrix.retrofold.model.Subjects;

import java.util.ArrayList;

public class SubjectRecyclerAdapter extends RecyclerView.Adapter<SubjectRecyclerAdapter.ViewHolder> {
    ArrayList<Subjects> subjectsArrayList;

    public SubjectRecyclerAdapter(ArrayList<Subjects> subjectsArrayList) {
        this.subjectsArrayList = subjectsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sub_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.subjectTv.setText(subjectsArrayList.get(position).getSubject());
    }

    @Override
    public int getItemCount() {
        return subjectsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subjectTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectTv = itemView.findViewById(R.id.textView6);
        }
    }
}
