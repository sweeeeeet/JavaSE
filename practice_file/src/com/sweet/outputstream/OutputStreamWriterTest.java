package com.sweet.outputstream;

import java.io.*;

/**
 * Author:sweet
 * Created:2018/12/8
 */
public class OutputStreamWriterTest {
    public static void main(String[] args) {
        File file = new File("D:\\TL-BITE\\Test\\test1\\otptsmwriter.txt");
       if(!file.getParentFile().exists()){
           file.getParentFile().mkdirs();
       }
       try(
        OutputStream outputStream=new FileOutputStream(file);
        Writer writer=new OutputStreamWriter(outputStream)
        ){
           String msg="I 老虎 U！ !!";
           writer.write(msg);

       }catch (IOException e){

       }

    }
}
