package www.sweet.linkedlist;

/**
 * Author:sweet
 * Created:2019/4/7
 */
public class LinkedListPractice {
     static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value=value;
            this.next=null;
        }
    }

    public LinkedListPractice() {
        this.head = null;
    }

    //链表中的第一个节点的引用
    public Node head;

     //头插
     public void pushFront(Node node){
         //node即将称为新的head
         node.next=this.head;
         //node取代head
         this.head=node;
     }

     //尾插
     public void pushBack(Node node){
         node.next=null;
         if(this.head==null){
             this.head=node;
         }else{
             //取到最后一个节点
             Node cur=this.head;
             while(cur.next!=null){
                 cur=cur.next;
             }
             cur.next=node;
         }
     }

     public  void display(){
         //通过循环把遍历链表
         Node cur=this.head;
         while(cur!=null){
             System.out.println(cur.value);
             cur=cur.next;
         }
     }

    public static void main(String[] args) {
        LinkedListPractice link=new LinkedListPractice();
        link.pushBack(new Node(1));
        link.pushBack(new Node(2));
        link.pushBack(new Node(3));
        link.pushFront(new Node(4));
        link.pushFront(new Node(5));
        link.pushFront(new Node(6));
        link.display();
    }



}
