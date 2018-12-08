package com.sweet;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Author:sweet
 * Created:2018/12/7
 */
public class SystemTest {
    public static void main(String[] args) {
        Map<String,String> env=System.getenv();
        for(String name:env.keySet()) {
            System.out.println(name+"----->"+env.get(name));
        }
        System.out.println(System.getenv("JAVA_HOME"));

        }
    }

