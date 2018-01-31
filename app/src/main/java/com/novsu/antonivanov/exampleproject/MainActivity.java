package com.novsu.antonivanov.exampleproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.novsu.antonivanov.exampleproject.CustomBehavior.CustomBehaviorActivity;
import com.novsu.antonivanov.exampleproject.SharingFB.SharingFBActivity;
import com.novsu.antonivanov.exampleproject.TestNotification.NotificationActivity;
import com.novsu.antonivanov.exampleproject.WebView.WebViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoCustomBehavior = (Button) findViewById(R.id.buttonGoCustomBehavior);
        if (btnGoCustomBehavior != null)
            btnGoCustomBehavior.setOnClickListener(this);

        Button btnGoNotification = (Button) findViewById(R.id.buttonGoTestNotification);
        if (btnGoNotification != null)
            btnGoNotification.setOnClickListener(this);

        Button btnGoWebView = (Button) findViewById(R.id.buttonGoTestWebView);
        if (btnGoWebView != null)
            btnGoWebView.setOnClickListener(this);

        Button btnGoSharingFB = (Button) findViewById(R.id.buttonGoSharingFB);
        if (btnGoSharingFB != null)
            btnGoSharingFB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonGoCustomBehavior:
                goActivityCustomBehavior();
                break;
            case R.id.buttonGoTestNotification:
                goActivityNotification();
                break;
            case R.id.buttonGoTestWebView:
                goActivityWebView();
                break;
            case R.id.buttonGoSharingFB:
                goActivitySharingFB();
                break;
        }
    }

    private void goActivityCustomBehavior(){
        Intent intent = new Intent(this, CustomBehaviorActivity.class);
        startActivity(intent);
    }

    private void goActivityNotification(){
        Intent intent = new Intent(this, NotificationActivity.class);
        startActivity(intent);
    }

    private void goActivityWebView(){
        Intent intent = new Intent(this, WebViewActivity.class);
        startActivity(intent);
    }

    private void goActivitySharingFB(){
        Intent intent = new Intent(this, SharingFBActivity.class);
        startActivity(intent);
    }
}
