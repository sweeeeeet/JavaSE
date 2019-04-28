package www.sweet.tree;

import java.util.*;

/**
 * Author:sweet
 * Created:2019/4/19
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeInterviewPro {

    /**
     * @Description: 利用前序+中序构建二叉树
     * 1在前序中找到根的值 preOrder[0]
     * 2在中序中找到根的值所在的下标--》可得到左子树的节点个数
     * 3.切出左子树的前序+中序 ：preOder跳过1，长度是下标;  inOrder，长度是下标
     * 4.切出右子树的前序+中序：preOder跳过1，跳过下标（到达右子树），长度为总长-左子树长度
     * inOrder:跳过下标，跳过1，长度为总长-下标
     */
    public TreeNode buildTree12(int[] preorder, int[] inorder) {
        if (preorder == null) {
            return null;
        }
        //1.在前序中找到根的值
        TreeNode root = new TreeNode(preorder[0]);
        //2.在中序中找到根所在的下标==左子树的节点个数
        int leftSize = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                leftSize = i;
            }
        }
        //前序：ABCDE
        //中序：CDBAE
        //3.切出左子树的前序:copyOfRange()函数参数的区间--左闭右开
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, leftSize + 1);
        //切出左子树的中序
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, leftSize);
        TreeNode rootLeft = buildTree12(leftPreOrder, leftInOrder);
        //4.切出右子树的前序
        int[] rightPreOrder = Arrays.copyOfRange(preorder, leftSize + 1, preorder.length);
        //切出右子树的中序
        int[] rightInOrder = Arrays.copyOfRange(inorder, leftSize + 1, inorder.length);
        TreeNode rightRoot = buildTree12(rightPreOrder, rightInOrder);
        root.left = rootLeft;
        root.right = rightRoot;
        return root;

    }

    /**
     * @Description: 通过中序和后序遍历构建二叉树
     * @Param:
     * @return:
     */

    public TreeNode buildTree23(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        //1.在后序中找到根节点
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        //2.得到左子树的长度
        int leftSize = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                leftSize = i;
            }
        }
        //3.切出左子树的中序
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, leftSize + 1);
        //切出左子树的后序
        int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, leftSize);
        root.left = buildTree23(leftInOrder, leftPostOrder);
