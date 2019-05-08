package www.sweet.heap;

import sun.java2d.pipe.AATextRenderer;

import java.util.Arrays;

/**
 * Author:sweet
 * Created:2019/5/4
 */
public class PracticeSort {
    public static void insert(int[] array){
        //每拿到一个元素就为它找到合适的位置
        for(int i=0;i<array.length;i++){
            int j=i-1;
            int key=array[i];
            //从后向前找，如果大于等于目前在找的前一个值j，就说明j+1是合适的位置了
            //有序区间[0,i)
            //无序区间[i,array.length)
            for(;j>=0&&array[j]>key;j--){
                //说明需要继续前进，同时将有序区间的值后移
                array[j+1]=array[j];
            }
            //跳出循环，说明>=最后一个值了，直接放在j+1位置即可
            array[j+1]=key;
        }
    }
    public static void shellSort(int[] array){
        int gap=array.length;//10
        //每隔gap分为一组，直到gap=1
        while(gap>1){
            //当gap>1都是分组预排，最后一次gap==1时已经接近整体有序，降低了最坏情况的时间复杂度
            gap=(gap/3)+1;//4，2，1
            //分组插排
            inserWithGap(array,gap);
        }
    }

    private static void inserWithGap(int[] array, int gap) {
        for(int i=0;i<array.length;i++){
            int j=i-gap;
            int key=array[i];
            for(;j>=0&&array[j]>key;j-=gap){
                //向后搬移
                array[j+gap]=array[j];
            }
            array[j+gap]=key;
        }
    }

    public static void selectSort(int[] array){
//        //选出无序区间最大的元素，放到有序区间的最后一个
//        for(int i=0;i<array.length;i++){
//            int max=0;
//            //无序区间：[0,array.length-i)
//            //有序区间:[array.length-i,array.length)
//            for(int j=1;j<array.length-i;j++){
//                if(array[j]>array[max]){
//                    max=j;
//                }
//            }
//            swap(array,max,array.length-1-i);
//        }
        //在无序区间选出最小的，放到有序区间的第一个
        for(int i=0;i<array.length;i++){
           int min=i;
           //有序区间[0,i)
            //无序区间[i,array.length)
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            swap(array,min,i);
        }
    }

    private static void swap(int[] array, int max, int i) {
        int t=array[max];
        array[max]=array[i];
        array[i]=t;
    }

    public static void bubbleSort(int[] array){
        //把最小的冒泡到最前面
        boolean isSort=false;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[j-1]){
                    swap(array,j,j-1);
                    isSort=true;
                }
            }
            if(!isSort){
                break;
            }
        }

    }

//    public static void heapSort(int[] array){
//        //1.构建一个大堆
//        int noLeaf=(array.length-1-1)/2;
//        for(;noLeaf>0;noLeaf--){
//            heapify(array,array.length,noLeaf);
//        }
//        //利用减治算法，交换第一个数和最后一个数，再利用向下调整
//        // 使最小的值在最上面，最大的在最后
//        for(int i=0;i<array.length;i++){
//            //无序区间：[0,array.length-i)
//            //有序区间[length-i,array.length)
//
//            swap(array,0,array.length-i-1);
//            heapify(array,array.length-1-i,0);
//        }
//    }
//
//    private static void heapify(int[] array, int size,int nowParent) {
//        int max = nowParent * 2 + 1;
//        if (max > size) {
//            return;
//        }
//        if (max + 1 < size && array[max + 1] > array[max]) {
//            max++;
//        }
//        //与根比较
//        if (array[nowParent] > array[max]) {
//            return;
//        }
//
//        //叶子比根大，调整
//        int t = array[max];
//        array[max] = array[nowParent];
//        array[nowParent] = t;
//        //继续向下调整
//        heapify(array, size,max);
//    }

    private static void heapify(int[] array, int size, int index) {
        // 1. 判断 index 是不是叶子
        while (2 * index + 1 < size) {
            // 2. 找到最大的孩子的下标
            int max = 2 * index + 1;
            if (max + 1 < size && array[max + 1] > array[max]) {
                max = 2 * index + 2;
            }

            // 3. 判断最大的孩子和根的值
            if (array[index] < array[max]) {
                swap(array, index, max);

                index = max;
            } else {
                // 4. 根的值比较大，可以直接结束了
                // 不交换，也不继续往下走了
                break;
            }
        }
    }

    private static void createHeap(int[] array) {
        // [从最后一个非叶子结点的下标, 根] 向下调整
        // [(array.length - 2) / 2, 0]

        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            heapify(array, array.length, i);
        }
    }

    // 堆排序
    public static void heapSort(int[] array)
    {
        // 建堆   大堆
        createHeap(array);

        // 减治处理
        for (int i = 0; i< array.length; i++) {
            // 无序 [0, length - i - 1]
            // 有序 [length - i, length)
            // 最大的数在 [0], 最大的数应该放到的下标是
            // [length - i  - 1]
            swap(array, 0, array.length - 1 - i);
            // 处理 [0] , 无序剩余部分满足堆的性质
            // 无序 [0, length - i - 2]
            // 有序 [length - i - 1, length)
            // size 剩余无序部分的长度
            heapify(array, array.length - 1 - i, 0);
        }
    }

