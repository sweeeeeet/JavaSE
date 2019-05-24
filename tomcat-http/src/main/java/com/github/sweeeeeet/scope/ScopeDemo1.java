package com.github.sweeeeeet.scope;

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
public class ScopeDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        resp.setContentType("text/html;charset=utf-8");

        //直接获取servletContext全局管理者对象
        ServletContext context=getServletContext();
        //给域中添加数据，同时设置属性
        context.setAttribute("name","eric");

        //提示
        resp.getWriter().write("保存数据成功");
    }
}
