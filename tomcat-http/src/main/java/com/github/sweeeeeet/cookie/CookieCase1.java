package com.github.sweeeeeet.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

/**
 * Author:sweet
 * Created:2019/5/24
 */


/*
* 需求：获取上一次访问的时间
*1.记录当前cookie的名称
* 2.获取指定名称的cookie
* 3.判断当前cookie是否为空{若为空：第一次当问；不为空：获取指定名称的cookie，转换为Date的值}
* 4.记录当前系统时间（创建新cookie）
* 5.由服务器将cookie携带给浏览器
* */
public class CookieCase1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter=resp.getWriter();
        //获取cookie
     Cookie cookie=   getCookieByName("lastTime",req.getCookies());
     if(cookie==null){
         printWriter.write("您是第一次访问");
     }else{
         String vale=cookie.getValue();
         //将value-->long--->Date
         long time=Long.parseLong(vale);
         Date date=new Date(time);
         printWriter.write("您上一次访问的时间是"+date);
         cookie=new Cookie("lastTime","999");

         //设置会话的有效期
         cookie.setMaxAge(3600);
         resp.addCookie(cookie);
     }
    }


    /*
    * 通过指定名称获取cookie
    * */
    public Cookie getCookieByName(String name,Cookie[] cookies){
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(name.equals(cookie)){
                    return cookie;
                }
            }
        }
        return null;
    }
}
