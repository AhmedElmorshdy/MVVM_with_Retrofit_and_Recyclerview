package com.mmabas77.mvvmexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mmabas77.mvvmexample.pojo.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.viewHolderData>{
    List<Model> models;
    Context context;

    public ModelAdapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.design,parent,false);
        return new viewHolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderData holder, int position) {
        Model current = models.get(position);
        holder.textView.setText(current.getBody());
        holder.textView1.setText(current.getTitle());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class viewHolderData extends RecyclerView.ViewHolder {

        TextView textView;
        TextView textView1;


        public viewHolderData(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.body);
            textView1=itemView.findViewById(R.id.title);
        }
    }
}
