package com.lyna.www.explicitthreeactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonSecondToThird;
    EditText editTextSecondValue;
    TextView textViewSecondResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttonSecondToThird = (Button)findViewById(R.id.buttonSecondToThirdActivity);
        buttonSecondToThird.setOnClickListener(this);

        editTextSecondValue = (EditText)findViewById(R.id.editTextSecondValue);
        textViewSecondResult = (TextView)findViewById(R.id.textViewSecondResult);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
            editTextSecondValue.setText(bundle.getString("ValueFromFirstActivity", "No Data"));
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, ThirdActivity.class);
        bundle.putString("ValueFromSecondActivity", editTextSecondValue.getText().toString());
        intent.putExtras(bundle);
        startActivityForResult(intent, Activity.RESULT_FIRST_USER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Bundle bundle = data.getExtras();
        String str = "Result Values: " + bundle.getString("resultFromThird", "No Data");
        textViewSecondResult.setText(str);

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onFunction()", "SecondActivity: onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onFunction()", "SecondActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onFunction()", "SecondActivity: onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onFunction()", "SecondActivity: onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onFunction()", "SecondActivity: onRestart()");
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("resultFromSecond", ((EditText)editTextSecondValue).getText().toString());
        intent.putExtras(bundle);
        setResult(Activity.RESULT_FIRST_USER, intent);
        super.finish();
    }
}
