package com.sweet;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Author:sweet
 * Created:2018/12/4
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "TL-BITE" + File.separator + "Test");
        Path pa = Paths.get("D:", "TL-BITE", "MySQL");

        listAllFile(pa.toFile(), 0);
    }

    public static void listAllFile(File file, int level) {
        if (file.isFile()) {
            System.out.println(fileLeval(level) + "|---" + file.getName());
        } else {
            System.out.println(fileLeval(level)+"+" + file.getName());

            File[] files = file.listFiles();
            level++;
            for (File f : files) {
                if (f.isDirectory()) {
                   level++;
                    listAllFile(f, level);
                }else{
                    listAllFile(f, level);
                }

            }

        }
    }

    public static String fileLeval(int count) {
        StringBuffer space = new StringBuffer(" ");
        for (int i = 0; i < count; i++) {
            space.append(" ");
        }
        return space.toString();
    }

    public static void print(File file) {
        if (file.isFile()) {
            System.out.println("F" + "," + file.getName() + "," + file.length()
                    + "," + new Date(file.lastModified()));
        } else {
            System.out.println("D" + "," + file.getName() + "," + file.length()
                    + "," + new Date(file.lastModified()));
        }
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println("F" + "," + f.getName() + "," + f.length()
                            + "," + new Date(f.lastModified()));
                } else {
                    System.out.println("D" + "," + f.getName() + "," + f.length()
                            + "," + new Date(f.lastModified()));
                }
            }

        }
    }

    public static void tree(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    System.out.println(f.getName());
                    tree(f);
                }
            }

        } else {
            System.out.print("--");
            System.out.println(file.getName());
        }
    }
}
