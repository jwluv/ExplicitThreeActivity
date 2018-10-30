package com.lyna.www.explicitthreeactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonFirstToSecond;
    EditText editTextFirstValue;
    TextView textViewFirstReceivedValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        buttonFirstToSecond = (Button)findViewById(R.id.buttonFirstToSecondActivity);
        buttonFirstToSecond.setOnClickListener(this);

        editTextFirstValue = (EditText)findViewById(R.id.editTextFirstValue);
        textViewFirstReceivedValue = (TextView)findViewById(R.id.textViewFirstReceivedValue);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
            textViewFirstReceivedValue.setText(bundle.getString("ValueFromThirdActivity", "No Data"));
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, SecondActivity.class);
        bundle.putString("ValueFromFirstActivity", editTextFirstValue.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
