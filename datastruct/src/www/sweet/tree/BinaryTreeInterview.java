package www.sweet.tree;

import java.util.Arrays;

/**
 * Author:sweet
 * Created:2019/4/13
 */
public class BinaryTreeInterview {
    static class Node {
        char val;
        Node left;
        Node right;

        public Node(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * @Description: 二叉树的前序遍历
     * @Param:
     * @return:
     */
    private static void preOrderTravel(Node root) {
        if (root != null) {
            //先根
            System.out.println(root.val);
            //再左
            preOrderTravel(root.left);
            //再右
            preOrderTravel(root.right);
        }
    }

    /**
     * @Description: 二叉树的中序遍历
     * @Param:
     * @return:
     */
    public static void inOrderTravel(Node root) {
        if (root != null) {
            //先根
            System.out.println(root.val);
            //再右
            preOrderTravel(root.right);
            //再左
            preOrderTravel(root.left);
        }
    }

    /**
     * @Description: 二叉树的hou序遍历
     * @Param:
     * @return:
     */
    private static void postOrderTravel(Node root) {
        if (root != null) {
            //先左
            preOrderTravel(root.left);
            //再右
            preOrderTravel(root.right);
            //最后根
            System.out.println(root.val);
        }
    }

    /**
     * @Description: 求节点个数：
     * solution:用子问题思想：左子树总结点+右子树总结点+1
     * @return:
     */
    private static int count(Node root) {
        //其他情况
        if (root != null) {
            return count(root.left) + count(root.right) + 1;
        }
        //空树
        return 0;
    }

    /**
    * @Description: 求叶子节点个数
    * @Param:
    * @return:
    */
public static int countLeaf(Node root){
    if(root!=null){
        return countLeaf(root.left)+countLeaf(root.right);
    }
    return 0;
}
    /**
     * @Description: 求二叉树的高度
     * @Param:
     * @return:
     */
    private static int height(Node root) {

        if (root != null) {
            int left = height(root.left) + 1;
            int right = height(root.right) + 1;
            return left > right ? left : right;
        }
        return 0;
    }

    /**
     * @Description: 求第k层节点的个数
     * @Param:
     * @return:
     */
    public static int kLevel(Node root, int k) {
        if (k == 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        } else {
            return kLevel(root.left, k - 1) + kLevel(root.right, k - 1);
        }
    }

    /**
     * @Description: 判断两个树是否相等
     * @Param:
     * @return:
     */
    public static boolean isEqual(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        } else {
            //节点的值相等并且左右子树相等
            return (a.val == b.val )&& isEqual(a.left, a.right) && isEqual(b.left, b.right);
        }
    }

    /**
     * @Description: 判定两棵树是否互为镜像对称的树
     * @Param: A的左子树和B右子树互为镜像，
     * @return:
     */
    public boolean isMirror(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        return p.val == q.val
                && isMirror(p.left, q.right)
                && isMirror(p.right, q.left);
    }

    /**
    * @Description: 判断一棵树自己是否是镜像对称的
    * @Param:
    * @return:
    */
public  boolean isSelfMiiro(Node root){
    if(root==null){
        return true;
    }
    return isMirror(root.left,root.right);
}
    /**
     * @Description: 平衡二叉树：左子树与右子树深度相差<1 左右子数高度差不超过1
     * soulution:遍历左子树的
     * @return:
     */
    public boolean isBalanced(Node root) {
        if(root==null){
            return true;
        }
        if(!(isBalanced(root.left))){
            return false;
        }
        if(!(isBalanced(root.right))){
            return false;
        }
        //每层都逐一计算左子树和右子树的高度
        //然后计算高度差
        //一旦有一层不符合就返回false
        int left=hight(root.left);
        int right=hight(root.right);
        int diff=left-right;
        if(diff>1||diff<-1){
            return false;
        }
        return true;
    }

    private int hight(Node root) {

        if(root!=null){
            int left=hight(root.left)+1;
            int right=hight(root.right)+1;
            return left>right ? left:right;
        }
        return 0;
    }


    /**
     * @Description: 判断两个树是否相等
     * solution：前序和中序共同决定一棵二叉树：前序找节点，中序找左右子树
     * @return:
     */


