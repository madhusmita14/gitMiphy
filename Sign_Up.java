package com.example.miphy_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Sign_Up extends AppCompatActivity {

    public EditText your_name,phone,email_id,address,pass_word,confirm_password;
    Button submit;
    RadioGroup gender;
    private Spinner select_service;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

       // getSupportActionBar().setTitle("Sign Up");



        your_name=(EditText)findViewById(R.id.sign_up_your_name);
        phone=(EditText)findViewById(R.id.sign_up_ph_no);
        email_id=(EditText)findViewById(R.id.sign_up_email);
        address=(EditText)findViewById(R.id.sign_up_address);
        pass_word=(EditText)findViewById(R.id.sign_up_pass_word);
        confirm_password=(EditText)findViewById(R.id.sign_up_confirm_password);
        gender=(RadioGroup)findViewById(R.id.sign_up_gender);


        select_service=(Spinner)findViewById(R.id.select_service);
        List<String> list=new ArrayList<>();
        list.add(0,"Select Your Service");
        list.add("Saloon for Women at Home");
        list.add("House Keeping");
        list.add("Message");
        list.add("Electrician");
        list.add("Plumber");
        list.add("Painter");
        list.add("carpenter");
        list.add("Tiles/Marbles/Granite Fit");
        list.add("False/Ceiling/Pop");
        list.add("Fabrication");


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select_service.setAdapter(adapter);


        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_Up.this, Main_Screen.class);
                startActivity(intent);
            }

        });
    }
}
