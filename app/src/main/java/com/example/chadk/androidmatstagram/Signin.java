package com.example.chadk.androidmatstagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signin extends AppCompatActivity {
    private static final int REQUEST_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    // 로그인 클릭시 마이홈으로 가는 인텐트
    public void onClick(View view) {
        Intent i = new Intent(this, Myhome.class);

        final EditText editText = (EditText) findViewById(R.id.editText8);
        String userID = editText.getText().toString();
        i.putExtra("userId", userID);
        startActivity(i);
    }

    // 회원가입 버튼 클릭시 회원가입화면으로 가는 인텐트
    // 반환값을 가지는 인텐트
    public void toSignup(View view) {
        Intent i = new Intent(this, Signup.class);
        startActivityForResult(i, REQUEST_CODE);
    }

    // 회원가입이 완료되고 다시 로그인 화면으로 돌아올때 ID값을 반환받을 수 있는 메서드
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == REQUEST_CODE) && (resultCode == RESULT_OK)) {
            EditText editText8 = (EditText) findViewById(R.id.editText8);
            String returnString = data.getExtras().getString("returnData");
            editText8.setText(returnString);
        }
    }
}
