package com.example.miphy_navigation;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Payment extends AppCompatActivity {

    RecyclerView pRecyclerView;
    Payment_Adapter payment_adapter;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment2);

        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pRecyclerView=findViewById(R.id.payment_recyclerview);
        pRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        payment_adapter=new Payment_Adapter(this,getMyList());
        pRecyclerView.setAdapter(payment_adapter);

    }

    private ArrayList<Payment_Model> getMyList()
    {
        ArrayList<Payment_Model> payment_models=new ArrayList<>();

        Payment_Model p=new Payment_Model();
        p.setReceived_from("Received from");
        p.setSender_name("MADHUSMITA NAYAK");
        p.setPayment_date("22 oct 2019");
        p.setReceived_amt("100");
        payment_models.add(p);

        p=new Payment_Model();
        p.setReceived_from("Received from");
        p.setSender_name("ANKIT NAYAK");
        p.setPayment_date("22 oct 2019");
        p.setReceived_amt("200");
        payment_models.add(p);

        p.setReceived_from("Received from");
        p.setSender_name("NIHAR NAYAK");
        p.setPayment_date("22 oct 2019");
        p.setReceived_amt("300");
        payment_models.add(p);

        return payment_models;

    }
}
