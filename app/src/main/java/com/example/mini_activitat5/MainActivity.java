package com.example.mini_activitat5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);

        ConnectivityManager cM = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nI = cM.getActiveNetworkInfo();
        if(nI != null) {
            if(nI.getType() == ConnectivityManager.TYPE_WIFI && nI.isConnected()) {
                tv2.setText("Wifi connected!");
                tv1.setText(nI.toString());
            } else tv2.setText("Mobile connected!");
        } else tv2.setText("No network operating!");
    }
}
