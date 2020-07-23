package com.example.miphy_navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Payment_Adapter extends RecyclerView.Adapter<Payment_MyHolder> {

    Context c;
    ArrayList<Payment_Model> payment_models;

    public Payment_Adapter(Context c, ArrayList<Payment_Model> payment_models) {
        this.c = c;
        this.payment_models = payment_models;
    }

    @NonNull
    @Override
    public Payment_MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_row,null);

        return new Payment_MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Payment_MyHolder holder, int position) {

        holder.pReceived_from.setText(payment_models.get(position).getReceived_from());
        holder.pSender_name.setText(payment_models.get(position).getSender_name());
        holder.pPayment_date.setText(payment_models.get(position).getPayment_date());
        holder.pReceived_amt.setText(payment_models.get(position).getReceived_amt());

    }

    @Override
    public int getItemCount() {
        return payment_models.size();
    }
}
