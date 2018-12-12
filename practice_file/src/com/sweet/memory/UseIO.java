package com.sweet.memory;

import java.io.*;
import java.nio.file.Paths;

/**
 * Author:sweet
 * Created:2018/12/10
 */
public class UseIO {
    public static void exchange() {
        String str = "Hello world";
        try (ByteArrayOutputStream bo = new ByteArrayOutputStream();
             ByteArrayInputStream bi = new ByteArrayInputStream(str.getBytes())) {
            //设置缓冲字节数组
            byte[] buff = new byte[3];
            int len = -1;
            int count = 0;
            //读取buff数组（一次读三个，分批读）
            while ((len = bi.read(buff)) != -1) {
                for (int i = 0; i < buff.length; i++) {
                    byte b = buff[i];
                    if (b > 'a' && b < 'z') {
                        count++;
                        buff[i] = (byte) (b - 32);
                    }
                }
                bo.write(buff, 0, len);
            }
            byte[] newStr = bo.toByteArray();
            System.out.println(new String(newStr));
            System.out.println("转换次数" + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = Paths.get("D:", "TL-BITE", "Test", "write1.txt").toFile();
        File file1 = Paths.get("D:", "TL-BITE", "Test", "write2.txt").toFile();
        File file2 = Paths.get("D:", "TL-BITE", "Test", "write.txt").toFile();
        try (FileInputStream fi1 = new FileInputStream(file);
             FileInputStream fi2 = new FileInputStream(file1);
             FileOutputStream fo = new FileOutputStream(file2);
             ByteArrayOutputStream bo = new ByteArrayOutputStream()
        ) {
            byte[] buff = new byte[3];
            int len = -1;
            while ((len = fi1.read(buff)) != -1) {
                bo.write(buff, 0, len);
            }
            while ((len = fi2.read(buff)) != -1) {
                bo.write(buff, 0, len);
            }
            fo.write(bo.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
