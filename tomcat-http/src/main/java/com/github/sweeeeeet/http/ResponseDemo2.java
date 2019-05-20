package com.github.sweeeeeet.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Author:sweet
 * Created:2019/4/26
 */
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file=new File("");
        //以下载方式打开资源
        resp.setHeader("Content-Disposition","attachment;filename="+file.getName());
        //下载文件
        //创建字节流输入对象
        InputStream in=new FileInputStream(file);
        //获取字节输出流对象
        OutputStream out=resp.getOutputStream();
        //边读边写
        byte[] buff=new byte[1024];
        int len=0;
        while((len=in.read(buff))!=-1){
            out.write(buff,0,len);
        }
        in.close();
        out.close();
    }
}
