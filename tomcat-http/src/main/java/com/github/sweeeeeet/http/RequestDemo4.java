package com.github.sweeeeeet.http;

import com.github.sweeeeeet.tomcat.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:sweet
 * Created:2019/4/25
 */
public class RequestDemo4 extends HelloServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取user-agent请求头
        req.getHeader("user-agent");
        //获取浏览器类型
            }
}
