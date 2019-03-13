package com.sweet.chatroom.mulclient;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author:sweet
 * Created:2019/3/9
 */
public class MulClient {
    Map<Socket,String> client=new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try {
            //1.创建Socket
            String host="127.0.0.1";
            Integer port=6667;
            if(args.length==2){
           host=args[0];
           port=Integer.parseInt(args[1]);
            }
            Socket client=new Socket(host, port);

            //2.通过字符界面交互式输入，把输入的数据发送到服务器
            OutputStream clientout=client.getOutputStream();
            OutputStreamWriter clientwrite=new OutputStreamWriter(clientout);
            String message;
            Scanner scanner=new Scanner(System.in);
            message=scanner.nextLine();

            //3.读取服务端的数据
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
