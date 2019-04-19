package LinkedList;

/**
 * Author:sweet
 * Created:2019/4/12
 */
import java.util.ArrayList;


      class ListNode {
        int val;
        ListNode next = null;

       ListNode(int val) {
             this.val = val;
         }
     }


public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //前插实现从尾到头
        ArrayList<Integer> array=new ArrayList();
        ListNode cur=listNode;
        int len=0;
        while(cur!=null){
            if(len==0){
                //如果头节点为空，当前节点就是头节点
                array.add(0,cur.val);
                len++;
            }else{


//                for(int i=len;i>0;i--){
//
//                    int val=array.get(i-1);
//                    array.add(i,val);
//                }
                array.add(0,cur.val);

            }

            cur=cur.next;
        }
        return array;
    }

    public static void main(String[] args) {
        Solution so=new Solution();
        ListNode list=new ListNode(1);
        ListNode list1=new ListNode(2);
        ListNode list2=new ListNode(3);
        ListNode list3=new ListNode(4);
        list.next=list1;
        list1.next=list2;
        list2.next=list3;

        so.printListFromTailToHead(list);
    }
}
