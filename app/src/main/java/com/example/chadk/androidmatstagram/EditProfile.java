package com.example.chadk.androidmatstagram;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditProfile extends AppCompatActivity {

    private final int CAMERA_CODE = 1111;
    private final int REQUEST_PERMISSION_CODE = 2222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }

    public void editDone(View view) {
        finish();
    }

    public void finish() {
        Intent data = new Intent();

        EditText editNickname = (EditText) findViewById(R.id.editNickname);
        String nickName = editNickname.getText().toString();
        data.putExtra("nickName", nickName);

        EditText editGreeting = (EditText) findViewById(R.id.editGreeting);
        String greeting = editGreeting.getText().toString();
        data.putExtra("greeting", greeting);

        Bitmap imageView = (Bitmap) findViewById(R.id.imageView);
        Bitmap profilePhoto = BitmapFactory.decodeResource(getResources(), )
        data.putExtra("profilePhoto", profilePhoto);

        setResult(RESULT_OK, data);
        super.finish();
    }
}
