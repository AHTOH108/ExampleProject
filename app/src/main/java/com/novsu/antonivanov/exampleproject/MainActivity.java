package com.novsu.antonivanov.exampleproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.novsu.antonivanov.exampleproject.CustomBehavior.CustomBehaviorActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoCustomBehavior = (Button) findViewById(R.id.buttonGoCustomBehavior);
        if (btnGoCustomBehavior != null)
            btnGoCustomBehavior.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonGoCustomBehavior:
                goActivityCustomBehavior();
                break;
        }
    }

    private void goActivityCustomBehavior(){
        Intent intent = new Intent(this, CustomBehaviorActivity.class);
        startActivity(intent);
    }
}
