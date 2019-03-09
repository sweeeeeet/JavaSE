package com.sweet.chatroom.multhreadsever;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:sweet
 * Created:2019/3/9
 */
public class MulThreadSever {
    public static void main(String[] args) {
        try {
            //1.创建客户端，绑定端口号
            ServerSocket sever=new ServerSocket(6667);
            System.out.println("等待客户端连接");
            //2.接收客户端连接
           Socket client= sever.accept();
            System.out.println("客户端已连接上服务端，端口号为"+client.getPort());
           //3.通过线程池分发任务

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
