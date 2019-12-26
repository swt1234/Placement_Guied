package com.example.placement_guied_fragment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class companies extends AppCompatActivity {

    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies);
        web=findViewById(R.id.web);
        web.loadUrl("file:///android_asset/companies.html");
    }
}
