package com.example.miphy_navigation;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Notification_MyHolder extends RecyclerView.ViewHolder {

    TextView nDate,nTitle;

    public Notification_MyHolder(@NonNull View itemView) {
        super(itemView);
        this.nDate = (TextView)itemView.findViewById(R.id.notification_date);
        this.nTitle =(TextView)itemView.findViewById(R.id.notification_title);
    }
}
