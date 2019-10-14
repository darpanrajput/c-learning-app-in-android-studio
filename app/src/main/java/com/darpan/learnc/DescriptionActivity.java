package com.darpan.learnc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class DescriptionActivity extends AppCompatActivity {
    WebView webView;
    String url, gettitle;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        webView = findViewById(R.id.webview);
        Intent intent = getIntent();
        gettitle = intent.getStringExtra("title");
        getData();

    }
    private void getData()
    {
        a = gettitle.replaceAll("\\s+", "");
        url = "file:///android_asset/cintro/" + a + ".html";
        webView.loadUrl(url);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);


    }
}
