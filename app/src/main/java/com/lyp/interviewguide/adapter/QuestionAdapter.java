package com.lyp.interviewguide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lyp.interviewguide.R;
import com.lyp.interviewguide.model.Question;

import java.util.List;

/**
 * Created by lyp on 2017/2/15.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private List<Question> mData;
    private Context mContext;

    public QuestionAdapter(Context mContext, List<Question> mData) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new QuestionViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_question, parent, false));
    }

    @Override
    public void onBindViewHolder(final QuestionViewHolder holder, final int position) {
        holder.title.setText(mData.get(position).getTitle());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (! mData.get(position).isShowed()) {
                    mData.get(position).setShowed(true);
                    holder.title.setText(holder.title.getText().toString() + "\n\n" + mData.get(position).getAnswer());
                }

                if (holder.title.getText().toString().equals(mData.get(position).getTitle())) {
                    holder.title.setText(holder.title.getText().toString() + "\n\n" + mData.get(position).getAnswer());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder {

        public TextView title;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_title);
        }
    }
}
