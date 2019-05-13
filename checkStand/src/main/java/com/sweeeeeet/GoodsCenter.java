package com.sweeeeeet;

/**
 * Author:sweet
 * Created:2019/1/19
 */
public interface GoodsCenter {
    //添加商品
    void addGoods(Goods goods);
    //移除商品
    void removeGoods(String ID);
    //判断商品是否存在
    boolean isExitGoods(String ID);
    //更新商品
    void updateGoods(Goods goods);
    //列举所有商品
    Goods getGoods(String id);
    //存储商品信息
    String listGoods();
    //加载商品信息
    void store();
    void load();


}
