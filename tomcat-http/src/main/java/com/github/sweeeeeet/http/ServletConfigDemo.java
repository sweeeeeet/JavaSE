package com.github.sweeeeeet.http;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:sweet
 * Created:2019/5/4
 */
public class ServletConfigDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig fig=getServletConfig();
        String path=fig.getInitParameter("path");

    }
}
