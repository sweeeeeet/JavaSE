package com.datastruction.doublelink;

/**
 * Author:sweet
 * Created:2018/11/28
 */

public interface ILink {
  //链表的增加节点操作
    boolean add(Object data);
    //判断指定内容的节点在链表是否存在
    boolean contains(Object data);
    //删除指定内容节点
    Object remove(Object data);
    //根据指定下标，返回节点内容
    Object set(int index,Object data);
    //根据指定下标返回内容
    Object get(int index);
    //链表清空
    void clear();
    //将链表转为数组
    Object[] toArray();
    //返回链表长度
    int size();
    //遍历打印链表
    void print();
}
