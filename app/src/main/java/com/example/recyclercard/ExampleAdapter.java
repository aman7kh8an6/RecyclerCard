package com.example.recyclercard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    //6.2
    private ArrayList<example> mExampleList;

    //1
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        //4
        public ImageView imageView;
        public TextView textView;

        //2
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            //4
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
    //6.1
    public ExampleAdapter(ArrayList<example> exampleList){
        mExampleList = exampleList;
    }

    //3
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //5
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_items,parent,false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(view);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int position) {
        //7
        example currItem = mExampleList.get(position);
        exampleViewHolder.textView.setText(currItem.getmText());
        exampleViewHolder.imageView.setImageResource(currItem.getmImageResource());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}