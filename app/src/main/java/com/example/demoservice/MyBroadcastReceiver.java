package com.example.demoservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.drm.DrmStore;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(MainActivity.MY_ACTION)){
            Log.d(TAG, "nhan dien duoc MY_ACTION");
            String message = intent.getStringExtra("message");
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
        else if (intent.getAction().equals("android.intent.action.AIRPLANE_MODE")){
            Toast.makeText(context, "air plane mode", Toast.LENGTH_LONG).show();
        }
    }
}