    /**
     * @Description: 找到包含v的节点，返回节点引用，如果没找到 返回null
     * solution:1.空树一定找不到 2.如果是根的值就是！返回跟的值
     * 否则取左子树继续找 如果找到了返回
     * 否则去右子树继续找
     * @return:
     */
//    public static Node find(Node root, char v) {
//        if (root == null) {
//            return null;
//        }
//        if (root.val == v) {
//            return root;
//        } else {
//            Node result = null;
//            result = find(root.left, v);
//            if (result == null) {
//                result = find(root.right, v);
//            }
//            return result;
//        }
//    }

    public static Node find(Node root,char v){
        //1.空树，找不到
        if(root==null){
            return  null;
        }
        //2.判断根节点的value==v?,返回root
        if(root.val==v){
            return root;
        }else{
        //3.去左子树找，找到则返回
            Node res=null;
         res=find(root.left,v);
         if(res==null){
        //4.如果在左子树中找不到了，就再去右子树继续找，找到返回结果
         res=   find(root.right,v);
         }
         return res;
        }
    }

        /**
        * @Description: 另一个树的子树
        * @Param:
        * @return:
        */
        public boolean isSubtree(Node s, Node t) {
           return findTree(s,t);
        }
   private boolean findTree(Node root,Node t){
            if(root==null && t==null){
                return true;
            }
            if(root==null ){
                return false;
            }
            if(isEqual(root,t)){
                return true;
            }
            if(findTree(root.right,t)){
                return true;
            }
            return findTree(root.left,t);
   }

    
    /** 
    * @Description: 创建二叉树
     * 不能用普通的前序遍历创建二叉树
     * 用带空节点的前序遍历创建二叉树
     * class RV{
     *     Node root;
     *     int used;
     * }
     * public RV createTree(整棵树的前序){
     * if(整个树的长度为0){
     *     return RV={NULL.0};
     * }
     *  1.   根的值=前序[0]；
     *     if(rootValue==#){
     *         创建的树是空树，当前创建子树的根节点为null,用了一个节点
     *     }
     *
     *     左子树（root.left）,左子树使用的个数=createTree（整棵树的前序除去char[0]）
     *     右子树（root.right）,右子树使用的个数=cratTree(整棵树的前序除去第一个和左子树用掉的)
     *     return{root,根使用的个数+左子树使用的个数+右子树使用的个数}
     * }
    */

    class ReturnRoot{
      private   Node nowRoot;
       private int used;

        public ReturnRoot(Node nowRoot, int used) {
            this.nowRoot = nowRoot;
            this.used = used;
        }
    }
    public  ReturnRoot creatTree(char[] preOrder){
             if(preOrder.length==0){
                 //如果前序数组长度为0，说明没有树可以创建
                 return new ReturnRoot(null,0);
             }
             //如果长度不为0，则取出第一个节点为根节点
             if(preOrder[0]=='#'){
                 //若根节点为空，则返回根节点为空，使用了1个空节点
              return new ReturnRoot(null,1);
             }else{
             Node root= new Node(preOrder[0]);
                //第一个数组元素作为根节点，利用剩余数组继续创建树的左子树
                 char [] restLeft=Arrays.copyOfRange(preOrder,1,preOrder.length);
                //递归调用创建树，返回值为ReturnRoot
                 ReturnRoot leftReturn=creatTree(restLeft);

                 //左子树创建完后创建右子树，右子树的长度为整棵树的前序除去第一个和左子树用掉的
                 char[] restRight=Arrays.copyOfRange
                         (preOrder,preOrder.length-leftReturn.used,preOrder.length);
                 //递归调用创建右子树，返回值为ReturnRoot
                 ReturnRoot rightRoot=creatTree(restRight);
                 //把根，左子树，右子树链接在一起
                 root.left=leftReturn.nowRoot;
                 root.right=rightRoot.nowRoot;
                 //返回值为根节点，用了的长度为根+左子树用了的+右子树用了的
                 return new ReturnRoot(root,1+leftReturn.used+rightRoot.used);
             }
    }



    public static void main(String[] args) {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.right = h;
        c.left = f;
        c.right = g;

        System.out.println(height(a));
        System.out.println(find(a, 'D'));
        System.out.println(find(a, 'W'));
        BinaryTreeInterview tree=new BinaryTreeInterview();
    ReturnRoot newTree=  tree.creatTree(new char[]{'A','B','C','#','D','#','#','#','E'});
    Node ntree=newTree.nowRoot;
    }
}
