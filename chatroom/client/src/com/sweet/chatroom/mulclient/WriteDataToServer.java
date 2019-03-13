package com.sweet.chatroom.mulclient;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:sweet
 * Created:2019/3/12
 */
public class WriteDataToServer extends Thread{
    private  final Socket client ;
    public WriteDataToServer(Socket client){
        this.client=client;
    }
    @Override
    public void run() {
        OutputStream clientout= null;
        try {
            clientout = client.getOutputStream();
        OutputStreamWriter clientwrite=new OutputStreamWriter(clientout);
        String message;
        Scanner scanner=new Scanner(System.in);
        message=scanner.nextLine();
        clientwrite.write(  message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
