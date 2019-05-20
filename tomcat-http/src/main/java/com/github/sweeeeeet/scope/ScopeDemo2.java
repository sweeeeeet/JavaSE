package com.github.sweeeeeet.scope;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:sweet
 * Created:2019/5/4
 */

/*
* 从ServletContext中获取数据
* */
public class ScopeDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //通过域获取数据
   String name=(String)     getServletContext().getAttribute("name");
        System.out.println(name);
        resp.getWriter().write("ScopeDemo2获取到了数据");
    }
}
