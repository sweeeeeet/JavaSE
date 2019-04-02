package www.sweet.linkedlist;

/**
 * Author:sweet
 * Created:2019/3/30
 */
public class MyLinkedList {
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    public MyLinkedList() {
        this.head = null;
    }

    //头插
    void pushFront(Node node) {
        if (this.head == null) {
            this.head = node;
        } else {
            //头插-->当前的next指向node
            node.next = this.head;
            //node取代原head成为head
            this.head=node;
        }
    }

    //尾插
    void pushBack(Node node) {
        //如果头节点为空,node作为最后一个
        if (this.head == null) {
            this.head = node;
        } else {
            //获取最后一个结点
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            //最后一个结点的next是node
            cur.next = node;
        }

    }

    //头删
    void popFront() {
        Node cur = this.head;
        if(cur==null){
            this.head=null;
        }else {
            //如果当前有下一个结点,获取下一个结点
            while (cur.next != null) {
                //将头节点的下一个作为头节点
                cur = cur.next;
            }
        }
    }

    //尾删
    void popBack() {
        //找到倒数第二个
        Node cur = this.head;
        //头节点的下一个为空,头节点就是最后一个
        if (cur.next == null) {
            this.head = null;
        } else {
            while (cur.next.next != null) {
                cur = cur.next.next;
            }
            //将倒数第二个的下一个置空
            cur.next = null;
        }
    }
}
