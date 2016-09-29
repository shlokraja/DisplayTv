package com.atchayam.foodbox.displaykitkat;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebDisplayActivity extends Activity {

    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webdisplay);
        String loadURL = getIntent().getStringExtra("URL_NAME");
        webView = (WebView) findViewById(R.id.webview);
        webView.clearCache(true);
        webView.clearHistory();
       // webView.getSettings().setJavaScriptEnabled(true);
        //webView.loadUrl("http://" + loadURL);
        webView.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        webView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });
        webView.clearCache(true);
        webView.loadUrl("http://" + loadURL);
        setContentView(webView );
    }
    }





