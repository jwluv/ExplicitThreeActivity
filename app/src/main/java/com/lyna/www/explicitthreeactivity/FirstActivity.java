package com.lyna.www.explicitthreeactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonFirstToSecond;
    EditText editTextFirstValue;
    TextView textViewFirstResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        buttonFirstToSecond = (Button)findViewById(R.id.buttonFirstToSecondActivity);
        buttonFirstToSecond.setOnClickListener(this);

        editTextFirstValue = (EditText)findViewById(R.id.editTextFirstValue);
        textViewFirstResult = (TextView)findViewById(R.id.textViewFirstResult);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
            textViewFirstResult.setText(bundle.getString("ValueFromThirdActivity", "No Data"));
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, SecondActivity.class);
        bundle.putString("ValueFromFirstActivity", editTextFirstValue.getText().toString());
        intent.putExtras(bundle);
        startActivityForResult(intent, Activity.RESULT_FIRST_USER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Bundle bundle = data.getExtras();
        String str = "Result Values: " + bundle.getString("resultFromSecond", "No Data");
        textViewFirstResult.setText(str);

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("resultFromFirst", ((EditText)editTextFirstValue).getText().toString());
        intent.putExtras(bundle);
        setResult(Activity.RESULT_FIRST_USER, intent);
        super.finish();
    }
}
