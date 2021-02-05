package com.hashaan.amsce;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;

import android.os.Bundle;

import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    private WebView mywebView;
    private String url = "https://www.aalimec.ac.in/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mywebView = (WebView) findViewById(R.id.webview);
        mywebView.loadUrl(url);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");



        WebSettings webSettings=mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mywebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                progressDialog.show();


                if (newProgress == 100) {
                    progressDialog.dismiss();
                }


                super.onProgressChanged(view, newProgress);
            }

        });

        mywebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }










        });
    }



    @Override
    public void onBackPressed() {
        if(mywebView.canGoBack() ) {
            mywebView.goBack();
        } else{
            super.onBackPressed();
        }
    }

}