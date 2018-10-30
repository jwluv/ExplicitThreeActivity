package com.lyna.www.explicitthreeactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonSecondToThird;
    EditText editTextSecondValue;
    TextView textViewSecondReceivedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttonSecondToThird = (Button)findViewById(R.id.buttonSecondToThirdActivity);
        buttonSecondToThird.setOnClickListener(this);

        editTextSecondValue = (EditText)findViewById(R.id.editTextSecondValue);
        textViewSecondReceivedValue = (TextView)findViewById(R.id.textViewSecondReceivedValue);

        Bundle bundle = getIntent().getExtras();
        textViewSecondReceivedValue.setText(bundle.getString("ValueFromFirstActivity", "No Data"));
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, ThirdActivity.class);
        bundle.putString("ValueFromSecondActivity", editTextSecondValue.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
