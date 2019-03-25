package com.sweet.chatroom.multhreadsever;

import java.io.*;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author:sweet
 *
 * 读数据写数据，实现客户端的功能
 * Created:2019/3/13
 */
public class HandlerClient implements Runnable{
   /*
   * 维护所有的连接到服务端连接到客户端的对象
   * 希望所有的用户都装进同一个Map中，因此将并发的MAP设为静态不可变的。
   * */
    private  Socket client;
   private static final Map<String,Socket> ONLINE_CLIENT_MAP=new ConcurrentHashMap<>();
   public HandlerClient(Socket client) {
      this.client = client;
   }

   @Override
   public void run() {
       try {
           InputStream clientInputStreamientInput= client.getInputStream();
           Scanner scanner=new Scanner(clientInputStreamientInput);
           /*
           * 消息按行读取，如果1.register:
           * */
           while(true){
              String message= scanner.nextLine();
              /*
              *  System.out.println("注册功能请输入------register:<UserName>");
            System.out.println("群聊功能请输入------group:[Something you wants to say...]");
            System.out.println("私聊功能请输入------privateChat:<UserName>:[Something you wants to say]");
            System.out.println("退出功能请输入------bye");*/
               if(message.startsWith("register:")){
                   String userName=message.split(":")[1];
                   this.register(userName);
                   continue;
               }
               if(message.startsWith("group")){
                   String talk=message.split(":")[1];
                   this.groupChat(talk);
                   continue;
               }
               if(message.startsWith("privateChat")){
                   String[] segments=message.split(":");
                   String targetUserName=segments[1];
                   String information=segments[2];
                   this.privateChat(targetUserName,information);
                   continue;
               }
               if(message.startsWith("bye")){
                   this.bye();
                   continue;
               }
               if (message.startsWith("help")) {
                   StringBuilder stringBuilder=new StringBuilder();
                   stringBuilder.append("\n注册功能请输入------register:<UserName>\n")
                           .append("群聊功能请输入------group:[Something you wants to say...]\n")
                           .append("私聊功能请输入------privateChat:<UserName>:[Something you wants to say]\n")
                           .append("退出功能请输入------bye");
                  this.sendMessage(String.valueOf(stringBuilder) ,this.client,true);
               } else{
                   String err="请检查输入正确的格式";
                this.sendMessage(err,this.client,true);
               }
           }

       } catch (IOException e) {
           e.printStackTrace();
       }
   }
/*
* 当前客户端退出
* */
    private void bye() {
      for(Map.Entry<String,Socket> entry:ONLINE_CLIENT_MAP.entrySet()){
          Socket target=entry.getValue();
          if(target.equals(this.client)){
              ONLINE_CLIENT_MAP.remove(entry.getKey());
              break;
          }
      }
      printOnlineClient();

    }

    /*
* 私聊
* */
    private void privateChat(String targetUserName, String information) {
    Socket target=  ONLINE_CLIENT_MAP.get(targetUserName);
    if(target==null){
        this.sendMessage("没有这个人",this.client,true);
    }else{
        this.sendMessage(information,target,false);
    }
    }

    /*
* 群聊，发送信息
* 利用循环给每个用户发送消息
* */
    private void groupChat(String talk) {
   for(Map.Entry<String,Socket> entry:ONLINE_CLIENT_MAP.entrySet()){

       Socket target=entry.getValue();
       if(target.equals(this.client)){
           sendMessage("发送成功",this.client,false);
           continue;
       }else{
       sendMessage(talk,target,false);
       }
   }
   }


    /*
   * 以userName为用户名注册用户
   * */
    private void register(String userName) {
    ONLINE_CLIENT_MAP.put(userName,this.client);
    printOnlineClient();
    sendMessage("恭喜"+userName+"注册成功",this.client,true);
    }
private  void printOnlineClient(){
    System.out.println("当前在线人数"+ONLINE_CLIENT_MAP.size()+"用户如下列表");
    for(String userName:ONLINE_CLIENT_MAP.keySet()){
        System.out.println(userName);
    }
}

private void sendMessage(String message,Socket target,boolean isSever){
    try {
        OutputStream outputStream= target.getOutputStream();
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
            String sendPerson="服务器";
        if(isSever){
        outputStreamWriter.write(sendPerson+"消息]："+message+"\n");
        }else if(! isSever){
            sendPerson=this.getCurrentName();
        outputStreamWriter.write("来自"+sendPerson+"消息]："+message+"\n");
        }
        outputStreamWriter.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private String getCurrentName() {
        for(Map.Entry<String,Socket> entry:ONLINE_CLIENT_MAP.entrySet()){
            if(this.client==entry.getValue()){
            String name=entry.getKey();
            return name;
            }
        }
        return "";
        }
}
