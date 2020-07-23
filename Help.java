package com.example.miphy_navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Help extends AppCompatActivity {

    EditText help_edit_text;
    Button help_send;

    public static final int MY_PERMISSION_REQUEST_RECEIVE_SMS=0;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        help_edit_text=(EditText)findViewById(R.id.help_edit_text);

        help_send=(Button)findViewById(R.id.help_send);
        help_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String get_help_txt=help_edit_text.getText().toString();

                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL,new String[]{"madhusmitanayak14@gmail.com"});
                i.putExtra(Intent.EXTRA_TEXT,get_help_txt);
                try {
                    startActivity(Intent.createChooser(i,"madhusmitanayak14@gmail.com"));
                }
                catch (android.content.ActivityNotFoundException ex)
                {
                    Toast.makeText(Help.this,"Error",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