public static void quickSort(int[] array){
        quickSortInner(array,0,array.length-1);
}

    private static void quickSortInner(int[] array, int left, int right) {

        if(left>=right){
            return;
        }
    //以基准值为界，分为左右两个区间
        int pirvotIndex=partation(array,left,right);
        //分别对左右两个区间做相同的处理
        quickSortInner(array,left,pirvotIndex-1);
        quickSortInner(array,pirvotIndex+1,right);
        //直到区间中只有一个数或者没有数为止

    }

    private static int partation(int[] array, int left, int right) {
        //hover：左边区间向前逼近，不满足条件了就走右边下标，
        //左右都不满足条件了，就说明他们的需求正好相反（该大的小 该小的大）
        // 交换两个值，又必定有一个能继续前进了
        int begin=left;
        int end=right;
        int pirvot=array[right];
       while (begin<end){
           while (begin<end&&array[begin]<=pirvot){
               begin++;
           }
           while (begin<end&&array[end]>=pirvot){
               end--;
           }
           //说明停下了，则交换值
           swap(array,begin,end);
       }
       //退出循环 说明分离完成
        swap(array,begin,right);
        return begin;
    }

    private static int partation2(int[] array, int left, int right) {
        //挖坑法：把end下标处当作一个临时的坑，有需要移动值时，借助这个坑交换值，
        // 把坑挪到正确的位置了之后，最后把基准值填入坑
        int begin=left;
        int end=right;
        int pirvot=array[right];
        while (begin<end){
            while (begin<end&&array[begin]<=pirvot){
                begin++;
            }
            //停下来了array[begin]>基准值
            array[end]=array[begin];
            while (begin<end&&array[end]>=pirvot){
                end--;
            }
            //相当于一直在调整基准值的位置
            array[begin]=array[end];
        }
        array[end]=pirvot;
        return begin;
    }

    private static int partation3(int[] array, int left, int right) {
        //前后下标法：
        return 0;
    }

    public static void mergrSort(int[] array){
        int[] extra=new int[array.length];
        mergrSortInner(array,0,array.length,extra);

    }

    private static void mergrSortInner(int[] array, int low, int high, int[] extra) {
        if(low==high-1){
            //区间中只有一个数就不用再分治了
            return;
        }
        if(low>=high){
            //区间中没有数了，不用再分了
            return;
        }
        int mid=low+(high-low)/2;
        mergrSortInner(array,low,mid,extra);
        mergrSortInner(array,mid,high,extra);
        //分治完成后，对两个数组进行归并
        merge(array,low,mid,high,extra);
    }

    private static void merge(int[] array, int low, int mid, int high, int[] extra) {
        int left=low;
        int right=mid;
        int x=0;
        //保证区间中还有值
        while (left<mid&&right<high) {
            if(array[left]<array[right]){
                extra[x++]=array[left++];
            }else{
                extra[x++]=array[right++];
            }
        }
            //若两个数组的长度不相等，有一个数组有剩余
            while (left<mid){
                extra[x++]=extra[left++];
            }
            while (right<high){
                extra[x++]=extra[right++];
            }
            //拷贝回原数组
            for(int i=low;i<high;i++){
                array[i]=extra[i-low];
            }

    }

    public static void main(String[] args) {
//       int[] t= new int[]{3,1,2};
        int[] array = new int[]{1, 0, 2, 7, 5, 3, 7, 2, 9, 5};
//        System.out.println(midOfThreeNum(t,0,t.length-1));;
        // mergeSort(array);
        mergrSort(array);
        System.out.println(Arrays.toString(array));
    }
}
