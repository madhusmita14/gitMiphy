package com.example.miphy_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.ContactsContract.ProviderStatus.STATUS;


public class Main_Screen extends AppCompatActivity {
    public TextView hv_account,sign_up,forgot_password;
    public EditText login_email,login_password;
    public Button login;
    private boolean status;
    public static final String MY_PREF="MyPref";
    public static final String STATUS="status";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__screen);

        login_email=(EditText)findViewById(R.id.login_email);
        login_password=(EditText)findViewById(R.id.login_password);

        login=(Button)findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*processing after clicking get_otp button*/
                final ProgressDialog progressDialog=new ProgressDialog(Main_Screen.this);
                progressDialog.setTitle("Processing...");
                progressDialog.setMessage("Please wait...");
                progressDialog.setCancelable(false);
                progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                    }
                }).start();
                progressDialog.show();

                /*String str_email_id=login_email.getText().toString().trim();
                String str_pass_word=login_password.getText().toString().trim();

                SharedPreferences sharedPreferences=getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
                status=sharedPreferences.getBoolean(STATUS,false);

                if(status)
                {
                    finish();
                    Intent intent = new Intent(Main_Screen.this, Main2Activity.class);
                    startActivity(intent);
                }*/

                /*SharedPreferences.Editor editor=settings.edit();
                editor.putString("",str_email_id);
                editor.commit();

                if(str_email_id.equals(""))
                {
                    Intent intent = new Intent(Main_Screen.this, Main2Activity.class);
                    startActivity(intent);
                }*/


               Intent intent = new Intent(Main_Screen.this, Main2Activity.class);
               startActivity(intent);
            }
        });

        forgot_password=(TextView)findViewById(R.id.forgot_password);
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        hv_account=(TextView)findViewById(R.id.hv_account);

        /*move to sign_up page*/
        sign_up=(TextView)findViewById(R.id.sign_up);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Sign_Up.class);
                startActivity(i);
            }
        });
    }
}
