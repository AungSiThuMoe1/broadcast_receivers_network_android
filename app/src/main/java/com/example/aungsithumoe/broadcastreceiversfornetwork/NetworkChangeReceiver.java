package com.example.aungsithumoe.broadcastreceiversfornetwork;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        if(isOnline(context))
        {
            Toast.makeText(context,"Connect",Toast.LENGTH_LONG).show();
            Log.d("Network Available ", "Flag No 1");
        }
        else
        {
            Toast.makeText(context,"No Internet Connection",Toast.LENGTH_LONG).show();
        }
    }
    public boolean isOnline(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        //should check null because in airplane mode it will be null
        return (netInfo != null && netInfo.isConnected());
    }
}