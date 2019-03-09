package com.sweet.chatroom.mulclient;

import java.io.IOException;
import java.net.Socket;

/**
 * Author:sweet
 * Created:2019/3/9
 */
public class MulClient {
    public static void main(String[] args) {
        try {
            //1.创建Socket
            Socket client=new Socket("127.0.0.1", 6667);
            //2.通过字符界面交互式输入，把输入的数据发送到服务器
            //3.读取服务端的数据
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
