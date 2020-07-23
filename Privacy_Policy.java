package com.example.miphy_navigation;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Privacy_Policy extends AppCompatActivity {

    ImageView privacy_policy_miphy_logo;
    TextView plz_read_our_txt,privacy_policy_txt,before_continue_txt;
    Button privacy_policy_proceed;


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy__policy);

        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        privacy_policy_miphy_logo=(ImageView)findViewById(R.id.privacy_policy_miphy_logo);

        plz_read_our_txt=(TextView)findViewById(R.id.please_read_our_text);

        privacy_policy_txt=(TextView)findViewById(R.id.privacy_policy_text);
        privacy_policy_txt.setMovementMethod(LinkMovementMethod.getInstance());
        privacy_policy_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent=new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("http://scapematrix.com/projects/miphy/privacy-policy/"));
                startActivity(browserIntent);
            }
        });

        before_continue_txt=(TextView)findViewById(R.id.before_continue_text);

        privacy_policy_proceed=(Button)findViewById(R.id.privacy_policy_proceed);
        privacy_policy_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });
    }

}
