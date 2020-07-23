package com.example.miphy_navigation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.IOException;

public class Account extends AppCompatActivity {

    public EditText acc_your_Name,acc_Email,acc_Address,acc_Phone,acc_Gender,acc_Age;
    CircularImageView me_add_img;
    private static final int PICK_IMAGE=1;
    Uri imageUri;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

       assert getSupportActionBar()!=null;
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        me_add_img=(CircularImageView)findViewById(R.id.acc_add_img);
        me_add_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i,"select picture"),PICK_IMAGE);
            }
        });

        acc_your_Name=(EditText)findViewById(R.id.acc_your_name);
        acc_Email=(EditText)findViewById(R.id.acc_email);
        acc_Address=(EditText)findViewById(R.id.acc_address);
        acc_Phone=(EditText)findViewById(R.id.acc_phone);
        acc_Gender=(EditText)findViewById(R.id.acc_gender);
        acc_Age=(EditText)findViewById(R.id.acc_age);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==PICK_IMAGE && resultCode==RESULT_OK)
        {
            imageUri=data.getData();
            try
            {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
                me_add_img.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
