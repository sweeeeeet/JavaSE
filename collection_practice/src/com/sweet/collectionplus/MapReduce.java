package com.sweet.collectionplus;

import java.util.*;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleSupplier;
import java.util.stream.Collectors;

/**
 * Author:sweet
 * Created:2019/1/8
 */
public class MapReduce {
    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("iphone", 8999.99, 122));
        orderList.add(new Order("外行星人笔记本", 8969.99, 12));
        orderList.add(new Order("MacBook", 1899.22, 5));
        orderList.add(new Order("javaBook", 78, 122));
        orderList.add(new Order("中性笔", 2, 67));
        //计算金额综合
        double total=0.0;
        for(Order order:orderList){
            total+=order.getPrice()*order.getAmount();
        }
        System.out.println("总金额是："+total);

        //利用MapReduce计算  fork-join
        orderList.stream()
                .mapToDouble(o->o.getPrice()*o.getAmount())
                //将DoubleStream中的每个元素求和
                .reduce(new DoubleBinaryOperator() {
            @Override
            //left->sum right ->map()中的每个数据
            public double applyAsDouble(double left, double right) {
                return left+right;
            }
        }).orElseGet(new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return 0;
            }
        });
        //mapreduce统计分析
      DoubleSummaryStatistics ds= orderList.stream().mapToDouble(o->o.getAmount()*o.getPrice())
                .summaryStatistics();
      //统计结果：订单数量，最大订单 最小订单 总额 平均值
        System.out.println("订单数量"+ds.getCount());
        System.out.println("最大订单"+ds.getMax());
        System.out.println("最小订单"+ds.getMin());
        System.out.println("总额"+ds.getSum());
        System.out.println("平均值"+ds.getAverage());
group();


    }
    public static void group(){
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("MacBook", 1899.22, 5));
        orderList.add(new Order("MacBook", 1899.22, 5));
        orderList.add(new Order("javaBook", 78, 122));
        orderList.add(new Order("中性笔", 2, 67));
        orderList.add(new Order("中性笔", 2, 67));
        Map<String, List<Order>> map = new HashMap<>();
        for(Order order:orderList){
            if(map.containsKey(order.getTitile())){
                map.get(order.getTitile()).add(order);
            }else{
                List<Order> orders=new ArrayList<>();
                orders.add(order);
                map.put(order.getTitile(), orders);
            }
        }
        //计算title相同的订单金额(原逻辑)
        Map<String, Double> doubleMap = new HashMap<>();
        for(Map.Entry<String,List<Order>> entry:map.entrySet()){
            String title=entry.getKey();
            List<Order> orders=entry.getValue();
            double sum=0.0D;
            for(Order o:orders){
                sum+=o.getPrice()*o.getAmount();
            }
            doubleMap.put(title, sum);
        }
        System.out.println(doubleMap);
//MapReduce  实现分组
        orderList.stream()
                //title作为标识分组
                .collect(Collectors.groupingBy(o -> o.getTitile()))
                .forEach((k,v)->{
                    //为各组赋值key为title,value为每组的订单的和
                    //mapToDouble计算每个订单的金额
                    doubleMap.put(k,v.stream().mapToDouble(o->o.getAmount()*o.getPrice())
                          //reduce计算每组订单金额的和
                            .reduce((sum,x)->sum+x).orElse(0));
                });

    }
}
