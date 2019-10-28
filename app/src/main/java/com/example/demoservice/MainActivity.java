package com.example.demoservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mButtonTestService;
    public static final String MY_ACTION = "action-do-something-that-I-want";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        mButtonTestService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MY_ACTION);
                intent.setAction(MY_ACTION);
                intent.putExtra("message", "Us against the world");
                LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(intent);
                sendBroadcast(intent);
            }
        });

    }

    private void initView() {
        mButtonTestService = findViewById(R.id.buttonService);
        BroadcastReceiver receiver = new MyBroadcastReceiver();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(MainActivity.MY_ACTION);
        this.registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
