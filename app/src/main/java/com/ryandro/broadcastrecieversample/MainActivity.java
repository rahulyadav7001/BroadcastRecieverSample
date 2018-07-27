package com.ryandro.broadcastrecieversample;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyBroadCastReciever myBroadCastReciever;
    private String ACTION = "com.ryandro.broadcastrecieversample.SOME_ACTION";
    IntentFilter filter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_sendBroadCast = (Button) findViewById(R.id.btn_sendBroadCast);
//        filter = new IntentFilter("com.journaldev.broadcastreceiver.SOME_ACTION");
        filter = new IntentFilter("com.ryandro.broadcastrecieversample.SOME_ACTION");

        btn_sendBroadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent = new Intent();
                intent.setAction(ACTION);
                sendBroadcast(intent);*/
//                Intent intent = new Intent("com.journaldev.broadcastreceiver.SOME_ACTION");
                Intent intent = new Intent("com.ryandro.broadcastrecieversample.SOME_ACTION");

                sendBroadcast(intent);
            }
        });
//        myBroadCastReciever = new MyBroadCastReciever();

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myBroadCastReciever, filter);

    }
   /* @Override
    protected void onStart() {
        super.onStart();
//        IntentFilter intent = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(myBroadCastReciever, new IntentFilter(ACTION));
    }
*/
    @Override
    protected void onStop() {
        super.onStop();
//        unregisterReceiver(myBroadCastReciever);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(myBroadCastReciever);
    }

}
