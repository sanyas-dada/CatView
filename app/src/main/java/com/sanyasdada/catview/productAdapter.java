package com.sanyasdada.catview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sanyasdada.catview.listener.ShowInterface;

import java.util.List;

public class productAdapter extends RecyclerView.Adapter<productAdapter.MyViewHolder> {
    List<String> list;
    Context context;
    int  itemPosition;
    ShowInterface showInterface;

    public productAdapter(List<String> list, Context context,ShowInterface showInterface) {
        this.list = list;
        this.context = context;
        this.showInterface = showInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view=   LayoutInflater.from(context).inflate(R.layout.text_field,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textView.setText(list.get(holder.getAdapterPosition()));
       /* if(i == 0){
            i++;
            holder.textView.setTextColor(Color.parseColor("#d2691e"));
        }*/
        if(itemPosition == holder.getAdapterPosition()){
            holder.imageButton.setVisibility(View.VISIBLE);
            holder.textView.setTextColor(Color.parseColor("#F57224"));
        }else{
            holder.imageButton.setVisibility(View.INVISIBLE);
            holder.textView.setTextColor(Color.parseColor("#000000"));
        }
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int prepos = itemPosition;
                itemPosition = holder.getAdapterPosition();
                notifyItemChanged(prepos);
                notifyItemChanged(itemPosition);

                detail(holder.getAdapterPosition());

            }
        });

    }

    private void detail(int adapterPosition) {
        showInterface.showInterface(adapterPosition);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageButton imageButton;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
          textView =  itemView.findViewById(R.id.text_field_selected);
          imageButton =itemView.findViewById(R.id.image_unselected);
        }
    }
}
