package com.sweet.filestream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Author:sweet
 * Created:2018/12/5
 */

public class UseFile {
    public static void code1() {
        File file = new File("D:" + File.separator +
                "TL-BITE" + File.separator + "Test");
        try {
            //新建一个文件
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void code2() {

        File file = Paths.get("D:", "TL-BITE", "Test").toFile();
        if (file.exists()) {
            file.delete();
            System.out.println("删除成功");
        } else {
            System.out.println("文件不存在");
        }
    }

    public static void main(String[] args) {
        File file = Paths.get("D:", "TL-BITE", "Test","test.txt").toFile();
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path1=file.getParent();
        System.out.println(path1);//D:\TL-BITE\Test
        File f1=file.getParentFile();
        System.out.println(f1);//D:\TL-BITE\Test

    }
}
