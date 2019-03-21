package com.sweet.chatroom.mulclient;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

/**
 * Author:sweet
 * Created:2019/3/12
 *
 * 通过字符界面的交互式输入，把输入的数据发送到服务器
 */
public class WriteDataToServer extends Thread{
    public  final Socket client;

    public WriteDataToServer(Socket client) {
       this. client = client;
    }

    @Override
    public void run() {

        try {
            OutputStream clientout = client.getOutputStream();
        OutputStreamWriter clientwrite=new OutputStreamWriter(clientout);
        Scanner scanner=new Scanner(System.in);
            System.out.println("输入help查看操作指南");
     while(true) {
         String message;

         message = scanner.nextLine();
         clientwrite.write(message + "\n");
         clientwrite.flush();

     }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
