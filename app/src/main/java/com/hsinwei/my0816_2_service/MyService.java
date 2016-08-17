package com.hsinwei.my0816_2_service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import java.util.Date;

public class MyService extends Service {
    public MyService() {
    }
    private Handler handler = new Handler();
    private Runnable showTime = new Runnable() {
        @Override
        public void run() {
            Log.d("T0816-2",new Date().toString());
            handler.postDelayed(this,1000);
        }
    };
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("T0816-2", "onStartCommand()");
        handler.post(showTime);
        return Service.START_STICKY;
    }
    @Override
    public void onDestroy() {
        Log.i("T0816-2", "onDestroy()");
        handler.removeCallbacks(showTime);
        super.onDestroy();
    }
}
