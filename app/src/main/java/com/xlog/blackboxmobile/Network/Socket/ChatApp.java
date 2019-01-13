package com.xlog.blackboxmobile.Network.Socket;

import android.app.Application;


import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;


public class ChatApp extends Application {

    private Socket mSocket;

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            mSocket = IO.socket(Constants.CHAT_SERVER_URL);
        } catch (URISyntaxException e) {}


    }

    public Socket getSocket() {
        return mSocket;
    }

}