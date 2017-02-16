package com.lyp.interviewguide.model;

/**
 * Created by lyp on 2017/2/16.
 */
public class Question {

    private String title;     // 题目
    private String answer;    // 答案或者答案的超链接
    private boolean isShowed; // 是否显示了答案

    public Question(String title, String answer) {
        this.title = title;
        this.answer = answer;
        this.isShowed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isShowed() {
        return isShowed;
    }

    public void setShowed(boolean showed) {
        isShowed = showed;
    }
}
