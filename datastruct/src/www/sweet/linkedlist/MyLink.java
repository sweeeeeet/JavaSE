package www.sweet.linkedlist;

/**
 * Author:sweet
 * Created:2019/3/30
 */
public class MyLink implements ILinkedList {

    static class Node {
        private Integer item;
        private Node next;

        public Node(Integer item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node head;

    public MyLink() {
        this.head = null;
    }

    /**
     * @Description: 单向链表的头插法
     * @Param:
     * @return:
     */
    @Override
    public void pushFront(int item) {
        Node node=new Node(item);
            node.next = head;
            this.head = node;

    }

    /**
     * @Description: 顺序链表的头删法
     * @Param:
     * @return:
     */
    @Override
    public void popFront() {
        if (this.head == null) {
            System.out.println("链表已为空");
            return;
        } else {

                this.head=this.head.next;
        }
    }

    /**
     * @Description: 单向链表的尾插法
     * @Param:
     * @return:
     */
    @Override
    public void pushBack(int item) {
        Node node=new Node(item);
        if (this.head == null) {
            this.head = node;
        } else {
            //1.找到最后一个节点
            Node last = getLast();
            last.next = node;
        }
    }

    private Node getLast() {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * @Description: 单向链表的尾删法
     * @Param:
     * @return:
     */
    @Override
    public void popBack() {
        if (this.head == null) {
            return;
        } else {
            if(this.head==null){
                return;
            }else{
            //找到倒数第二个节点
            Node last2=gatLast2();
            //将倒数第二个节点置为空
            last2.next=null;
            }

        }
    }

    private Node gatLast2() {
        Node cur=this.head;
            while (cur.next.next!=null){
                cur=head.next.next;
            }

        return cur;
    }

    public static void main(String[] args) {
        MyLink.Node node=new Node(1);
        MyLink myLink=new MyLink();
        myLink.pushFront(2);
        myLink.pushFront(3);
        myLink.pushBack(8);
        myLink.pushBack(0);
        myLink.pushBack(4);
        myLink.popBack();
       // myLink.popFront();
        Node cur=myLink.head;
        while(cur!=null){
            System.out.println(myLink.head.item);
            cur=cur.next;
        }
    }
}
