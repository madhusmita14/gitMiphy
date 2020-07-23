package com.example.miphy_navigation;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Pending_work extends AppCompatActivity {
    CardView pndg_wrk_card;
    Button done_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_work);

        pndg_wrk_card=(CardView)findViewById(R.id.pending_wrk_card);
        pndg_wrk_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog done=new Dialog(Pending_work.this);
                done.setTitle("Have You completed your work");
                done.setContentView(R.layout.done_dialog);
                done.show();

                done_btn=(Button)done.findViewById(R.id.done_btn);
                done_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_SHORT).show();
                        done.dismiss();
                    }
                });
            }
        });
    }
}
