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
     while(true) {
         String message;
         message = scanner.nextLine();
         clientwrite.write(message + "\n");
         clientout.flush();


//          if (message.startsWith("group")) {
//             System.out.println("【发送消息给所有用户】" + message.split(":")[1]);
//         } else if (message.startsWith("privateChat")) {
//             System.out.println("【发送消息给所有用户】" + message.split(":")[2]);
//         } else {
//             System.out.println("【发消息给客户端】" + message);
//         }
     }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
