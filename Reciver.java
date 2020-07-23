package com.example.miphy_navigation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class Reciver extends BroadcastReceiver {
    String body;
    String number="7978010115";

    private static final String SMS_RECEIVED="android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG="smsBroadcast";
    String msg,phone="";

    public void onReceive(Context context, Intent intent) {

        Log.i(TAG,"Intent Received"+intent.getAction());
        if(intent.getAction()==SMS_RECEIVED)
        {
            Bundle dataBundle=intent.getExtras();

            if(dataBundle!=null)
            {
                Object[] mypdu=(Object[])dataBundle.get("pdus");

                for(int i=0;i<mypdu.length;i++)
                {
                    SmsMessage messages=SmsMessage.createFromPdu((byte[])mypdu[i]);
                    body=messages.getMessageBody();
                    number=messages.getOriginatingAddress().toString();
                }
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(number,null,"Thanks for",null,null);

                Toast.makeText(context,"message"+msg+"\nphone:"+phone,Toast.LENGTH_SHORT).show();
            }
        }

    }
}

/*Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] obj = (Object[]) bundle.get("pdus");
            if (obj != null) {
                for (Object obj2 : obj) {
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) obj2);
                    this.body = smsMessage.getMessageBody().toString();
                    this.number = smsMessage.getOriginatingAddress().toString();
                }
                SmsManager smsManager = SmsManager.getDefault();
                String str = this.body;
                Object obj22 = -1;
                switch (str.hashCode()) {
                    case 2189786:
                        if (str.equals("Fine")) {
                            obj22 = 1;
                            break;
                        }
                        break;
                    case 63403084:
                        if (str.equals("And u")) {
                            obj22 = 4;
                            break;
                        }
                        break;
                    case 69609650:
                        if (str.equals("Hello")) {
                            obj22 = null;
                            break;
                        }
                        break;
                    case 181030007:
                        if (str.equals("I am Fine")) {
                            obj22 = 2;
                            break;
                        }
                        break;
                    case 181983319:
                        if (str.equals("I am fine")) {
                            obj22 = 3;
                            break;
                        }
                        break;
                    case 800828982:
                        if (str.equals("And you")) {
                            obj22 = 5;
                            break;
                        }
                        break;
                }
                switch (obj22) {
                    case null:
                        smsManager.sendTextMessage(this.number, null, "Hello,How are you? ", null, null);
                        return;
                    case 1:
                        smsManager.sendTextMessage(this.number, null, "ok ", null, null);
                        return;
                    case 2:
                        smsManager.sendTextMessage(this.number, null, "ok ", null, null);
                        return;
                    case 3:
                        smsManager.sendTextMessage(this.number, null, "ok ", null, null);
                        return;
                    case 4:
                        smsManager.sendTextMessage(this.number, null, "good ", null, null);
                        return;
                    case 5:
                        smsManager.sendTextMessage(this.number, null, "good ", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
*/
