package com.sweet.filestream;

import java.io.File;
import java.nio.file.Paths;

/**
 * Author:sweet
 * Created:2018/12/5
 */
public class ListFileTest {
    public static void main(String[] args) {
        File file = Paths.get("D:","TL-BITE","Test").toFile();
        File[] files=file.listFiles();
        for(File f : files){
            System.out.println(f);
        }
    }
}
