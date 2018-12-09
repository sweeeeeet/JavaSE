package com.sweet.Buffer;

import java.io.*;

/**
 * Author:sweet
 * Created:2018/12/8
 */
public class BufferedWriterTest {
    public static void main(String[] args) {
        File file=new File("D:\\TL-BITE\\Test\\buffwrite.txt");
        FileWriter fw=null;
        BufferedWriter bw=null;
        String[] str={"锲而不舍","朽木不折"};
        try{
            fw=new FileWriter(file);
            bw=new BufferedWriter(fw);
            for(int i=0;i<str.length;i++){
                bw.write(str[i]);
                bw.newLine();//写一个结尾\n，以达到换行的目的
            }
                bw.close();
                fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
