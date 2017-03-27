package com.example.changsu.bluetoothle;

/**
 * Created by changsu on 2015-04-08.
 */

import android.os.Handler;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientThread extends Thread {

    final static int MSG_RECEIVED_MSG = 0x100;

    public Socket mSocket;
    public BufferedReader mSocketIn;
    public PrintWriter mSocketOut;

    Handler clientHandler;
    String destAddress;
    int destPort;
    String respMsg = "";

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
    byte[] buffer = new byte[1024];
    int byteRead;

    public ClientThread(Handler handler, String addr, int port)
    {
        clientHandler = handler;
        destAddress = addr;
        destPort = port;
    }

    public ClientThread(Handler handler)
    {
        clientHandler = handler;
    }


    public void run()
    {
        try
        {
            InetAddress serverAddr = InetAddress.getByName(destAddress);
            mSocket = new Socket(serverAddr, destPort);

            InputStream inputStream = mSocket.getInputStream();

            while ((byteRead = inputStream.read(buffer)) != -1)
            {
                byteArrayOutputStream.write(buffer, 0, byteRead);
                respMsg += byteArrayOutputStream.toString("UTF-8");

                sendMessageToHandler(MSG_RECEIVED_MSG, respMsg);

                Log.d("Client", "respMsg: " + respMsg);
            }

        }catch(UnknownHostException e)
        {
            e.printStackTrace();
            respMsg = "UnknownHostException: " + e.toString();
        }catch(IOException e)
        {
            e.printStackTrace();
            respMsg = "IOException: " + e.toString();
        }
    }

    public void sendMessageToHandler(int id, String recvMsg)
    {
        Message msg = Message.obtain();
        msg.what = MSG_RECEIVED_MSG;
        msg.obj = recvMsg;
        clientHandler.sendMessage(msg);
    }

}
