package com.sweet.chatroom.singleclient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:sweet
 * Created:2019/3/9
 */
public class Client {
    public static void main(String[] args) {
        try {
        //1.创建Socket，指定服务器的地址和服务端口
            //连接到本地服务器，指定服务端口号
            Socket client = new Socket("127.0.0.1", 6666);
            System.out.println("已连接到服务器，端口号是"+client.getPort());
        //2.通过Socket发送和接收数据
            //2.1Socket发送数据
            OutputStream outputStream=client.getOutputStream();
            OutputStreamWriter ow=new OutputStreamWriter(outputStream);
            ow.write("你好服务器\n");
            ow.flush();
            //2.2 Socket接收数据
            InputStream inputStream=client.getInputStream();
            InputStreamReader ir=new InputStreamReader(inputStream);
            Scanner scanner=new Scanner(ir);
            String message= scanner.nextLine();
            System.out.println(message);
        //3.关闭Socket
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
