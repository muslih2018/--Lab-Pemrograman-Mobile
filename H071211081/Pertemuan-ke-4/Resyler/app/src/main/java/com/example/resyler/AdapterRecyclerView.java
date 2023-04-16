package com.example.resyler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    private ArrayList<chatModel> dataitem;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView texthead;
        TextView textSubhead;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            texthead=itemView.findViewById(R.id.chat2);
            textSubhead=itemView.findViewById(R.id.waktu);
        }
    }
    AdapterRecyclerView(ArrayList<chatModel> dataitem){
        this.dataitem=dataitem;
    }
    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listchat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView.ViewHolder holder, int position) {
        TextView textHead=holder.texthead;
        TextView textSubhead=holder.textSubhead;

        textHead.setText(dataitem.get(position).getName());
        textSubhead.setText(dataitem.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return dataitem.size();
    }


}
