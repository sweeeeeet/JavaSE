package com.sweeeeeet;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:sweet
 * Created:2019/1/19
 */
public class Order {
    //订单Order创建完成后订单编号不能修改
    private final String orderId;
    //订单Order创建完成后,属性信息实例化
    private final Map<String,Integer> orderInfo=new HashMap<>();

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public Map<String, Integer> getOrderInfo() {
        return orderInfo;
    }

    //添加商品订单
    public void add(String goodsId,Integer count){
  int sum;
    //1.判断key是否存在
        if(orderInfo.containsKey(goodsId)){

        }
        //添加
    }
    public void cancel(String goodsId,Integer count){
//判断是否包含，count-1
        //count<=0-->remove
    }
    public void clear(){

    }
}
