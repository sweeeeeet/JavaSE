package www.sweet.test;

import java.util.Arrays;

/**
 * Author:sweet
 * Created:2019/4/19
 */
//保存两个返回值
class ReturnRoot1 {
    int used;
    Node returnRoot;

    public ReturnRoot1(Node returnRoot, int used) {
        this.used = used;
        this.returnRoot = returnRoot;
    }
}

class Node {
    char val;
    Node left;
    Node right;

    public Node(char val) {
        this.val = val;
        this.right = null;
        this.left = null;
    }
}

public class So {

    public ReturnRoot1 build(String str) {
        if (str == null) {
            return null;
        }
        char[] tree = str.toCharArray();
        if (tree.length == 0) {
            return new ReturnRoot1(null, 0);
        }
        //有值
        Node root = new Node(tree[0]);

        if (tree[0] == '#') {
            return new ReturnRoot1(null, 1);
        } else {
            //处理左子树
            //ABC##DE#G##F###
            char[] leftTree = Arrays.copyOfRange(tree, 1, tree.length);
            ReturnRoot1 left = build(String.valueOf(leftTree));
            //左子树递归完毕，剩余都是右子树，处理右子树
            char[] rightTree = Arrays.copyOfRange
                    (tree,  left.used+1, tree.length);
            ReturnRoot1 right = build(String.valueOf(rightTree));
            //连接根节点与左右子树
            root.left = left.returnRoot;
            root.right = right.returnRoot;
            return new ReturnRoot1(root, 1 + left.used + right.used);
        }
    }

    //中序遍历
    public void travel(Node root) {
        if (root == null) {

        } else {
            //中序：左 根 右

            travel(root.left);
            System.out.print(root.val + " ");
            travel(root.right);
        }
    }


    public static void main(String[] args) {
        So test = new So();
        ReturnRoot1 root = test.build("ABC##DE#G##F###");
        test.travel(root.returnRoot);
        //System.out.println("".toCharArray().length);
    }
}

