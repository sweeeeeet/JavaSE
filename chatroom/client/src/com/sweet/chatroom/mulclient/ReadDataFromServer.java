package com.sweet.chatroom.mulclient;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:sweet
 * Created:2019/3/12
 *
 * 读取服务端的数据
 */
public class ReadDataFromServer extends Thread {
    public final Socket client;
    public ReadDataFromServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            InputStreamReader clientread=new InputStreamReader(client.getInputStream())   ;
        Scanner scanner=new Scanner(clientread);
       while (true){
           String message=scanner.nextLine();
           System.out.println(message);
           System.out.print("请输入>>");
       }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
