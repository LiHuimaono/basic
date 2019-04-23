package com.llxh.basic.websocket.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class IOClient {
    public static void main(String[] args) {
        new Thread(() ->{
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true){
                    try {
                        System.out.println(new Date() + ":Hello World");
                        socket.getOutputStream().write((new Date() + ":Hello World").getBytes());
                        socket.getOutputStream().flush();
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
