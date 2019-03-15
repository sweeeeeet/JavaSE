package com.sweeeeeet;

import com.sweeeeeet.Order;
import com.sweeeeeet.OrderCenter;

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
    }

    @Override
    public void removeOrder(Order order) {
    order.clear();
        orderMap.remove(this);
    }

    @Override
    public String orderTable(String id) {
       if(orderMap.containsKey(id)){

          // Order order=new Order(id,null);
           System.out.println("************订单编号"+id+"************");
       Collection<Order> orders=  orderMap.values();
           while (orders.iterator().hasNext()){
               System.out.println(orders.toString());

           }
       }

        return id;
    }

    @Override
    public String ordersTable() {

        while (orderMap.keySet().iterator().hasNext()){
            System.out.println(orderMap.keySet().iterator().next());
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
