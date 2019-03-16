package com.sweeeeeet;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Author:sweet
 * Created:2019/1/19
 */
public class SimpleOrderCerter implements OrderCenter {
      private static final   Map<String,Order> orderMap=new HashMap<>();
    @Override
    public void addOrder(Order order) {
        orderMap.put(order.getOrderId(),order);
        System.out.println("订单生成成功,订单编号为:"+order.getOrderId());
    }

    @Override
    public void removeOrder(Order order) {
         order.clear();
        orderMap.remove(this);
        System.out.println("订单删除成功");
    }

    @Override
    //传入指定
    public String orderTable(String id) {
        SimpleGoodsCenter simpleGoodsCenter=new SimpleGoodsCenter();
        Goods goods;
       if(orderMap.containsKey(id)){
       Order order=orderMap.get(id);
     //orderInfo-->商品编号,商品价格
    final  Map<String,Integer> orderInfo= order.getOrderInfo();

          System.out.println("商品编号\t\t商品名称\t\t\t商品价格\t\t\t商品数量\t\t");
      for(Map.Entry<String,Integer> entry:orderInfo.entrySet()){
          goods=simpleGoodsCenter.getGoods(entry.getKey());
          System.out.println(String.format("%s\t\t%s\t\t%.2f\t\t%d",entry.getKey(),goods.getName(),goods.getPrice(),entry.getValue()));
      }
       }
        return id;
    }

    @Override
    public String ordersTable() {
Iterator<String> oderIter=orderMap.keySet().iterator();
        while (oderIter.hasNext()){
            String orderId=oderIter.next();
            System.out.println("***********订单编号为:"+orderId+"***************************");
            orderTable(orderId);
            System.out.println();

        }
        return "";
    }



  //  private String filePath=System.getProperty("user.dir")+File.separator+"orderInfo.txt";
    File file=new File("D:\\TL-BITE\\JAVA\\java_examples\\checkStand\\src\\com\\sweeeeeet\\orderInfo.txt");
    @Override
    public void storeOrders() {
        try {
            FileWriter fileWriter=new FileWriter(file);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
      Iterator orderIterator=  orderMap.keySet().iterator();
        Iterator iteratorMessage=orderMap.values().iterator();
       while (orderIterator.hasNext()){
           bufferedWriter.write("订单编号："+orderIterator.next()+"\n");
           bufferedWriter.flush();
           while (iteratorMessage.hasNext()){
               bufferedWriter.write(iteratorMessage.next()+"\n");
               bufferedWriter.flush();
           }
       }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadOrders() {

    }
}
