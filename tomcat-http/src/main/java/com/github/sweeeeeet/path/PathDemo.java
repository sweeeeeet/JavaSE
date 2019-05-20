package com.github.sweeeeeet.path;

import com.sun.xml.internal.ws.transport.http.HttpAdapter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:sweet
 * Created:2019/5/4
 */
public class PathDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context=getServletContext();
        context.getRealPath("a.txt");

        //其他获取路径的方法
        PathDemo.class.getClassLoader().getResource("a.txt");
    }
}
