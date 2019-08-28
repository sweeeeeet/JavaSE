package com.github.sweeeeeet.middle;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author:sweet
 * Created:2019/5/16
 */
public class StringQuestions {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，
    返回从右侧所能看到的节点值。*/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                count--;
                TreeNode node = queue.poll();
                if (count == 0) {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return list;
    }


    class Solution {
//        public int longestPalindromeSubseq(String str) {
//            for(int i=0;i<str.length();i++){
//                str.substring(i);
//            }
//        }

        public boolean isHuiWen(String str){
            StringBuilder sb=new StringBuilder(str);
            return sb.reverse().equals(sb);

        }
    }
}

