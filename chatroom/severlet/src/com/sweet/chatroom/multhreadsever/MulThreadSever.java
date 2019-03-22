package com.sweet.chatroom.multhreadsever;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Author:sweet
 * Created:2019/3/9
 * <p>
 * 1.对于可变的数字或值（端口号）不采用硬编码（不写死）：1.main方法中参数传入2.命令行交互式传入3.属性文件
 */
public class MulThreadSever {
    //  public static final Map<Socket,String> CLIENT_MAP=new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try {
            Integer port = 6667;
            if (args.length >= 1) {
                try {
                    port = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    System.out.println("端口号有误，采用默认端口号" + port);
                    port = 6667;
                }
            }
            //1.创建客户端，绑定端口号
            ServerSocket sever = new ServerSocket(port);
            System.out.println("等待客户端连接");
            //2.接收客户端连接
            while (true) {
                Socket client = sever.accept();

                //3.通过线程池分发任务
                ExecutorService executorService = Executors.newFixedThreadPool(5);
                System.out.println("客户端已连接上服务端，端口号为" + client.getPort());
                executorService.submit(new HandlerClient(client));
            }
            //IO密集型任务=2*nCPU
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
