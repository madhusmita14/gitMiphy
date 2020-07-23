package com.example.miphy_navigation;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Payment_MyHolder extends RecyclerView.ViewHolder {

    TextView pReceived_from,pSender_name,pPayment_date,pReceived_amt;

    public Payment_MyHolder(@NonNull View itemView) {
        super(itemView);

        this.pReceived_from=itemView.findViewById(R.id.payment_received_from);
        this.pSender_name=itemView.findViewById(R.id.payment_sender_name);
        this.pPayment_date=itemView.findViewById(R.id.payment_payment_date);
        this.pReceived_amt=itemView.findViewById(R.id.payment_received_amt);
    }
}
