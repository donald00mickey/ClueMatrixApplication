package com.example.cluematrix.retrofold.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.cluematrix.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.ViewHolder> {
    String[] images;
    public SliderAdapter(String[] images) { this.images = images; }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        Glide.with(viewHolder.itemView.getContext())
                .load(images[position])
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(viewHolder.imageView);
    }

    @Override
    public int getCount() {
        if (images!=null){
            return images.length;
        }
        return 0;
    }

    public static class ViewHolder extends SliderViewAdapter.ViewHolder {
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
