package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder> {

    private List<Carousel> productList;

    public CarouselAdapter(List<Carousel> productList) {
        this.productList = productList;
    }

    @Override
    public CarouselViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_design, parent, false);
        return new CarouselViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarouselViewHolder holder, int position) {
        Carousel carousel = productList.get(position);
        holder.productImage.setImageResource(carousel.getProductImage());



    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class CarouselViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        public CarouselViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.image);

        }
    }



}