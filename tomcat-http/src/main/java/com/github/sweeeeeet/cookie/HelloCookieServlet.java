package com.github.sweeeeeet.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:sweet
 * Created:2019/5/24
 */
public class HelloCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        resp.setContentType("text/html;charset=utf-8");
        //2.cookie由服务器创建，并携带给浏览器
        Cookie cookie=new Cookie("akey","avalue");

        //3.由服务器写回到浏览器
        resp.addCookie(cookie);

        resp.getWriter().write("cookie已写回");

        //4.获取浏览器中存储的cookie数据
     Cookie[] cookies=   req.getCookies();
     if(cookies!=null){
         for(Cookie cookie1:cookies){
             System.out.println(cookie1);
         }
     }
    }
}
