package com.llxh.basic.websocket.server;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOserver {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        //接收新的线程
        new Thread(() -> {
            while (true) {
                try {
                    //阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();
                    //每一个新的连接都创建一个线程
                    new Thread(() -> {
                        try {
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            while (true) {
                                int len;
                                //按字节流读取数据
                                while ((len = inputStream.read(data)) != -1) {
                                    System.out.println(new String(data, 0, len));
                                }
                            }
                        } catch (IOException e) {

                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
