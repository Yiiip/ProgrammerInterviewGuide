package com.lyp.interviewguide.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lyp.interviewguide.R;


public class AboutFragment extends Fragment implements View.OnClickListener {

    private TextView tvGithub, tvSource, tvCsdn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        tvGithub = (TextView) view.findViewById(R.id.tv_github);
        tvSource = (TextView) view.findViewById(R.id.tv_source);
        tvCsdn = (TextView) view.findViewById(R.id.tv_csdn);

        tvGithub.setOnClickListener(this);
        tvSource.setOnClickListener(this);
        tvCsdn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(getActivity(), WebActivity.class);

        switch (view.getId()) {
            case R.id.tv_github:
                intent.putExtra("ANSWER_URL", "https://github.com/Yiiip");
                startActivity(intent);
                break;

            case R.id.tv_source:
                intent.putExtra("ANSWER_URL", "http://blog.csdn.net/DERRANTCM/article/category/3151215");
                startActivity(intent);
                break;

            case R.id.tv_csdn:
                intent.putExtra("ANSWER_URL", "http://blog.csdn.net/skipperkevin");
                startActivity(intent);
                break;
        }
    }
}
