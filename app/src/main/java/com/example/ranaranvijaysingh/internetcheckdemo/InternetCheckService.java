package com.example.ranaranvijaysingh.internetcheckdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class InternetCheckService extends Service {

    private static final long INTERNET_CHECK_TIME_INTERVAL = 5000L;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("", "onStartCommand");
        startTimer();
        return Service.START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void startTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.i("", "run");
                new InternetCheckTask().execute();
                startTimer();
            }
        }, INTERNET_CHECK_TIME_INTERVAL);
    }
}
