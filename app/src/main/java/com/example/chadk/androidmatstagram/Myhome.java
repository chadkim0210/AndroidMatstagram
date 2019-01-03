package com.example.chadk.androidmatstagram;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Myhome extends AppCompatActivity {

    private static final int REQUEST_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myhome);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            return;
        }

        String userID = extras.getString("userId");

        final TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setText(userID);
    }

    // 에딧 버튼 클릭시 내 정보 수정화면으로 가는 인텐트
    // 반환값을 가지는 인텐트
    public void toEdit(View view) {
        Intent i = new Intent(this, EditProfile.class);
        startActivityForResult(i, REQUEST_CODE);
    }

    // 회원가입이 완료되고 다시 로그인 화면으로 돌아올때 ID값을 반환받을 수 있는 메서드
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == REQUEST_CODE) && (resultCode == RESULT_OK)) {
            // nickname 받기
            TextView textView7 = (TextView) findViewById(R.id.textView7);
            String nickName = data.getExtras().getString("nickName");
            textView7.setText(nickName);

            // greeting 받기
            TextView textView6 = (TextView) findViewById(R.id.textView6);
            String greeting = data.getExtras().getString("greeting");
            textView6.setText(greeting);

            // 프사 받기

        }
    }






}
