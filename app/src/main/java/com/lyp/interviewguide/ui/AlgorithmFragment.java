package com.lyp.interviewguide.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyp.interviewguide.adapter.QuestionAdapter;
import com.lyp.interviewguide.R;
import com.lyp.interviewguide.model.Question;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AlgorithmFragment extends Fragment {

    private RecyclerView rcView;

    private AlgorithmAdapter mAdapter;
    private List<Question> mData = new ArrayList<>();

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 2) {
                mAdapter = new AlgorithmAdapter(getContext(), mData);
                rcView.setAdapter(mAdapter);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_algorithm, container, false);

        rcView = (RecyclerView) view.findViewById(R.id.algorithm_rc_view);
        rcView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        new Thread() {
            @Override
            public void run() {
                super.run();

                try {
                    Document doc = Jsoup.connect("http://blog.csdn.net/derrantcm/article/details/46887821").get();

                    Elements elements = doc.getElementsByClass("markdown_views");

                    Elements links = elements.select("h3").select("strong").select("a");

                    for (int i = 0; i < links.size(); i++) {
                        if (! links.get(i).attr("href").isEmpty()) {

                            mData.add(new Question(
                                    (links.get(i).text()).replace("【剑指Offer学习】", "")
                                            .substring(1, (links.get(i).text()).replace("【剑指Offer学习】", "").length()-1),
                                    links.get(i).attr("href")
                            ));

                            // Log.d("TAG", links.get(i).attr("href"));
                            // Log.d("TAG", links.get(i).text() + "\n------------\n");
                        }
                    }

                    Message msg = new Message();
                    msg.what = 2;
                    mHandler.sendMessage(msg);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        return view;
    }

    class AlgorithmAdapter extends QuestionAdapter {

        public AlgorithmAdapter(Context mContext, List<Question> mData) {
            super(mContext, mData);
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

                    Intent intent = new Intent(getActivity(), WebActivity.class);
                    intent.putExtra("ANSWER_URL", mData.get(position).getAnswer());
                    startActivity(intent);
                }
            });
        }
    }
}
