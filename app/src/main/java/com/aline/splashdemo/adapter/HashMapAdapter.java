package com.aline.splashdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.aline.splashdemo.R;
import com.aline.splashdemo.entity.LocalFeedbackBean;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class HashMapAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<String> datas;
    private final LayoutInflater inflater;

    public HashMapAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.datas = list;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_hash_map, parent, false);
        return new HashViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        HashViewHolder viewHolder = (HashViewHolder) holder;
        String name = datas.get(position);
        viewHolder.tv_name.setText(name);
        viewHolder.tv_age.setText(name);
        holder.getAdapterPosition();
        if (holder.getLayoutPosition()==RecyclerView.NO_POSITION){
            return;
        }
        holder.getOldPosition();
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class HashViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;

        TextView tv_age;

        public HashViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_hash_name);
            tv_age = itemView.findViewById(R.id.tv_hash_age);
        }
    }
}
