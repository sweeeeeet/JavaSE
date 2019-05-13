package com.sweeeeeet;

/**
 * Author:sweet
 * Created:2019/1/19
 */
public interface OrderCenter {
    //添加订单
   void addOrder(Order order);
   //移除订单
    void removeOrder(Order order);
    //指定订单
    String orderTable(String id);
    //所有订单信息
    String ordersTable();
    //存储订单
    void storeOrders();
    //加载订单
    void loadOrders();
}
