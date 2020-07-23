package com.example.miphy_navigation.AvailableWorkAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miphy_navigation.AvailableWorkModel.AvailableWorkModel;
import com.example.miphy_navigation.R;

import java.util.ArrayList;

public class AvailableWorkAdapter extends RecyclerView.Adapter<AvailableWorkAdapter.AvailableWorkHolder> {

    private ArrayList<AvailableWorkModel> avl_wrk_Data;
    private Activity avl_wk_Activity;

    public AvailableWorkAdapter(ArrayList<AvailableWorkModel> avl_wrk_data, Activity avl_wrk_activity) {

        this.avl_wrk_Data = avl_wrk_data;
        this.avl_wk_Activity = avl_wrk_activity;
    }

    public class AvailableWorkHolder extends RecyclerView.ViewHolder {

        TextView avl_wrk_details;

        public AvailableWorkHolder(@NonNull View itemView) {
            super(itemView);

            avl_wrk_details=(TextView)itemView.findViewById(R.id.avl_wrk_dtl);
        }
    }

    @NonNull
    @Override
    public AvailableWorkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.available_work_row,parent,false);
        return new AvailableWorkHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AvailableWorkHolder holder, int position) {
        AvailableWorkModel availableWorkModel =avl_wrk_Data.get(position);

        //holder.avl_wrk_details();

        holder.avl_wrk_details.setText(avl_wrk_Data.get(position).getAvailable_work_detail());

    }

    @Override
    public int getItemCount() {
        return avl_wrk_Data.size();
    }

}