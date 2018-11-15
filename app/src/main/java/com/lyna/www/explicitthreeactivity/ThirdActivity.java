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

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonThirdToMain;
    EditText editTextThirdValue;
    TextView textViewThirdResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        buttonThirdToMain = (Button)findViewById(R.id.buttonThirdToFirstActivity);
        buttonThirdToMain.setOnClickListener(this);

        editTextThirdValue = (EditText)findViewById(R.id.editTextThirdValue);
        textViewThirdResult = (TextView)findViewById(R.id.textViewThirdResult);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
            editTextThirdValue.setText(bundle.getString("ValueFromSecondActivity", "No Data"));
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, FirstActivity.class);
        bundle.putString("ValueFromThirdActivity", editTextThirdValue.getText().toString());
        intent.putExtras(bundle);
        startActivityForResult(intent, Activity.RESULT_FIRST_USER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Bundle bundle = data.getExtras();
        String str = "Result Values: " + bundle.getString("resultFromFirst", "No Data");
        textViewThirdResult.setText(str);

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onFunction()", "ThirdActivity: onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onFunction()", "ThirdActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onFunction()", "ThirdActivity: onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onFunction()", "ThirdActivity: onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onFunction()", "ThirdActivity: onRestart()");
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("resultFromThird", ((EditText)editTextThirdValue).getText().toString());
        intent.putExtras(bundle);
        setResult(Activity.RESULT_FIRST_USER, intent);
        super.finish();
    }
}
