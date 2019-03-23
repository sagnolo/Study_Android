package com.sagnolo.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Dictionary> mList;

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        protected TextView id;
        protected TextView data;

        public CustomViewHolder(View view){
            super(view);
            this.id = (TextView)view.findViewById(R.id.list_num);
            this.data = (TextView) view.findViewById(R.id.list_data);
        }
    }

    public CustomAdapter(ArrayList<Dictionary> list){
        this.mList = list;
    }

    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup,false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( CustomAdapter.CustomViewHolder viewHolder, int position) {
        viewHolder.id.setText(mList.get(position).getNum());
        viewHolder.data.setText(mList.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
