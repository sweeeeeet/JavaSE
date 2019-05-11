package com.github.sweeeeeet.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:sweet
 * Created:2019/4/25
 */
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //重定向原理
//       设置状态302
        resp.setStatus(302);
        //设置location响应头
        resp.setHeader("location","adv.html");

        //重定向简便方式：
        resp.sendRedirect("");
        //请求转发
        req.getRequestDispatcher("adv.html").forward(req,resp);

        //设置响应头，没经过n秒后刷新
        resp.setHeader("Refresh","2");
        //设置编码格式
        resp.setContentType("TEXT/HTML;charset=utf-8");
    }
}
