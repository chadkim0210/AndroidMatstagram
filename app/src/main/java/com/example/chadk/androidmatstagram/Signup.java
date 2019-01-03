package com.example.chadk.androidmatstagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void toSignin(View view) {
        finish();
    }

    public void finish() {
        Intent data = new Intent();

        EditText editText = (EditText) findViewById(R.id.editText);

        String returnString = editText.getText().toString();
        data.putExtra("returnData", returnString);

        setResult(RESULT_OK, data);
        super.finish();
    }
}
