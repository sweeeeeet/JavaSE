package com.github.sweeeeeet.poem.crawler.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:sweet
 * Created:2019/4/25
 * 存储清洗的数据
 */
public class DataSet {
    /*
    * 把DOM解析清洗之后存储的数据
    * 比如：
    * 标题：送孟浩然之广陵
    * 作者：李白
    * 正文：xxxx
    * */
    private Map<String,Object> data=new HashMap<>();


    public void putData(String key,Object value){
        this.data.put(key,value);
    }

    public Object getData(String key){
        return this.data.get(key);
    }

    public Map<String,Object> getData(){
        return new HashMap<>(this.data);
    }
}
