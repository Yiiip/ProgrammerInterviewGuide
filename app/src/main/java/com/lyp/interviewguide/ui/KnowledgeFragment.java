package com.lyp.interviewguide.ui;


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


public class KnowledgeFragment extends Fragment {

    private RecyclerView rcView;

    private QuestionAdapter mAdapter;
    private List<Question> mData = new ArrayList<>();

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 1) {
                mAdapter = new QuestionAdapter(getContext(), mData);
                rcView.setAdapter(mAdapter);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_knowledge, container, false);

        rcView = (RecyclerView) view.findViewById(R.id.knowledge_rc_view);
        rcView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        new Thread() {
            @Override
            public void run() {
                super.run();

                Document doc = null;

                try {
                    doc = Jsoup.connect("http://blog.csdn.net/derrantcm/article/details/46658823#comments").get();

                    Elements elements = doc.getElementsByClass("markdown_views");

                    Elements titles = elements.select("h1");
                    Elements answers = elements.select("p");

                    titles.remove(0); //去掉第一个无效标题

                    for (int i = 0; i < 9; i++) {
                        //Log.d("TAG", titles.get(i).html());

                        mData.add(new Question(
                                titles.get(i).html(),
                                answers.get(i).html()
                        ));
                    }
                    for (int i = 9; i < 16; i++) {
                        //Log.d("TAG", titles.get(i).html());

                        mData.add(new Question(
                                titles.get(i).html(),
                                answers.get(i+1).html()
                        ));
                    }

                    Message msg = new Message();
                    msg.what = 1;
                    mHandler.sendMessage(msg);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        return view;
    }

}
