package com.sweet.chatroom.singlesever;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:sweet
 * Created:2019/3/9
 */
public class Sever {

    public static void main(String[] args) {
        try {
            //1.创建服务端绑定端口
            //创建绑定到6666端口的套接字
            ServerSocket sever=new ServerSocket(6666);
            System.out.println("等待客户端连接");
            //2.接收客户连接Socket
            Socket client=sever.accept();
            System.out.println("客户端已连接，端口号是"+client.getPort());
            //3.通过客户端接收和发送数据
            //3.1接收客户端发送的数据
            InputStream inputStream=client.getInputStream();
            InputStreamReader ir=new InputStreamReader(inputStream);
            //通过Scanner类接收客户端内容
            Scanner scanner=new Scanner(ir);
           String message= scanner.nextLine();
            System.out.println();
           //3.2 发送数据给客户端
            OutputStream outputStream=client.getOutputStream();
            OutputStreamWriter ow=new OutputStreamWriter(outputStream);
            ow.write("你好客户端，我是服务器~\n");
            ow.flush();

            //4.关闭服务端 客户端
            sever.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
