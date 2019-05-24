package com.github.sweeeeeet.lifecycle;

import com.github.sweeeeeet.tomcat.HelloServlet;

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


/*
* servlet生命周期
* 创建对象
* 初识化
* void destory()销毁
*
* */
public class LifeDemo extends HttpServlet {
    public LifeDemo(){
        System.out.println("servlet对象被创建了");
    }

   /* //初始化
    *//*
    * 用户登录之前应先初始化用户登录次数
    * *//*
    @Override
    public void init() throws ServletException {

    }*/


    /*
    * config：servlet配置信息
    * */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("servlet被初始化拉");
    }

    //服务器的具体处理逻辑
  /*  @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }*/


  //业务服务方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("服务方法启动");
        try {
            Class classz=Class.forName("com.github.sweeeeeet.tomcat.HelloServlet");
            classz.getDeclaredMethod("init",ServletConfig.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    //销毁方法
    @Override
    public void destroy() {
        System.out.println("servlet被销毁了");
    }
}
