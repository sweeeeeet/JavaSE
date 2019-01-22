package com.sweeeeeet;

import com.sweeeeeet.GoodsCenter;

import java.io.BufferedWriter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:sweet
 * Created:2019/1/19
 */
public class SimpleGoodsCenter implements GoodsCenter {
    private final Map<String,Goods> goodsMap=new HashMap<>();
    @Override
    public void addGoods(Goods goods) {
this.goodsMap.put(goods.getId(),goods);
    }

    @Override
    public void removeGoods(String ID) {

    }

    @Override
    public boolean isExitGoods(String ID) {
        return false;
    }

    @Override
    public void updateGoods(Goods goods) {

    }

    @Override
    public Goods getGoods(String id) {
        return null;
    }

    @Override
    public String listGoods() {
        //打印商品信息StingBuilder  append
        //遍历Map--> Map.Entry
        return null;
    }
//当前存储在文件中
    private String filePath=System.getProperty("user.dir")+File.separator+"goods.txt";
    @Override
    public void store() {
//编号:名称：单价，，一行一条信息
        //文件输出流，字符流BufferWrite
        File file=new File(filePath);
        //BufferedWriter bufferedWriter = new BufferedWriter(file);
    }

    @Override
    public void load() {
//输入流读文件
    }
}
