package com.lyp.interviewguide.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.lyp.interviewguide.R;
import com.lyp.interviewguide.utils.ClipboardUtil;

public class WebActivity extends AppCompatActivity {

    private WebView webView;
    private Toolbar toolbar;

    private String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        mUrl = intent.getStringExtra("ANSWER_URL");

        setContentView(R.layout.activity_web);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //toolbar.inflateMenu(R.menu.menu_web_detail);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_web_detail_share:
                        if (webView.getUrl() == null || webView.getUrl().equals("")) {
                            Toast.makeText(WebActivity.this, "请刷新重试！", Toast.LENGTH_SHORT).show();
                        } else {
                            ClipboardUtil.copy(webView.getUrl(), getApplicationContext());
                            Toast.makeText(WebActivity.this, "该网址已复制到剪贴板！", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                return false;
            }
        });

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(mUrl == null ? "404" : mUrl);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        } else {
            finish();
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_web_detail, menu);
        return true;
    }
}
