package com.ryandro.broadcastrecieversample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class MyBroadCastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {/*
        Log.d("BroadCast Receiver","On Received Method Invoked");
        Toast.makeText(context, "Broadcast reciever called", Toast.LENGTH_SHORT).show();
   */
        {



            Log.d("API123",""+intent.getAction());

//            if(intent.getAction().equals("com.journaldev.broadcastreceiver.SOME_ACTION"))
            if(intent.getAction().equals("com.ryandro.broadcastrecieversample.SOME_ACTION"))

                Toast.makeText(context, "SOME_ACTION is received", Toast.LENGTH_LONG).show();

            else {
                ConnectivityManager cm =
                        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                boolean isConnected = activeNetwork != null &&
                        activeNetwork.isConnectedOrConnecting();
                if (isConnected) {
                    try {
                        Toast.makeText(context, "Network is connected", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(context, "Network is changed or reconnected", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
