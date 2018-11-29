package com.datastruction.doublelink;

/**
 * Author:sweet
 * Created:2018/11/28
 */
public class Link implements ILink {

    private Node head;
    private Node last;
    private int size;

    //火车车厢，负责数据存储
    //内部类方便内部外部类互相访问成员
    private class Node {
        private Node prev;
        private Node next;
        private Object data;

        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

    @Override
    public boolean add(Object data) {
        //利用尾插法插入新节点1.申请空间保存新节点数据2.新节点变为last3.原来的最后一个节点的next指向新节点

        // 节点对象保存当前的最后一个节点对象
        Node temp = this.last;
        //（***）开辟新节点对象保存数据，并为新节点的pre挂载上以前的last(next未处理)
        Node node = new Node(temp, data, null);
        //把当前新节点变为last,需重新为以前last节点挂链（以前节点的next需更新）
        this.last = node;
        //判断，如若没有head,新节点为head（没有以前的last节点，省去重新挂next链的步骤）
        if (this.head == null) {
            this.head = node;
        } else {
            //若有head,处理以前的last节点的next,挂上当前新节点
            temp.next = node;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean contains(Object data) {
        for (Node temp = head; temp != null; temp = temp.next) {
            if (data.equals(temp.data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object remove(Object data) {

        //删除步骤：获取前后节点
        //2.若是尾节点
        for (Node temp = head; temp != null; temp = temp.next) {
            Node node1=temp.prev;
            Node node2=temp.next;
            Object tempData = temp.data;
            if (data.equals(temp.data)) {
                this.size--;
                //1.若是头节点 当前节点设为头节点
                if (node1 == null) {
                    this.head = temp.next;
                    temp=null;
                    return tempData;
                }
                else if (node2 == null) {
                    temp.prev.next=null;

                    return tempData;
                } else {
                    //若是中间节点
                    node1.next= temp.next;
                    node2.prev=node1;
                    temp = null;
                    return tempData;
                }
            }
        }
        return null;
    }

    @Override
    public Object set(int index, Object newData) {
        if (!isLinkIndex(index)) {
            return null;
        }
        Node node = node(index);
        Object ele = node.data;
        node.data = newData;
        return node;
    }

    @Override
    public Object get(int index) {
        if (!isLinkIndex(index)) {
            return null;
        }
        return node(index).data;
    }

    @Override
    public void clear() {
        for (Node temp = head; temp != null; ) {
            temp.data = null;
            Node node = temp.next;
            temp = temp.prev = temp.next = null;
            temp = node;
            this.size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] datas = new Object[size];
        int i = 0;
        for (Node temp = head; temp != null; temp = temp.next) {
            datas[i++] = temp.data;
        }
        return datas;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void print() {
        for (Node temp = this.head; temp != null; temp = temp.next) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" > ");
            } else {
                System.out.println();
            }
        }
    }

    //根据指定索引取得节点
    //仅供本类对象使用
    private Node node(int index) {
        //从前向中间走
        if (index < (size >> 1)) {
            Node temp = this.head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
        //前面走完，从后向前走
        Node temp = this.last;
        for (int i = size - 1; i > index; i--) {
            temp = temp.prev;
        }
        return temp;
    }

    private boolean isLinkIndex(int index) {
        return index >= 0 && index < this.size;
    }
}
