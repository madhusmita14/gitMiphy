package com.example.miphy_navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Display_Active_Status extends AppCompatActivity {

    SwitchCompat switchCompat;
    TextView sw_desc;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__active__status);

        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        switchCompat=findViewById(R.id.switch_btn);
        SharedPreferences sharedPreferences=getSharedPreferences("save state",MODE_PRIVATE);
        switchCompat.setChecked(sharedPreferences.getBoolean("value",false));

        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchCompat.isChecked())
                {

                    SharedPreferences.Editor editor=getSharedPreferences("save state",MODE_PRIVATE).edit();
                    editor.putBoolean("value",true);
                    //editor.commit();
                    editor.apply();
                    switchCompat.setChecked(true);

                    Toast.makeText(getApplicationContext(),"i m active",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SharedPreferences.Editor editor=getSharedPreferences("save state",MODE_PRIVATE).edit();
                    editor.putBoolean("value",false);
                    //editor.commit();
                    editor.apply();
                    switchCompat.setChecked(false);

                    Toast.makeText(getApplicationContext(),"i m not active",Toast.LENGTH_SHORT).show();
                }
            }
        });

        sw_desc=findViewById(R.id.sw_desc);

    }
}
