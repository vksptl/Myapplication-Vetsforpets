package com.vikas.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *
 */
public class DiseaseAdapter extends RecyclerView.Adapter<DiseaseAdapter.DiseaseViewHolder> {

    ArrayList<Disease> list;
    Context context;

    public DiseaseAdapter(Context context,ArrayList<Disease> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public DiseaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.simple_disease,parent,false);
        return new DiseaseViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(DiseaseViewHolder holder, int position) {

        holder.detail.setText(list.get(position).getDetail());
        holder.heading.setText(list.get(position).getHeading());

    }

    static class DiseaseViewHolder extends RecyclerView.ViewHolder {

        protected TextView detail;
        protected TextView heading;

        public DiseaseViewHolder(View itemView) {
            super(itemView);

            detail=(TextView)itemView.findViewById(R.id.detail);
            heading=(TextView)itemView.findViewById(R.id.heading);
        }
    }
}
