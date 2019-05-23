package www.sweet.search;

/**
 * Author:sweet
 * Created:2019/5/17
 */
public class BSTree {
    private static class Node {
        Node left = null;
        Node right = null;
        int key;

        public Node(int key) {
            this.key = key;
        }


    }

    Node root = null;


    /**
     * @Description:
     * @Param: [node, key] node:待插入的子树的根节点  key:要插入的值
     * @return: void
     */
    private Node insertInner(Node node, int key) throws Exception {
        if (node == null) {
            return new Node(key);
        }
        if (key == node.key) {
            throw new Exception("二叉树中不允许重复的值");
        }
        if (key < node.key) {
            node.left = insertInner(node.left, key);
        } else {
            node.right = insertInner(node.right, key);
        }
        return node;
    }

    public Node insert(int key) throws Exception {
        return insertInner(this.root, key);
    }


    private boolean containsInner(Node node, int key) {
        if (node == null) {
            return false;
        }
        if (node.key == key) {
            return true;
        }
        if (containsInner(node.left, key)) {
            return true;
        } else {
            return containsInner(node.right, key);
        }
    }

    //利用二叉树的特点 左边的比根节点小 右边 的比根节点大
    public boolean contains(int key) {
        return containsInner(this.root, key);
    }
    /*
     * 删除节点：
     * 1.叶子节点
     * 2.只有一个孩子节点--》这个孩子继承大统
     * 3.俩孩子：替换删除算法{左子树中选出最大的或者右子树中最小的
     *                      替换到删除的节点处，然后删除这个最大的节点}
     * */
}
