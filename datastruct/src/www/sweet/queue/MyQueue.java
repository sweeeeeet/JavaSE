package www.sweet.queue;

import javax.xml.namespace.QName;

/**
 * Author:sweet
 * Created:2019/4/14
 * 队列只允许在一端进行插入操作，而在另一端进行删除数据操作，
 * 进行插入的一端称为队尾，进行删除操作的称为队头
 * 用链表实现队列
 */
public class MyQueue implements IMyQueue {
    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public MyQueue() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean empty() {
        if (this.head == this.tail) {
            if (this.head == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description: 取队首元素，但是不出队
     * @Param:
     * @return:
     */
    @Override
    public int peek() {
        if (this.head != null) {
            return this.head.value;
        }
        return 0;
    }

    /**
     * @Description: 返回队首元素并出队
     * @Param:
     * @return:
     */
    @Override
    public int poll() {
        if (this.head != null) {
            int res = this.head.value;
            this.head = head.next;
            return res;

        }
        return 0;
    }

    @Override
    public void add(int item) {
    if(this.tail==null){
    this.tail=new Node(item);
    if(this.head==null){
        this.head=this.tail;
    }
}else{
        Node node=new Node(item);
    this.tail.next=node;
    this.tail=node;
}
    }

    @Override
    public int size() {
        Node cur=head;
        int size=0;
        while(cur!=null){
            cur=cur.next;
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        MyQueue queue=new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(        queue.empty());
        System.out.println(        queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }
}
