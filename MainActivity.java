package com.example.miphy_navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int SPLASH_TIMEOUT=2000;

    ImageView miphy_logo;
    TextView miphy,responder_alise,copyright;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miphy_logo=(ImageView)findViewById(R.id.mainscreen_miphy_logo);
        miphy=(TextView)findViewById(R.id.miphy);
        responder_alise=(TextView)findViewById(R.id.responder_alice);
        copyright=(TextView)findViewById(R.id.copy_right);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(getApplicationContext(),Main_Screen.class);
                startActivity(i);
                finish();

            }
        },SPLASH_TIMEOUT);
    }
}
