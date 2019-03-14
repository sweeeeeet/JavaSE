package com.sweet.chatroom.mulclient;

import com.sun.org.apache.xalan.internal.xsltc.dom.CachedNodeListIterator;

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


    public static void main(String[] args) {
        try {
            //1.创建Socket
            String host="127.0.0.1";
            Integer port=6667;
            if(args.length==2){
                if(!host.equals(args[0])){
                    System.out.println("ip非法使用默认host"+host);
                }else if (!String.valueOf(port).equals(args[1])){
                    System.out.println("端口号非法，使用默认端口号"+port);
                }

            }else if(args.length==1){
                if(!args[0].equals(String.valueOf(port))){
                    System.out.println("端口号非法，使用默认端口号"+port);
                }
            }else{
                System.out.println("成功连接服务器！");
            }
            //创建用户Socket
             Socket client=new Socket(host,port);

            System.out.println("输入help查看操作指南");
           while(true){
                WriteDataToServer clientWrite=new WriteDataToServer(client);
           }



//实现功能
            /*
            * 客户端注册：创建Socket给服务端发送注册执行消息
            * */
            /*
            * 客户端群聊功能：客户端发送和接收消息
            * */

            /*
            * 客户端私聊，指定客户端用户，能够接收和发送消息
            * */

            /*
            * 客户端退出，
            * */

            //2.通过字符界面交互式输入，把输入的数据发送到服务器

            //3.读取服务端的数据
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
