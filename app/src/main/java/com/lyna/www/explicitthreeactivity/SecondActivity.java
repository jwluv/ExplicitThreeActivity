package com.lyna.www.explicitthreeactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonSecondToThird;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttonSecondToThird = (Button)findViewById(R.id.buttonSecondToThirdActivity);
        buttonSecondToThird.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}
