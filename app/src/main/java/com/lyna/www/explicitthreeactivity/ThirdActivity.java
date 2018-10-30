package com.lyna.www.explicitthreeactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonThirdToMain;
    EditText editTextThirdValue;
    TextView textViewThirdReceivedValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        buttonThirdToMain = (Button)findViewById(R.id.buttonThirdToFirstActivity);
        buttonThirdToMain.setOnClickListener(this);

        editTextThirdValue = (EditText)findViewById(R.id.editTextThirdValue);
        textViewThirdReceivedValue = (TextView)findViewById(R.id.textViewThirdReceivedValue);

        Bundle bundle = getIntent().getExtras();
        textViewThirdReceivedValue.setText(bundle.getString("ValueFromSecondActivity", "No Data"));
    }

    @Override
    public void onClick(View v) {
        //Bundle bundle = new Bundle();
        Intent intent = new Intent(this, FirstActivity.class);
       // bundle.putString("ValueFromThirdActivity", editTextThirdValue.getText().toString());
        //intent.putExtras(bundle);
        startActivity(intent);
    }
}
