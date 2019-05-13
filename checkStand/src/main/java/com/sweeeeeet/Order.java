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
    private static Map<String, Integer> orderInfo = new HashMap<>();
    SimpleGoodsCenter goodsCenter = new SimpleGoodsCenter();
    private Goods goods;

   public final static String  produceID() {
        int num = (int) (Math.random() * 100000000);
        int i = 0;
        String orderId = String.valueOf(num + (i++));
       return orderId;
    }

    public Order(Goods goods) {

        this.goods = goods;

       this. orderId = produceID();
    }

    public String getOrderId() {

        return orderId;
    }

    public Map<String, Integer> getOrderInfo() {
      return  orderInfo;
    }

public StringBuilder getOrderTable(){
    StringBuilder stringBuilder=new StringBuilder();
    stringBuilder.append("商品名称\t\t商品数量\n");
    for(Map.Entry<String,Integer> entry:orderInfo.entrySet()){
        stringBuilder.append(entry.getKey()+"\t\t"+entry.getValue());
    }

    return stringBuilder;
}

    //添加商品订单
    public void add(String goodsId, Integer count) {

        //1.判断key是否存在

        //若包含文件信息加载,需将文件对象序列化

        this.goods = goodsCenter.getGoods(goodsId);
        if (goodsId.equalsIgnoreCase(goods.getId())) {


            //添加
            if(orderInfo.containsKey(goodsId)){
                //若已经包含商品，则数量加一
            count=orderInfo.get(goodsId)+1;
            orderInfo.put(goodsId, count);
            }

            orderInfo.put(goodsId, count);
            System.out.println("商品添加成功!");
        }
    }

    public void cancel(String goodsId, Integer count) {
//判断是否包含，count-1
        //count<=0-->remove
        this.goods = goodsCenter.getGoods(goodsId);
        if (goodsId.equalsIgnoreCase(goods.getId())) {
            if (orderInfo.get(goodsId) <= 0) {
                orderInfo.remove(goodsId);
                System.out.println("商品删除成功!");
            } else {
                orderInfo.put(goodsId, (orderInfo.get(goodsId) - 1));
                System.out.println("商品取消成功!");
            }
        }
    }

    public void clear() {
        orderInfo.clear();
        System.out.println("订单清除成功!");
    }

    @Override
    public String toString() {
        return  orderId;
    }
}
