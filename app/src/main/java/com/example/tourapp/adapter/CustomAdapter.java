package com.example.tourapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourapp.R;
import com.example.tourapp.api.OnClick;
import com.example.tourapp.model.TurModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    Context context;
    List<TurModel>modelList;
    OnClick onClick;

    public CustomAdapter(Context context, List<TurModel> modelList,OnClick onClick) {
        this.context = context;
        this.modelList = modelList;
        this.onClick=onClick;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_row_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        holder.name.setText(modelList.get(position).getName());
        holder.info.setText(modelList.get(position).getInfo());
        holder.price.setText(modelList.get(position).getPrice()+"TL");
        Picasso.get().load(modelList.get(position).getImage()).into(holder.image);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.OnNewsClicked(modelList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,info,price;
        ImageView image;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            info=itemView.findViewById(R.id.info);
            price=itemView.findViewById(R.id.price);
            image=itemView.findViewById(R.id.image);
            cardView=itemView.findViewById(R.id.cardView);

        }
    }
}
