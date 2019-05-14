package com.sweeeeeet;

import java.io.*;
import java.util.*;

/**
 * Author:sweet
 * Created:2019/1/19
 */
public class SimpleOrderCerter implements OrderCenter {
    private static final Map<String, Order> orderMap = new HashMap<>();

    @Override
    public void addOrder(Order order) {
        orderMap.put(order.getOrderId(), order);
        System.out.println("订单生成成功,订单编号为:" + order.getOrderId());
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
        SimpleGoodsCenter simpleGoodsCenter = new SimpleGoodsCenter();
        StringBuilder stringBuilder = new StringBuilder();
        Goods goods;
        if (orderMap.containsKey(id)) {
            Order order = orderMap.get(id);
            //orderInfo-->商品编号,商品价格
            final Map<String, Integer> orderInfo = order.getOrderInfo();
            stringBuilder.append("商品编号\t\t商品名称\t\t\t商品价格\t\t\t商品数量\t\t\n");
          double sum=0d;
            for (Map.Entry<String, Integer> entry : orderInfo.entrySet()) {
                goods = simpleGoodsCenter.getGoods(entry.getKey());
                stringBuilder.append(String.format("%s\t\t%s\t\t%.2f\t\t%d\n", entry.getKey(), goods.getName(), goods.getPrice(), entry.getValue()));
                 sum+=goods.getPrice()*entry.getValue();
            }
                stringBuilder.append("总计金额："+sum+"\n");
        }
        return String.valueOf(stringBuilder);
    }
    @Override
    public String ordersTable() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> oderIter = orderMap.keySet().iterator();
        while (oderIter.hasNext()) {
            String orderId = oderIter.next();
            stringBuilder.append("*******************订单编号为:" + orderId + "***************************\n");
            stringBuilder.append(orderTable(orderId));

            System.out.println();

        }
        return String.valueOf(stringBuilder);
    }


    //  private String filePath=System.getProperty("user.dir")+File.separator+"orderInfo.txt";
    File file = new File("D:\\TL-BITE\\JAVA\\java_examples\\checkStand\\src\\com\\sweeeeeet\\orderInfo.txt");

    @Override
    public void storeOrders() {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(ordersTable());
            bufferedWriter.write("*****************************************\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadOrders() {
        File file = new File("D:\\TL-BITE\\JAVA\\java_examples\\checkStand\\src\\com\\sweeeeeet\\orderInfo.txt");
        try {
           Reader reader=new FileReader(file);
           Scanner scanner=new Scanner(reader);
            System.out.println(scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
