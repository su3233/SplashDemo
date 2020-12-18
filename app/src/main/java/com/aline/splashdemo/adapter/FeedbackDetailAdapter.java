package com.aline.splashdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.aline.splashdemo.R;
import com.aline.splashdemo.entity.LocalFeedbackBean;

import java.util.List;


public class FeedbackDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<LocalFeedbackBean.DataBean> mList;
    private final LayoutInflater inflater;

    public FeedbackDetailAdapter(Context context, List<LocalFeedbackBean.DataBean> list) {
        this.mContext = context;
        this.mList = list;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_feedback_detail, parent, false);
        return new FeedbackViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        FeedbackViewHolder viewHolder = (FeedbackViewHolder) holder;
        LocalFeedbackBean.DataBean dataBean = mList.get(position);
        viewHolder.tvDetailTitle.setText(dataBean.getTitle());
        viewHolder.tvDetailContent.setText(dataBean.getContent());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class FeedbackViewHolder extends RecyclerView.ViewHolder {

        TextView tvDetailTitle;

        TextView tvDetailContent;

        public FeedbackViewHolder(View itemView) {
            super(itemView);

        }
    }
}
