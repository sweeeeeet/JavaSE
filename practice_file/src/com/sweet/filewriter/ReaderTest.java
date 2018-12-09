package com.sweet.filewriter;

import java.io.*;
import java.nio.file.Paths;

/**
 * Author:sweet
 * Created:2018/12/8
 */
public class ReaderTest {
    public static void read1() {
        File file = Paths.get("D:", "TL-BITE", "Test", "write.txt").toFile();
        if(file.exists()){
            long start=System.currentTimeMillis();
            try(Reader in=new FileReader(file)){
                char[] date=new char[3];
                int len=-1;

                while((len=in.read(date))!=-1){
                    for(char i: date){
                        System.out.println(i);
                    }
                }
                long end=System.currentTimeMillis();
                System.out.println("读取成功,花费了"+(end-start));
            }  catch (IOException e){
                System.out.println("读取失败");
                e.printStackTrace();

            }
        }

    }

    public static void code3() {
        File srcFile=new File("D:\\TL-BITE\\Test\\write1.txt");
        File desFile=new File("D:\\TL-BITE\\Test\\writeread1.txt");
        try(Reader in=new FileReader(srcFile);
            Writer out=new FileWriter(desFile)){
            char[] buff=new char[1024];
            int len=-1;
            out.write("文件开始\n");
            while((len=in.read(buff))!=-1){
                out.write(buff,0,len);
            }
            out.write("\n读取的文件写入结束");
        }catch (IOException e){
            System.out.println("写入失败");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        File srcFile=new File("D:\\TL-BITE\\Test\\write1.txt");
        File desFile=new File("D:\\TL-BITE\\Test\\writeread1.txt");
        try (Writer writer=new FileWriter(desFile);
        Reader reader=new FileReader(srcFile)){
            char[] buff=new char[3];
            int len=-1;
            //len-->真正读取的内容长度
            while ((len=reader.read(buff))!=-1){
                writer.write(buff,0,len);
                // writer.write(buff);
                // 不添加写入方法的两个参数,就会将每次都读到的三个字符数组写入,最终写入结果会有出入
            }
        }catch (IOException e ){
            e.printStackTrace();
        }
           }
}
