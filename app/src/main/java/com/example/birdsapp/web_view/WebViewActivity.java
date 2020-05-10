package com.example.birdsapp.web_view;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.birdsapp.R;
import com.example.birdsapp.wiki.activity.WikiActivity;

public class WebViewActivity extends AppCompatActivity {

    public final static String URL_KEY = "url";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        String url = getIntent().getStringExtra(URL_KEY);
        if (url.length() > 0) {
            webView = (WebView) findViewById(R.id.web_view);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
            startActivity(new Intent(getApplicationContext(), WikiActivity.class));
        }
    }
}
