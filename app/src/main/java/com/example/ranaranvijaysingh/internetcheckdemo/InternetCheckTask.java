package com.example.ranaranvijaysingh.internetcheckdemo;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class InternetCheckTask extends AsyncTask<Void, Void, Boolean> {

    private static final String GOOGLE_DNS = "8.8.8.8";
    private static final int PORT_ADDRESS = 53;

    @Override
    protected Boolean doInBackground(Void... voids) {
        return isOnline();
    }

    private Boolean isOnline() {
        try {
            int timeout = 3000;
            Socket socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(GOOGLE_DNS, PORT_ADDRESS);
            socket.connect(socketAddress, timeout);
            socket.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        MyApplication.isInternetAvailable = aBoolean;
    }
}
