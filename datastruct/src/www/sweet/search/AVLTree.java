package www.sweet.search;

import java.util.function.Predicate;

/**
 * Author:sweet
 * Created:2019/6/1
 */
public class AVLTree {
    public static class Node {
        int key;
        int value;
        //int factor;-1,0,1
        int height = 1;
        Node left = null;
        Node right = null;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public boolean insert(int key, int value) {
        try {
            root = insertInternal(root, key, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Node insertInternal(Node node, int key, int value) throws Exception {
        if (node == null) {
            return new Node(key, value);
        } else if (node.key == key) {
            throw new Exception("key值冲突了");
        } else if (node.key < key) {
            //要插入的值比根节点大，插入做子树中
            node.left = insertInternal(node.left, key, value);
            //判断调整AVL树
            //若果不是平衡树了
            if (height(node.left) - height(node.right) >= 2) {
                //判断左子树高了，还是右子树高了，进行旋转调整
                if (height(node.left.left) > height(node.left.right)) {
                    //如果插入左子树，并且左子树的左边大于左子树的右边，则对根节点进行右旋
                    node = rightRotate(node);
                } else {
                    //插入到了左子树的右节点，对左子树进行左旋，根节点变为左子树节点
                    node.left = leftRotate(node.left);
                    //然后再对当前node做右旋
                    node = rightRotate(node);
                }
            }
        } else {
            //如果插入的值小于根节点的值，那么就需要插入了进右子树
            if (height(node.right.left) > height(node.right.right)) {
                //如果右子树的左边比右边高
                //先对右子树进行右旋，再对根节点进行左旋
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            } else {
                //右节点的右子树比左子树高
                //对根节点进行左旋即可
                node = leftRotate(node);
            }
        }

        //更新根节点的高度
        node.height = updateHeight(node);
        return node;
    }

    private Node rightRotate(Node node) {
        //右旋的结果为：当前节点的左子树的右子树 成为根节点的左子树，
        // 根节点成为根节点左子树的右子树
        Node original = node.left;
        node.left = original.right;
        original.right = node;

        node.height = updateHeight(node);
        original.height = updateHeight(original);
        return original;
    }

    private int updateHeight(Node node) {
return max(height(node.right),height(node.left))+1;
    }
private int max(int a,int b){
        return a>b?a:b;
}


    private int height(Node node) {
return node==null? 0:node.height;
    }


    /*
     * 左旋
     * */
    private Node leftRotate(Node node) {
        Node originalRigth = node.right;
        node.right = originalRigth.left;
        originalRigth.left = node;
        node.height = updateHeight(node);
        return originalRigth;
    }
    /**
     * 1. 验证每个结点中的高度 == 真实的高度
     * 2. 每个结点的左右子树高度差不能超过 |1|
     * 3. 中序是有序的
     */
    private void inorder(Node node, Predicate<Node> tester) {
        if (node != null) {
            inorder(node.left, tester);
            if (!tester.test(node)) {
                throw new RuntimeException("key: " + node.key);
            }
            inorder(node.right, tester);
        }
    }

    public void verifyHeights() {
        inorder(root, (Node node) -> {
            int actualHeight = getHeight(node);
            return actualHeight == node.height;
        });
    }

    public void verifyBalance() {
        inorder(root, (Node node) -> {
            int differ = height(node.left) - height(node.right);
            return differ >= -1 && differ <= 1;
        });
    }

    public void verifyOrdering() {
        class Cache {
            public int lastKey = Integer.MIN_VALUE;
        }

        final Cache cache = new Cache();

        inorder(root, (Node node) -> {
            // 要保证 node.key 永远是大于等于上一个给过来的 node.key
            boolean r =  node.key >= cache.lastKey;
            cache.lastKey = node.key;
            return r;
        });
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return max(left, right) + 1;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        for (int i = 1000; i > 0; i--) {
            tree.insert(i, i);
        }

        tree.verifyHeights();
        tree.verifyBalance();
        tree.verifyOrdering();
    }
}
