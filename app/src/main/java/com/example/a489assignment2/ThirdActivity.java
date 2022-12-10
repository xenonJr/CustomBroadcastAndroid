package com.example.a489assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    private WifiManager wifiManager;
    TextView gi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
         gi = findViewById(R.id.textInput);
        TextView bp = findViewById(R.id.bp);
        TextView compare = findViewById(R.id.compare_bp);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        int given_bp = 0;

     BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context ctxt, Intent intent) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                float batteryPct = level * 100 / (float) scale;
                bp.setText("Battery : "+String.valueOf(batteryPct) + "%");
            }
        };

        try {
            String input = getIntent().getStringExtra("toPrint");
            if(input!=null){
                bp.setText("Given Input: "+input);
            }
        }catch (Exception e){

        }


        try {
            int b_p = getIntent().getIntExtra("battery", -1);
            if (b_p != -1) {
                given_bp = b_p;
                this.registerReceiver(mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
                compare.setText("Your Guess was : "+ given_bp + "%");

            }
        }
        catch (Exception e){

        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiStateReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);
    }


    private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                    WifiManager.WIFI_STATE_UNKNOWN);

            switch (wifiStateExtra) {
                case WifiManager.WIFI_STATE_ENABLED:

                    gi.setText("WiFi is ON");
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    gi.setText("WiFi is OFF");
                    break;
            }
        }
    };


}