//    中序遍历 inorder = [9,3,15,20,7]
//    后序遍历 postorder = [9,15,7,20,3]
        //4.切出右子树的中序
        int[] rightInOrder = Arrays.copyOfRange(inorder, leftSize + 1, inorder.length);
        //切出右子树的后序:copyOfRange()函数是对索引取左闭右开
        int[] rightPostOrder = Arrays.copyOfRange(postorder, leftSize, postorder.length - 1);
        root.right = buildTree23(rightInOrder, rightPostOrder);
        return root;

    }

    public ReturnValue buildTreeWithArray(String str) {
        if (str == null) {
            return null;
        }

        char[] tree = str.toCharArray();
        if (tree.length == 0) {
            return new ReturnValue(null, 0);
        }
        BinaryTreeInterview.Node root = new BinaryTreeInterview.Node(tree[0]);
        if (tree[0] == '#') {
            return new ReturnValue(null, 1);
        } else {
            //处理左子树
            char[] leftTeree = Arrays.copyOfRange(tree, 1, tree.length);
            ReturnValue left = buildTreeWithArray(String.valueOf(leftTeree));
            //处理右子树

            char[] rightTree = Arrays.copyOfRange(tree, left.used + 1, tree.length);
            ReturnValue right = buildTreeWithArray(String.valueOf(rightTree));
            root.left = left.node;
            root.right = right.node;
            return new ReturnValue(root, left.used + right.used + 1);
        }

    }

    class ReturnValue {
        BinaryTreeInterview.Node node;
        int used;

        public ReturnValue(BinaryTreeInterview.Node node, int used) {
            this.node = node;
            this.used = used;
        }
    }


    /**
     * @Description: 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
     * 空节点则用一对空括号 "()" 表示。
     * 省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对
     * @Param:
     * @return:
     */
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        //前序遍历得到节点，传入追加字符串，在第一次经过字符串时就记录下来
        preOrder(t, sb);
        sb.delete(0, 1);
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append("(");
            //第一次经过节点时就记录下来
            sb.append(root.val);
            //如果左子树为空，右子树不为空记录值（）
            if (root.left == null && root.right != null) {
                sb.append("()");
            } else {
                preOrder(root.left, sb);
            }
            preOrder(root.right, sb);
            sb.append(")");
        }
    }



    /**
     * @Description:给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
     * <p>
     * 1.p或q至少有一个就是root,祖先是root
     * 2.一个在root的左子树上，一个在右子树上，公共祖先是root
     * 3.在一棵子树上，则递归到这颗子树上{
     * 递归查找子树，如果在左子树上找到了p,右子树上找到了q，就是第一种情况（递归出口）
     * * }
     * @Param:
     * @return:
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //保证节点不为空
        if (root == p || root == q) {
            return root;
        }
        boolean pInLeft = find(root.left, p);
        boolean qInLeft = find(root.left, q);
        /*
         * 三种情况：1.分布在左右两个子树上--》root
         *           2.根节点就是其中一个节点--》root
         *           3.分布在同一个子树上（递归回12）
         * */
        if (pInLeft && qInLeft) {
            //如果p在左子树上，q也在左子树上，递归查找
            return lowestCommonAncestor(root.left, p, q);
        }
        if (!pInLeft && !qInLeft) {
            //说明在右子树上
            return lowestCommonAncestor(root.right, p, q);

        }
        //说明一个在左子树上 一个在右子树上，公共祖先为根
        return root;
    }

    private boolean find(TreeNode root, TreeNode t) {
        if (root == null) {
            return false;
        }
        if (root == t) {
            return true;
        }
        if (find(root.left, t)) {
            return true;
        }
        return find(root.right, t);
    }


    /**
     * @Description: 层序遍历，将遍历的数据装入List<List<Integer>>容器
     * solution：利用队列：一头进 一头出
     * 1.启动  根入队列
     * 2，取队首
     * 2.拉下线（空节点不要）
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        //相当于一个二维数组，给顺序链表中放顺序链表
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        class NodeLevel {
            TreeNode node;
            int level;

            public NodeLevel(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }
        LinkedList<NodeLevel> queue = new LinkedList<>();
        //队首入队，
        queue.addLast(new NodeLevel(root, 0));
        while (!queue.isEmpty()) {
            //取队首
            NodeLevel front = queue.pollFirst();
            TreeNode node = front.node;

            int level = front.level;
            //list.size()随着遍历的层数的增加而增加
            //如果是新层，则给元顺序的增加值，这个值是一个顺序链表
            if (list.size() == level) {
                //扩展为二维数组
                list.add(new ArrayList<>());
            }
            //在当前层中对应的顺序链表中的顺序链表放值
            list.get(level).add(node.val);
            //拉下线，层数+1
            if (node.left != null) {
                queue.addLast(new NodeLevel(node.left, level + 1));
            }
            if (node.right != null) {
                //拉下线，层数+1
                queue.addLast(new NodeLevel(node.right, level + 1));
            }
        }
        return list;
    }


    /**
     * @Description: 层序遍历
     * @Param:
     * @return:
     */
    public void levelOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        //1.启动
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            //2.取队首
            queue.pollFirst();
            //拉下线
            if (root.left != null) {
                queue.addLast(root.left);
            }
            if (root.right != null) {
                queue.addLast(root.right);
            }
        }
    }

    /**
     * @Description: 判断一棵树是不是完全二叉树
     * solution：带着空节点层序遍历，如果遇到空节点之后的所有都是空节点--》完全二叉树
     * 如果遇到空之后，又遇到飞空，不是完全二叉树
     */

    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (true) {
            TreeNode front = queue.pollFirst();
            if (front == null) {
                //如果遇到空，就不走了，判断队列中残留的的是否全是空
                break;
            }
            queue.addFirst(front.left);
            queue.addFirst(front.right);
        }

        //循环走完了，判断空节点的后面是否还有非空
        while (!queue.isEmpty()) {
            TreeNode front = queue.pollFirst();
            if (front != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Description: 输入一棵二叉搜索树(任意一个节点的左边比右边小)，
     * 将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向
     * solution：中序是有序的
     * 将节点串成双向链表：
     * Node pre=null
     * for(Node node：list){
     * node.pre=pre;//node.left=pre;
     * if(pre!=null){
     * pre.next=node;//pre.right=node
     * }
     * pre=node;
     * }
     */
    private static TreeNode prev = null;
    private static TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        prev = null;
        head = null;
        inOrderSereachTree(pRootOfTree);
        return head;
    }

    public void inOrderSereachTree(TreeNode root) {
        //1.中序遍历二叉树
        //2.将中序遍历的节点穿成双向链表
        if (root != null) {
            inOrderSereachTree(root.left);
            //处理根
            buildLinkedList(root);
            inOrderSereachTree(root.right);
        }
    }

    private void buildLinkedList(TreeNode node) {
        //搜索树的任何一个节点的左孩子小于右孩子
        node.left = prev;
        if (prev != null) {
            prev.right = node;
        } else {
            head = node;
        }
        prev = node;
    }





    /**
     * @Description: 非递归的前序遍历
     * @Param:
     * @return:
     */
    public void preOrderTravel(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                System.out.println(cur);
                stack.push(cur);
                cur = cur.left;
            }
            //走完了所有的左子树，开始利用栈回溯右子树
            TreeNode node = stack.pop();
            cur = node.right;
        }
    }


    /**
     * @Description: 非递归的中序遍历
     * @Param:
     * @return:
     */
    public void inOrderTravel(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //走完了所有的左子树，开始利用栈回溯右子树
            TreeNode node = stack.pop();
            System.out.println(cur);
            cur = node.right;
        }
    }

    /**
     * @Description: 非递归后序遍历 :第三次经过时打印
     * @Param:
     * @return:
     */
