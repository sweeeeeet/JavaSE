package com.github.sweeeeeet.http;

import javax.naming.CompositeName;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Author:sweet
 * Created:2019/5/4
 */

/*
* ServletContext作用1：获取上下文路径
* */
public class ContextDemo extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取上下文路径
        ServletContext context=this.getServletContext();
        //请求转发
        resp.sendRedirect(req.getContextPath()+"/hello.html");
        //
   RequestDispatcher rd= context.getRequestDispatcher("/hello.html");
   rd.forward(req,resp);
   req.getRequestDispatcher("hello.html").forward(req,resp);

        //获取全局参数
        ServletContext  context1=getServletContext();

     String con=   context1.getInitParameter("name");
     Enumeration<String> s= context1.getAttributeNames();
    }
}
