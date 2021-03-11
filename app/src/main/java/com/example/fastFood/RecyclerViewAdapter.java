package com.example.fastFood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {

    ArrayList<String> SubjectNames;

    View view1;

    public RecyclerViewAdapter(ArrayList<String> SubjectNames1) {

        this.SubjectNames = SubjectNames1;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        view1  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_item, viewGroup, false);

        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder Viewholder, int i) {

        Viewholder.SubjectTextView.setText(SubjectNames.get(i));
    }

    @Override
    public int getItemCount() {

        return SubjectNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView SubjectTextView;
        public ViewHolder(View view) {

            super(view);

            SubjectTextView = (TextView)view.findViewById(R.id.textview1);
        }
    }

}