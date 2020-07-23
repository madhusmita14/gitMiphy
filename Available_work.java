package com.example.miphy_navigation;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miphy_navigation.AvailableWorkAdapter.AvailableWorkAdapter;
import com.example.miphy_navigation.AvailableWorkModel.AvailableWorkModel;

import java.util.ArrayList;

public class Available_work extends AppCompatActivity {

    private RecyclerView avl_recyclerView;
    private AvailableWorkAdapter avl_WorkAdapter;
    private ArrayList<AvailableWorkModel> avl_Work_Coll;

    CardView available_wrk_card;
    Button confirm_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_work);

        init();

        available_wrk_card=findViewById(R.id.available_wrk_card);
       /* available_wrk_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final Dialog confirm=new Dialog(Available_work.this);
                confirm.setTitle("Are you sure to proceed");
                confirm.setContentView(R.layout.confirm_dialog);
                confirm.show();

                confirm_btn=(Button)confirm.findViewById(R.id.confirm);
                confirm_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getApplicationContext(),"confirm",Toast.LENGTH_SHORT).show();
                        confirm.dismiss();
                    }
                });

            }
        });*/

        avl_recyclerView=findViewById(R.id.availabe_work_notification_recyclerView);
        avl_recyclerView.setLayoutManager(new LinearLayoutManager(this));

        avl_WorkAdapter=new AvailableWorkAdapter(getMyList(),this);
        avl_recyclerView.setAdapter(avl_WorkAdapter);

    }

    private void init()
    {
        avl_recyclerView=(RecyclerView)findViewById(R.id.availabe_work_notification_recyclerView);
        avl_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        avl_recyclerView.setHasFixedSize(true);
        avl_Work_Coll=new ArrayList<>();
        avl_WorkAdapter=new AvailableWorkAdapter(avl_Work_Coll,this);
        avl_recyclerView.setAdapter(avl_WorkAdapter);


    }

    /*public class FetchData extends AsyncTask<Void,Void,Void>
    {
        private String avl_wrk_details_string;


        @Override
        protected Void doInBackground(Void... voids) {

            HttpsURLConnection urlConnection=null;
            BufferedReader reader=null;
            Uri buildUri=Uri.parse(getString(R.string.avl_wrk_details_api));
        }
    }*/


    private ArrayList<AvailableWorkModel> getMyList()
    {
        ArrayList<AvailableWorkModel> available_work_models=new ArrayList<>();

        AvailableWorkModel m=new AvailableWorkModel();
        m.setAvailable_work_detail("oct 2");
        available_work_models.add(m);

        /*m=new Notification_Model();
        m.setNotification_Date("oct 3");
        m.setNotification_Title("Notification 2");
        notification_models.add(m);

        m=new Notification_Model();
        m.setNotification_Date("oct 4");
        m.setNotification_Title("Notification 3");
        notification_models.add(m);*/

        return  available_work_models;


    }
}
