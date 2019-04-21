package www.sweet.tree;

import java.util.Arrays;

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

public class BinaryTreeInterview {

    /**
     * @Description: 利用前序+中序构建二叉树
     * 1在前序中找到根的值 preOrder[0]
     * 2在中序中找到根的值所在的下标--》可得到左子树的节点个数
     * 3.切出左子树的前序+中序 ：preOder跳过1，长度是下标;  inOrder，长度是下标
     * 4.切出右子树的前序+中序：preOder跳过1，跳过下标（到达右子树），长度为总长-左子树长度
     * inOrder:跳过下标，跳过1，长度为总长-下标
     */
    public TreeNode buildTree12(int[] preorder, int[] inorder) {
        if(preorder==null){
            return null;
        }
    //1.在前序中找到根的值
        TreeNode root=new TreeNode(preorder[0]);
        //2.在中序中找到根所在的下标==左子树的节点个数
        int leftSize=-1;
        for(int i=0;i<inorder.length;i++) {
            if (inorder[i] == preorder[0]) {
                leftSize = i;
            }
        }
    //前序：ABCDE
    //中序：CDBAE
            //3.切出左子树的前序:copyOfRange()函数参数的区间--左闭右开
            int[] leftPreOrder=Arrays.copyOfRange(preorder,1,leftSize+1);
            //切出左子树的中序
            int[] leftInOrder=Arrays.copyOfRange(inorder,0,leftSize);
          TreeNode  rootLeft=buildTree12(leftPreOrder,leftInOrder);
          //4.切出右子树的前序
            int[] rightPreOrder=Arrays.copyOfRange(preorder,leftSize+1,preorder.length);
            //切出右子树的中序
            int[] rightInOrder=Arrays.copyOfRange(inorder,leftSize+1,inorder.length);
            TreeNode rightRoot=buildTree12(rightPreOrder,rightInOrder);
            root.left=rootLeft;
            root.right=rightRoot;
            return root;

    }
    
    /** 
    * @Description: 通过中序和后序遍历构建二叉树
    * @Param:  
    * @return:  
    */

    public TreeNode buildTree23(int[] inorder, int[] postorder){
        if(inorder.length==0){
            return null;
        }
        //1.在后序中找到根节点
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        //2.得到左子树的长度
        int leftSize=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                leftSize=i;
            }
        }
        //3.切出左子树的中序
int[] leftInOrder=Arrays.copyOfRange(inorder,0,leftSize+1);
        //切出左子树的后序
        int[] leftPostOrder=Arrays.copyOfRange(postorder,0,leftSize);
      root.left=buildTree23(leftInOrder,leftPostOrder);
//    中序遍历 inorder = [9,3,15,20,7]
//    后序遍历 postorder = [9,15,7,20,3]
      //4.切出右子树的中序
        int[] rightInOrder=Arrays.copyOfRange(inorder,leftSize+1,inorder.length);
        //切出右子树的后序:copyOfRange()函数是对索引取左闭右开
        int[] rightPostOrder=Arrays.copyOfRange(postorder,leftSize,postorder.length-1);
        root.right=buildTree23(rightInOrder,rightPostOrder);
        return root;

    }


}