//    public void postOrderTravel(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = root;
//        TreeNode last = null;
//        while (!stack.isEmpty() || cur != null) {
//            while (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            }
//            //后续遍历不能出栈，否则就会回到根节点打印
//            TreeNode top = stack.peek();
//
//            //第二次经过节点
//            if (top.right == null) {
//                //若节点为空，紧接着就可以第三次遍历到节点cur，因此可以打印
//                System.out.println(top.val);
//                stack.pop();
//                last = top;
//            } else if (top.right == last) {
//                //第三次遇到
//                System.out.println(top.val);
//                stack.pop();
//                last = top;
//            } else {
//                //第二次遇到
//                cur = top.right;
//            }
//        }
//    }
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode last=null;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //左子树遍历完毕，不能立即出栈
            //top回溯到上一层，记录last,表示上一次pop的值
            // 栈顶元素需探查右子树:
            // {1.top.right=null:说明是左子树上最后一个了，可继续出栈
            // 2.top.right=last:说明上次pop已经是右子树上最后一个了
            // 3.对不上号：说明右子树上还有值，没遍历完}

            TreeNode  top = stack.peek();


            //最后一个节点没有子结点了，就到了第三次经过节点的时候了
            if(top.right==null){
                //左子树的尾节点的情况
                last=stack.pop();
                list.add(last.val);
            }
            else if((top.right==last)){
                //上一次右子树刚出栈的情况
                last=stack.pop();
                list.add(last.val);
            }else{
                cur=top.right;
            }

        }

        return list;
    }


    public static void main(String[] args) {
        BinaryTreeInterviewPro test = new BinaryTreeInterviewPro();
        BinaryTreeInterview.Node node = test.buildTreeWithArray("ABC##DE#G##F###").node;
        BinaryTreeInterview test2 = new BinaryTreeInterview();

    }
}
