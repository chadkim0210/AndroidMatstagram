package com.example.chadk.androidmatstagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        public void onClick(View view) {
            Intent i = new Intent(this, Myhome.class);

            final EditText editText8 = (EditText) findViewById(R.id.editText8);
            String userID = editText8.getText().toString();
            i.putExtra("UserId", userID);
            startActivity(i);
        }
    }
}
