package com.github.sweeeeeet.easy;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author:sweet
 * Created:2019/5/16
 */
public class StringQuestions {

    /*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    有效字符串需满足：
            1.左括号必须用相同类型的右括号闭合。
            2.左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

    来自<https://leetcode-cn.com/problems/valid-parentheses/>
    */
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();

        if (s != null) {
            for (int i = 0; i < s.length(); i++) {
                String ch = String.valueOf(s.charAt(i));

                switch (ch) {
                    case "(":
                    case "{":
                    case "[":
                        stack.push(ch);
                        break;
                    default:
                }
                switch (ch) {
                    case ")":
                        if (stack.empty()) {
                            //若果只有右括号或左括号已经全部出栈，也不匹配
                            return false;
                        }
                        if (!("(".equals(stack.pop()))) {
                            return false;
                        }
                        break;
                    case "}":
                        if (stack.empty()) {
                            //若果只有右括号或左括号已经全部出栈，也不匹配
                            return false;
                        }
                        if (!("{".equals(stack.pop()))) {
                            return false;
                        }
                        break;
                    case "]":
                        if (stack.empty()) {
                            //若果只有右括号或左括号已经全部出栈，也不匹配
                            return false;
                        }
                        if (!("[".equals(stack.pop()))) {
                            return false;
                        }
                        break;


                    default:
                }


            }
        }
        //字符串遍历结束，如果栈中还有元素 说明也不匹配
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
    /*编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。

    来自 <https://leetcode-cn.com/problems/longest-common-prefix/>
*/

    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder(strs[0]);
        //取字符串,横向找公共前缀
        for (int i = 1; i < strs.length; i++) {
            String tem = sb.toString();
            sb = sb.delete(0, tem.length());
            if (tem == "") {
                return "";
            }
            //对每个字符串进行判断
            for (int j = 0; j < tem.length(); j++) {
                //j是字符串的长度，
                if (j >= strs[i].length()) {
                    break;
                }
                if (tem.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                sb.append(strs[i].charAt(j));
            }
        }
        return sb.toString();
    }

    /*  将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
      来自 <https://leetcode-cn.com/problems/merge-two-sorted-lists/>
       * Definition for singly-linked list.
       *  class ListNode {
       *     int val;
       *     ListNode next;
       *     ListNode(int x) { val = x; }
       * }
       */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode last = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        if (cur1 == null) {
            return cur2;
        }
        if (cur2 == null) {
            return cur1;
        }

        while (cur1 != null && cur2 != null) {
            if (cur1.val >= cur2.val) {
                //将较小的先尾插进新链表中
                ListNode next = cur2.next;
                cur2.next = null;
                if (result == null) {
                    cur2.next = result;
                    result = cur2;
                    last = result;
                } else {
                    last.next = cur2;
                    last = cur2;
                }
                cur2 = next;
            } else {
                ListNode next = cur1.next;
                cur1.next = null;
                if (result == null) {
                    cur1.next = result;
                    result = cur1;
                    last = result;
                } else {
                    last.next = cur1;
                    last = cur1;
                }
                cur1 = next;
            }
        }

        if (cur1 == null) {
            if (result == null) {
                cur2.next = result;
                result = cur2;
                last = result;
            } else {
                last.next = cur2;
                last = cur2;
            }
        }
        if (cur2 == null) {
            if (result == null) {
                cur1.next = result;
                result = cur1;
                last = result;
            } else {
                last.next = cur1;
                last = cur1;
            }

        }
        return result;
    }

    /*给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，
    返回移除后数组的新长度。
    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成*/
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (i + 1 < size && nums[i] == nums[i + 1]) {
                int step = 1;
                while (i + step < size && nums[i] == nums[i + step]) {
                    step++;//2

                }
                int j = i + 1;
                step -= 1;
                for (; j < size - step; j++) {

                    nums[j] = nums[j + step];
                }
                nums[j] = nums[size - 1];
                size = size - step;//2

            }
        }

        return size;
    }


    /*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
Soluion:斐波那契数列
*/
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int x = 0;
        for (int i = 2; i < n; i++) {
            x = a + b;
            a = b;
            b = x;
        }
        return x;
    }



    /*给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，
    使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。

举个例子，A = "abcd"，B = "cdabcdab"。
答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，
此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。

注意:
 A 与 B 字符串的长度在1和10000区间范围内。*/
    public int repeatedStringMatch(String A, String B) {
        int lenA=A.length();
        int lenB=B.length();
        StringBuffer sb =new StringBuffer();
        //其中“lenB / lenA”代表的B串中间A重复的次数，“+2”代表的首尾各添加一个A串
        for(int i=0;i<(lenB/lenA+2);i++){
            String str = sb.append(A).toString();
            if(str.contains(B)){
                return i+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
    }
}


