package com.sanyasdada.catview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sanyasdada.catview.listener.ShowInterface;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {
    List<ImageModel> list;
    Context context;



    public ImageAdapter(List<ImageModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     View view =    LayoutInflater.from(context).inflate(R.layout.recycler_view,parent,false);
     return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return list.size() ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView productName,proPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

           imageView= itemView.findViewById(R.id.image_view);
           productName= itemView.findViewById(R.id.product_name);
           proPrice=  itemView.findViewById(R.id.product_price);


        }
    }
}
