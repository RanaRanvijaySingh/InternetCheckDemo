package com.example.ranaranvijaysingh.internetcheckdemo;

import android.app.Application;
import android.content.Intent;

public class MyApplication extends Application {

    public static boolean isInternetAvailable = true;

    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(this, InternetCheckService.class));
    }
}
