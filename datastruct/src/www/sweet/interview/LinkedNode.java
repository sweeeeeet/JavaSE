package www.sweet.interview;
/**
 * Author:sweet
 * Created:2019/4/7
 * //！！！排列组合问题 古典概型现在面试的主趋势//
 * 单向链表中最重要的是节点，真正有用的值是value，next是维持结构用的
 *      1 第一个节点有特殊性，1）没有前驱2）代表整个链表
 *      2 插入删除节点时需要前驱节点，除非是第一个节点
 *      3 凡是解引用的地方，需要考虑引用是否为null
 *      4 方便断开方便接上
 */
public class LinkedNode {
static  int p=0;

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
    public LinkedNode reverseList2(LinkedNode head) {

        if (head == null) {
            return null;
        }
        LinkedNode pre = null;
        LinkedNode cur = head;
        //1-2-3-4-2-3
        // p c n
        //3-2-1-null
        while (cur != null) {
            LinkedNode next = cur.next;
            //逆置的过程
            cur.next = pre;
            pre = cur;
            //循环向后走的条件
            cur = next;


        }
        return pre;
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
        LinkedNode last = null;
        LinkedNode result = null;

        while (cur1 != null && cur2 != null) {
            if (cur1.value >= cur2.value) {
                LinkedNode next = cur2.next;
                cur2.next = null;
                //取值小的(cur2)尾插操作
                if (result == null) {
                    result = cur2;
                } else {
                    last.next = cur2;
                }
                last = result;
                cur2 = next;
            } else {
                LinkedNode next = cur1.next;
                cur1.next = null;
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
     * @Description: 以给定x为基准将链表分割为两部分，
     * 所有小于x的节点排在大于或=x的节点前，节点的排列顺序不改变
     * <p>
     * 解决思路：定义两个链表：遍历原链表，小于x的节点就放在小的新链表中，
     * 大于=x的就放在大的链表中，再把两个链表链接即可
     */

    public LinkedNode partation(LinkedNode pHead, int x) {
        LinkedNode small = null;
        LinkedNode smallLast = null;
        LinkedNode big = null;
        LinkedNode bigLast = null;
        LinkedNode cur = pHead;
        while (cur != null) {
            LinkedNode next = cur.next;
            if (cur.value < x) {
                //保证尾插的最后一个节点的next为空
                cur.next = null;
                //如果小链表没有头节点，当前就是小链表的头节点
                if (small == null) {
                    small = cur;
                } else {
                    //否则就就最后一个节点的下一个，即尾插
                    smallLast.next = cur;
                }
                smallLast = cur;
                cur = next;

            } else {
                cur.next = null;
                if (big == null) {
                    big = cur;
                } else {
                    bigLast.next = cur;
                }
                bigLast = cur;
                cur = next;
            }
        }
        //将大链表尾插到小链表中{ 1.small为null ||  2.big为null}
        LinkedNode result = null;
        if (small == null) {
            return big;
        } else {
            smallLast.next = big;
            return small;
        }
    }


    /**
     * @Description: 给定一个带有节点head的链表，返回链表的之间节点，如果有两个节点，取第二个节点
     * 解决：双指针遍历：一个指针跑两步，另一个指针只跑一步，
     * 因此快的指针走到null节点（末尾）了，慢的指针正好在链表之间
     */
    public LinkedNode middleNode(LinkedNode head) {
        LinkedNode fast = head;
        LinkedNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
            //fast走了两步，slow只走了一步，
            // 并且保证若是偶数个节点，慢指针值向的是中间的后一个节点
            fast = fast.next;
        }
        return slow;
    }


    /**
     * @Description: 在非空单链表中找指定倒数第K个节点
     * 解决：定义一前以后两个节点，先让前一个节点先走K步，然后一起前进，
     * 当前面的节点走到null，则就是倒数第K个节点
     * 考虑特殊情况{链表正好有m个节点，1.指定k大于m: 2.k等于m}
     * 1-2-3-4-5
     * @return:
     */

    public LinkedNode findKthNode(LinkedNode head, int k) {
        LinkedNode front = head;
        LinkedNode back = head;
        int i = 0;
        for (i = 0; i < k; i++) {
            front = front.next;
        }
        //如果链表有5个节点，要找倒数第六个
        if (front == null && i < k) {
            return null;
            //如果链表有5个节点，要找倒数第五个
        } else if (front == null) {
            return head;
        }

        while (front != null) {
            front = front.next;
            back = back.next;
        }
        return back;
    }

    /**
     * @Description: 对于一个链表，设计一个时间复杂度为O（N），额外空间复杂度为O（1）的算法，
     * 判断其是否为回文结构 （ABCCBA）
     * 解决：遍历链表，得到链表长度，然后找到中间节点，将中间节点以后的链表逆置，
     * 再与新链表逐个比较，一旦有不同的节点就说明不是回文
     */

    public boolean chkPalindrome(LinkedNode A) {
        LinkedNode middle = A;
        int len = getLenght(A);
        for (int i = 0; i < len / 2; i++) {
            //得到之间节点
            middle = middle.next;
        }
        middle = reversList(middle);
        while (A != null && middle != null) {
            if (A.value != middle.value) {
                return false;
            }
            A = A.next;
            middle = middle.next;
        }

        return true;
    }

    private int getLenght(LinkedNode a) {
        int len = 0;
        while (a != null) {
            len++;
            a = a.next;
        }
        return len;
    }

    /**
     * @Description: 在一个排序链表中，存在重复的节点，删除链表中重复的节点，
     * 重复的节点不保留，返回链表头指针
     * 解决：两个指针一前一后，若不相等则一起向前走，
     * 若相等，则前面的节点继续向前走，走到不相等或为空为止，将第二个节点尾插到第一个节点
     * 还需引入一个prev=null,申请一个假节点dummy，作为处理后的链表的头节点
     * @return: dummy.next
     */

    public LinkedNode deleteDuplication(LinkedNode head) {
        //p1,p2是进行比较的两个节点
        LinkedNode p1 = head;
        LinkedNode p2 = head.next;
        //假节点用来消除第一个节点没有前驱的特殊性（如果第一个节点开始就重复便无法处理）
        LinkedNode dummy = new LinkedNode(0);
        dummy.next = head;
        //pre永远是p1的前一个，用来删除节点
        LinkedNode pre = dummy;
        //1-2-3-4-4-4-5-6
        //如果值不相等则往前走

        if (head == null) {
            return null;
        }
        while (p2 != null) {
            //因为有序，p1和p2不相等，和p2的next更不会相等，因此比较可以向前继续
            if (p1.value != p2.value) {
                pre = pre.next;
                p1 = p1.next;
                p2 = p2.next;
            } else {
                //若果相等则p2向前走，走到不相等为止
                while (p2.value == p1.value) {
                    p2 = p2.next;
                }
                //将p2指向的节点尾插到pre上
                pre.next = p2;

                p1 = p2;
                p2 = p2.next;

            }
        }
        return dummy.next;
    }


//    public LinkedNode reverse(LinkedNode pHead) {
//        //利用前插逆置
//        LinkedNode cur = pHead;
//        LinkedNode head = null;
//        while (cur != null) {
//            LinkedNode next = cur.next;
//            cur.next = head;
//            head = cur;
//
//            cur = next;
//        }
//        return head;
//    }



//    //合并有序链表
//    public LinkedNode merge(LinkedNode l1, LinkedNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//
//        //将值小的尾插到新链表中
//        LinkedNode p1 = l1;
//        LinkedNode p2 = l2;
//        LinkedNode result = null;
//        while (p1 != null && p2 != null) {
//            if (p1.value <= p2.value) {
//                if (result == null) {
//                    result = p1;
//                } else {
//                    result.next = p1;
//                }
//                p1 = p1.next;
//            } else {
//                if (result == null) {
//                    result = p2;
//                } else {
//                    result.next = p2;
//                }
//                p2 = p2.next;
//            }
//        }
//        if (p1 == null) {
//            //p1遍历完了，则将p2尾插
//            result.next = p2;
//        }
//        if (p2 == null) {
//            result.next = p1;
//        }
//        return result;
//    }


    /**
     * @Description: 判断链表是否出现了交叉（链表的交叉只能是Y字型的）
     * solution：长的链表先走，走到与短链表同样长的位置，再一起走，如果能相遇，说明有交叉
     * int lenA
     * int lenB
     * LinkedNode longer
     * LinkedNode shorter
     * @return:
     */

    public LinkedNode getIntersectionNode(LinkedNode headA, LinkedNode headB) {
        int lenA = getLenght(headA);
        int lenB = getLenght(headB);
        int diff = lenA - lenB;

        if (lenA < lenB) {
             diff =  lenB-lenA ;

        }
        return null;
    }
    /**
    * @Description: 判断链表是否带环
    * solution：不带环：快的不会与慢的相遇
     *          带环：快的与慢的一定会在某个节点相遇
     *  快的3步，慢的走一步：因为差1，1可以被任何整数整除，即若是环，就一定能遇到
    * @return:
    */

    /**
    * @Description: 找环的入口点
     * solution1 :把一个相遇点的next置为空，就把这个问题转换为了两个链表求交点的问题
     * solution2 :在一个环中：快的从起点走，慢的从相遇位置走，两个一定会在入口点相遇
    * @Param:
    * @return:
    */

    /**
    * @Description: 复制一个带随机指针的链表 ，
    * solution：  1.遍历原链表每一个节点，创建新节点，不处理random
     *             2.再遍历处理random：找到原链表的当前节点的random，
     *                  通过random找到新链表对应的节点，将新链表中当前节点的random指向
     *                  自己链表本身应该指向的的节点:cur.next.random=cur.random.next
     *     {1.遍历原链表的每一个节点，复制新节点，插到原链表的后边
     *     2.遍历原链表的每一个节点，进行新节点random的设置cur.next.random=cur.random.next
     *     3.把一条链表拆成原链表和新链表}
    * @return:
    */

    class RNode{
        int val;
        RNode ranndom;      //链表中任意节点或为空都可以
        RNode next;

        public RNode(int val) {
            this.val = val;
        }
    }


    public RNode copyRandomList(RNode head) {
    RNode cur=head;
    //遍历原链表的每一个节点，创建新节点
        //把新节点插入到原节点后面
        while(cur!=null){
            RNode newNode=new RNode(cur.val);
            //先让新节点插入到cur后面节点的前面 (前插)
           newNode.next= cur.next;
            //再让当前节点的下一个节点指向新节点
            cur.next=newNode;
            //让原链表走向下一个的下一个节点
            cur=cur.next.next;
        }
        cur=head;
        //设置新节点的random
        while (cur!=null){
            RNode newNode=cur.next;
            if(cur.ranndom==null){
                newNode.ranndom=null;
            }else{
                newNode.ranndom=cur.ranndom.next;
            }

           cur=cur.next.next;
        }
        //拆成两个链表
             cur=head;
        RNode result=head.next;
        while(cur!=null){
            RNode newNode=cur.next;
            cur.next=newNode.next;
            if(newNode.next!=null){
                newNode.next=newNode.next.next;
            }
            cur=cur.next;
        }
        return result;
    }

//    public RNode copyRandom(RNode  head){
//        //1.遍历链表，创建新节点，让新节点称为原链表的下一个
//        RNode cur=head;
//        while(cur!=null){
//            RNode newNode=new RNode(cur.val);
//            newNode.next=cur.next;
//            cur.next=newNode;
//            cur=cur.next.next;
//        }
//        //2.设置新节点的random
//          cur=head;
//        RNode result=head.next;
//        while (cur!=null){
//            if(cur.ranndom==null){
//                result.ranndom=null;
//            }else {
//                result.ranndom = cur.ranndom.next;
//            }
//            cur=cur.next.next;
//        }
//        //3.拆为两个链表
//        cur=head;
//        RNode newNode=cur.next;
//        while(cur!=null){
//            cur.next=cur.next.ranndom;
//            if(newNode.next!=null) {
//                newNode.ranndom = newNode.next.next;
//            }
//            cur=cur.next;
//        }
//        return newNode;
//    }
    }



