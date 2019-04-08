package www.sweet.linkedlist.interview;

/**
 * Author:sweet
 * Created:2019/4/7
 */
public class LinkedNode {
    /**
     * @Description: 删除链表中的指定元素{1.考虑指定元素包含了head的情况}
     * 1.
     * 定义新链表：Node head表示原链表的head；Node result 结果链表；
     * Node last 记录最后一个节点，可以提升尾插的性能
     * 一次遍历链表中的每一个节点，如果节点的值不是要删除的值，把节点尾插到新链表中
     * 2.遍历链表，若果是指定指就删除
     */
    public LinkedNode next;
    public int value;

    public LinkedNode(int value) {
        this.value = value;
    }

    public LinkedNode removeElements(LinkedNode head, int value) {
        //1.定义新链表的头节点
        LinkedNode newHead = null;
        LinkedNode cur = head;
        LinkedNode next = null;
        //遍历原链表
        while (cur != null) {
            //如果不是指定元素，就尾插到新列表
            if (cur.value == value) {
                //如果是指定元素，遍历到下一个尾插
                next = cur.next.next;
                newHead = next;
                // cur=cur.next.next;
            } else {
                //尾插
                next = cur.next;
                newHead = next;
                // cur=cur.next;
            }
            if (cur == head) {
                newHead = head;
            }
            newHead.next = null;
            cur = next;

        }

        return newHead;
    }

    /**
     * @Description: 反转单链表：定义一个新链表，取源链表中的每一个节点，头插到新链表的节点中
     * @Param:
     * @return:
     */
    public LinkedNode reversList(LinkedNode head) {
        //定义结果链表
        LinkedNode result = null;
        LinkedNode cur = head;
        //进行头插操作
        //  1-2-3-4
        //1-null;2-1-null;
        while (cur != null) {
            LinkedNode next = cur.next;
            //前插操作：
            // 1.将当前取到的节点作为结果链表的头元素，头插进去（node.next=head;this.head=node;）
            // 2.当前元素就成为了结果链表
            cur.next = result;
            result = cur;
            //使循环继续，利用cur取下一个节点
            cur = next;

        }
        return result;
    }

    /**
     * @Description: 反转链表2:利用三引用反转
     * @Param: LinkedNode pre=null;LinkedNode cur=head;LinkedNode next=cur.next;
     * @return:
     */
public LinkedNode reverseList2(LinkedNode head){
    LinkedNode pre=null;
    LinkedNode cur=head;
    LinkedNode next=cur.next;
}




    /**
     * @Description: 合并两个有序链表:定义一个新链表:分别遍历两个链表,选择一个值较小的尾插进新链表
     * @Param: LinkedNode next=cur.next; LinkedNode result=null;LinkedNode last=null;
     * @return:
     */
    public LinkedNode mergeTwoList(LinkedNode l1, LinkedNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        LinkedNode cur1 = l1;
        LinkedNode cur2 = l2;
        LinkedNode result = null;
        LinkedNode last = null;

        while (cur1 != null && cur2 != null) {
            if (cur1.value >= cur2.value) {
                LinkedNode next=cur2.next;
                cur2.next=null;
                //取值小的(cur2)尾插操作
                if (result == null) {
                    result = cur2;
                } else {
                    last.next = cur2;
                }
                last = result;
                cur2 = next;
            } else {
                LinkedNode next=cur1.next;
                cur1.next=null;
                if (result == null) {
                    result = cur1;
                } else {
                    last.next = cur1;
                }
                last = result;
                cur1 = next;
            }
        }
        return result;
    }

    /**
    * @Description:  以给定x为基准将链表分割为两部分，
     *                所有小于x的节点排在大于或=x的节点前，节点的排列顺序不改变
     *
     * 解决思路：定义两个链表：遍历原链表，小于x的节点就放在小的新链表中，
     * 大于=x的就放在大的链表中，再把两个链表链接即可
    */

    public LinkedNode partation(LinkedNode pHead,int x){
        LinkedNode small=null;
        LinkedNode smallLast=null;
        LinkedNode big=null;
        LinkedNode bigLast=null;
        LinkedNode cur=pHead;
        while(cur!=null){
            LinkedNode next=cur.next;
            if(cur.value<x){
                //保证尾插的最后一个节点的next为空
                cur.next=null;
                //如果小链表没有头节点，当前就是小链表的头节点
                if(small==null){
                    small=cur;
                }else{
                    //否则就就最后一个节点的下一个，即尾插
                    smallLast.next=cur;
                }
                smallLast=cur;
                cur=next;

            }else{
                cur.next=null;
                if(big==null){
                    big=cur;
                }else{
                    bigLast.next=cur;
                }
                bigLast=cur;
                cur=next;
            }
        }
        //将大链表尾插到小链表中{ 1.small为null ||  2.big为null}
        LinkedNode result=null;
        if(small==null){
        return big;
        }else{
            smallLast.next=big;
            return small;
        }
    }


    /**
    * @Description: 给定一个带有节点head的链表，返回链表的之间节点，如果有两个节点，取第二个节点
    * 解决：双指针遍历：一个指针跑两步，另一个指针只跑一步，
     * 因此快的指针走到null节点（末尾）了，慢的指针正好在链表之间
    *
    */
    public LinkedNode middleNode(LinkedNode head){
        LinkedNode fast=head;
        LinkedNode slow=head;
        while(fast!=null){
            fast=fast.next;
            if(fast==null){
                break;
            }
            slow=slow.next;
            //fast走了两步，slow只走了一步，
            // 并且保证若是偶数个节点，慢指针值向的是中间的后一个节点
            fast=fast.next;
        }
        return slow;
    }


    /**
    * @Description: 在非空单链表中找指定倒数第K个节点
    *解决：定义一前以后两个节点，先让前一个节点先走K步，然后一起前进，
     * 当前面的节点走到null，则就是倒数第K个节点
     * 考虑特殊情况{链表正好有m个节点，1.指定k大于m: 2.k等于m}
     * 1-2-3-4-5
    * @return:
    */

    public LinkedNode findKthNode(LinkedNode head,int k){
        LinkedNode front=head;
        LinkedNode back=head;
        int i=0;
        for(i=0;i<k;i++){
            front=front.next;
        }
        //如果链表有5个节点，要找倒数第六个
        if(front==null&&i<k){
            return null;
            //如果链表有5个节点，要找倒数第五个
        }else if(front==null){
            return head;
        }

        while (front!=null){
            front=front.next;
            back=back.next;
        }
        return back;
    }

    /**
    * @Description: 对于一个链表，设计一个时间复杂度为O（N），额外空间复杂度为O（1）的算法，
     *              判断其是否为回文结构 （ABCCBA）
    *
    * @return:
    */
}

