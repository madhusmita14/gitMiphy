package com.example.miphy_navigation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import static androidx.core.app.NotificationCompat.BADGE_ICON_SMALL;

public class Notifications extends AppCompatActivity {

    RecyclerView n_recyclerView;
    Notification_Adapter notification_adapter;
    Toolbar toolbar_logo;
    ImageView notification_img_toolbar;

    Button addnotification;
    Bitmap bitmap;

    static int count = 0 ;

    @Override
    protected void onResume () {
        super.onResume() ;
        count = 0 ;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        toolbar_logo=(Toolbar)findViewById(R.id.toolbar_logo_id);
        setSupportActionBar(toolbar_logo);

        notification_img_toolbar=(ImageView)findViewById(R.id.notification_img_toolbar);
        notification_img_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });

        addnotification = (Button) findViewById(R.id.addnbtn);
        addnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNotification();
            }
        });

        n_recyclerView=findViewById(R.id.notification_recyclerView);
        n_recyclerView.setLayoutManager(new LinearLayoutManager(this));

        notification_adapter=new Notification_Adapter(this,getMyList());
        n_recyclerView.setAdapter(notification_adapter);
    }

    //Create Notification
    private void addNotification() {

        count++;
        Intent notificationIntent = new Intent(getApplicationContext() , MainActivity. class ) ;
        notificationIntent.putExtra( "fromNotification" , true );
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP ) ;

        NotificationManager mNotificationManager =
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Uri soundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.ic_notifications_active_red_24dp);
        mBuilder.setContentTitle("one work is assign to you");
        mBuilder.setSound(soundUri);
        mBuilder.setOngoing(false);
        mBuilder.setAutoCancel(true);
        mBuilder.setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE);
        mBuilder.setNumber(count);


        PendingIntent pendingIntent=
                PendingIntent.getActivity(this,0,new Intent(this,Available_work.class),
                        PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingIntent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            final String NOTIFICATION_CHANNEL_ID = "1001";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                    "NOTIFICATION_CHANNEL_NAME", importance);
            mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
            mNotificationManager.createNotificationChannel(notificationChannel);

            assert mNotificationManager != null;
            mNotificationManager.notify((int)System.currentTimeMillis(),mBuilder.build());
        }
    }//

    private ArrayList<Notification_Model> getMyList()
    {
        ArrayList<Notification_Model> notification_models=new ArrayList<>();

        Notification_Model m=new Notification_Model();
        m.setNotification_Date("oct 2");
        m.setNotification_Title("Notification 1");
        notification_models.add(m);

        m=new Notification_Model();
        m.setNotification_Date("oct 3");
        m.setNotification_Title("Notification 2");
        notification_models.add(m);

        m=new Notification_Model();
        m.setNotification_Date("oct 4");
        m.setNotification_Title("Notification 3");
        notification_models.add(m);

        return  notification_models;


    }
}
