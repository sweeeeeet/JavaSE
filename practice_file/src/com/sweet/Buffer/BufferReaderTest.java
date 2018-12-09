package com.sweet.Buffer;

import java.io.*;

/**
 * Author:sweet
 * Created:2018/12/8
 */
public class BufferReaderTest {
    public static void main(String[] args) {
        File file=new File("D:\\TL-BITE\\Test\\write.txt");
        Reader read=null;
        String str="";
        BufferedReader bin=null;
        try{
           read=new FileReader(file);
           bin=new BufferedReader(read);
           str=bin.readLine();

        }catch (IOException e){

        }
        System.out.print(str);
    }
}
