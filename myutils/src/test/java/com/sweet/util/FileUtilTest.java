package com.sweet.util;

import java.io.File;
import java.io.IOException;

import static  com.sweet.util.FileUtil.*;

/**
 * Author:sweet
 * Created:2018/12/9
 */
public class FileUtilTest {
    public static void main(String[] args) {
       // ls("D:\\TL-BITE\\Test\\write");
       // System.out.println(Paths.get("D:\\TL-BITE\\Test\\write\\write1").toFile().getAbsoluteFile());
       // System.out.println(isDirEmpty(Paths.get("D:\\TL-BITE\\Test\\write")));
        File file=new File("D:\\TL-BITE\\Test");
        File file1=new File("D:\\TL-BITE\\Test\\test2\\test2\\test3\\t.txt");
//        System.out.println(file.getName());
//        getAbsolutePath(file);
//        System.out.println(file.length());
//        System.out.println( exist(file));
        //System.out.println(size(file));
        try {
            mkParentDirs(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
