package com.lyna.www.explicitthreeactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonThirdToMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        buttonThirdToMain = (Button)findViewById(R.id.buttonThirdToFirstActivity);
        buttonThirdToMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }
}
