package com.example.demoservice;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class TestService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("hieuvh", "onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("hieuvh", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("hieuvh", "onStartCommand");
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("hieuvh", "onConfigurationChanged");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("hieuvh", "onDestroy");
    }
}
