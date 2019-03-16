package com.sweeeeeet;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author:sweet
 * Created:2019/1/19
 */
public class SimpleGoodsCenter implements GoodsCenter {
    private static final Map<String, Goods> goodsMap = new HashMap<>();

    @Override
    public void addGoods(Goods goods) {
        if (goods != null) {
            this.goodsMap.put(goods.getId(), goods);
            System.out.println("商品添加成功!");
        }
    }

    @Override
    public void removeGoods(String id) {
        if (id != null) {
            if (goodsMap.containsKey(id)) {
                goodsMap.remove(id);
                System.out.println("商品删除成功");
            } else {
                System.out.println("没有此商品");
            }
        }
    }

    @Override
    public boolean isExitGoods(String id) {
        if (goodsMap.containsKey(id)) {
            return true;
        }
        return false;
    }

    @Override
    public void updateGoods(Goods goods) {
        if (goods != null) {
            goodsMap.put(goods.getId(), goods);
            System.out.println("商品更改成功!");
        }
    }

    @Override
    public Goods getGoods(String id) {
        if (id != null) {
            if (goodsMap.containsKey(id)) {
                Goods target = goodsMap.get(id);
                return target;
            }
        }

        return null;
    }

    @Override
    public String listGoods() {
        //打印商品信息StingBuilder  append
        //遍历Map--> Map.Entry
        System.out.println();
        System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t");
        for (Map.Entry<String, Goods> entry : goodsMap.entrySet()) {
            Goods goods = entry.getValue();
            System.out.println(String.format("\t%s\t\t%s\t\t%.2f\n",
                    goods.getId(), goods.getName(), goods.getPrice()));
        }
        return "";
    }
//当前存储在文件中
    // private String filePath=System.getProperty("user.dir")+File.separator+"goods.txt";

    private File file = new File("D:\\TL-BITE\\JAVA\\java_examples\\checkStand\\src\\com\\sweeeeeet\\goods.txt");

    @Override
    public void store() {
//编号:名称：单价，，一行一条信息
        //文件输出流，字符流BufferWrite
        try {
            Writer writeGoods = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writeGoods);
            for (Map.Entry<String, Goods> goods : goodsMap.entrySet()) {
                bufferedWriter.write(goods.getKey()+"\t\t"+goods.getValue()+"\t\t"+ "\n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        //输入流读文件
        try {

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readFile;
            while ((readFile = bufferedReader.readLine()) != null) {
                String[] values = readFile.split(":");
                if (values.length == 3) {
                    Goods goods = new Goods(
                            values[0],
                            values[1],
                            Double.parseDouble(values[2])
                    );
                    this.addGoods(goods);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
