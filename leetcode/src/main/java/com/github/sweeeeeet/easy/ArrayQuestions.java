package com.github.sweeeeeet.easy;

import java.util.Arrays;

/**
 * Author:sweet
 * Created:2019/5/16
 */
public class ArrayQuestions {

/*给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。*/
    public int removeElement(int[] nums, int val) {
        int size=nums.length;
        if(size==0){
            return 0;
        }

        int i=0;
        int nosearch=nums.length-1;

        //[3,2,2,3]
        while(i<(nosearch+1)&&size>0){
            //[0,1,2,2,3,0,4,2]
            //已查找区间[0,i-1]
            //未查找区间[i,nums.length-1]

            if(val==nums[i]){
                size--;
                //区间中有值，且要交换的值不与指定值相等就进行交换
                if(size>0){
                    if(val==nums[nosearch]){
                        nosearch--;

                    }else{
                        nums[i]=nums[nosearch--];
                    }
                }
            }else{
                i++;
            }

        }
        return size;
    }

    public int largestPerimeter(int[] A) {

        int len=0;
        for(int i=0;i<A.length;i++){
            int j=i-1;
            int key=A[i];
            //直接插入法：给每个拿到手上的寻找合适的位置
            //5487
            //A[j]是排好序中最大的
            //A[i]是待排序的元素
            for(;j>=0&&A[j]>key;j--){
                //向后搬移
                A[j+1]=A[j];
            }
            //找到合适的位置了
            A[j+1]=key;

        }

        //排序完成
        for(int i=A.length-3;i>=0;i--){
            if(A[i]!=0 && A[i+2]<A[i]+A[i+1]){
                return A[i]+A[i+1]+A[i+2];
            }
        }
        return len;
    }

    /*
    * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
示例:
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    *
    * */
    public int maxSubArray(int[] nums) {

        int sum=0;
        int res=nums[0];
        for(int num:nums){
            //连续求和，如果和已经小于0，无论后面这个数是什么情况，都没必要给sum加上，
            //只需要重新定位连续求和的序列和
            if(sum>0){
                sum+=num;
            }else{
                sum=num;
            }

            //找最大的序列和
            res=res>sum?res:sum;
        }
        return res;

    }
    public static void main(String[] args) {
            int[]  arr=new int[]{2,1,2};
    }
}
