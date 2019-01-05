package com.example.chadk.androidmatstagram;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class EditProfile extends AppCompatActivity {

    private final int PICK_FROM_CAMERA = 1;
    private final int PICK_FROM_GALLERY = 2;
    private ImageView imgview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        imgview = (ImageView) findViewById(R.id.imageView);
        Button btnCamera = (Button) findViewById(R.id.editProfileCamera);
        Button btnGallery = (Button) findViewById(R.id.editProfileGallery);

        btnCamera.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString());

                intent.putExtra("crop", "true");
                intent.putExtra("aspectX", 0);
                intent.putExtra("aspectY", 0);
                intent.putExtra("outputX", 200);
                intent.putExtra("outputY", 150);

                try {
                    intent.putExtra("return-data", "true");
                    startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_CAMERA);
                } catch (ActivityNotFoundException e) { }
            }
        });

        btnGallery.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);

                intent.putExtra("crop", "true");
                intent.putExtra("aspectX", 0);
                intent.putExtra("aspectY", 0);
                intent.putExtra("outputX", 200);
                intent.putExtra("outputY", 150);

                try {
                    intent.putExtra("return-data", "true");
                    startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_GALLERY);
                } catch (ActivityNotFoundException e) { }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_FROM_CAMERA) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap photo = extras.getParcelable("data");
                imgview.setImageBitmap(photo);
            }
        }
        if (requestCode == PICK_FROM_GALLERY) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap photo = extras.getParcelable("data");
                imgview.setImageBitmap(photo);
            }
        }
    }

    public void editDone(View view) {
        finish();
    }

    public void finish() {
        Intent data = new Intent();

        // 입력한 닉네임을 넘겨주는 인텐트
        EditText editNickname = (EditText) findViewById(R.id.editNickname);
        String nickName = editNickname.getText().toString();
        data.putExtra("nickName", nickName);

        // 입력한 인삿말을 넘겨주는 인텐트
        EditText editGreeting = (EditText) findViewById(R.id.editGreeting);
        String greeting = editGreeting.getText().toString();
        data.putExtra("greeting", greeting);

        //
//        Bitmap imageView = (Bitmap) findViewById(R.id.imageView);
//        Bitmap profilePhoto = BitmapFactory.decodeResource(getResources(), )
//        data.putExtra("profilePhoto", profilePhoto);

        setResult(RESULT_OK, data);
        super.finish();
    }

    Button button1 = (Button) findViewById(R.id.editProfileCamera);

}
