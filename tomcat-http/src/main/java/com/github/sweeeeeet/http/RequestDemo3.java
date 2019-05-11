package com.github.sweeeeeet.http;

import com.github.sweeeeeet.tomcat.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;

/**
 * Author:sweet
 * Created:2019/4/25
 */
public class RequestDemo3 extends HelloServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get方式与post获取参数数据完全不同
        String queryString=req.getQueryString();
        //post方式获取参数
     InputStream in=   req.getInputStream();
        byte[] bytes=new byte[1024];
        int len=in.read(bytes);
        while(len!=-1){
            System.out.println(new String(bytes,1,len));
        }
        //通过表单的name参数值获取表单内容，因此html中的表单一定要定义表单属性
     Enumeration<String> enums= req.getParameterNames();
      String name=  req.getParameter("name");
      name=new String(name.getBytes("iso-8859-1"),"utf-8");
  req.setCharacterEncoding("utf-8");

     Map<String,String[]> paraMap= req.getParameterMap();

    String[] habits= req.getParameterValues("habit");
    }
}