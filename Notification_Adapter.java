package com.example.miphy_navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Notification_Adapter extends RecyclerView.Adapter<Notification_MyHolder> {

    Context c;
    ArrayList<Notification_Model> notification_models;

    public Notification_Adapter(Context c, ArrayList<Notification_Model> notification_models) {
        this.c = c;
        this.notification_models = notification_models;
    }

    @NonNull
    @Override
    public Notification_MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_row,null);
        return new Notification_MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Notification_MyHolder holder, int position) {

        holder.nDate.setText(notification_models.get(position).getNotification_Date());
        holder.nTitle.setText(notification_models.get(position).getNotification_Title());

    }

    @Override
    public int getItemCount() {
        return notification_models.size();
    }
}
