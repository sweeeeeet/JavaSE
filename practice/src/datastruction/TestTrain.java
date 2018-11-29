package datastruction;

/**
 * Author:sweet
 * Created:2018/11/27
 */
public class TestTrain {
    public static void main(String[] args) {
        Node head=new Node("火车头",null);
        Node node1=new Node("01",null);
        Node node2 = new Node("02", null);
        Node node3=new Node("03",null);
        Node tail=new Node("火车尾",null);
    //连接车厢
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(tail);
        //展示火车
        Node curr=head;
        while(curr!=null){
            Object data=curr.getData();
            System.out.print(data);
            curr=curr.getNext();
            if(curr.getNext()!=null){
                System.out.println(" > ");
            }
        }
        System.out.println();
    }
}
