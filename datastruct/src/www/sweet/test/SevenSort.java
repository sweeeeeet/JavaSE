package www.sweet.test;

import java.util.Arrays;

/**
 * Author:sweet
 * Created:2019/5/21
 */
public class SevenSort {

    /*
    * 直接插入排序：排升序，把最大的放到需要排序区间的最后面
    * 稳定；时间复杂度：最好有序O(n)，最坏O(n^2),平均O(n^2)
    * */
    public static int[] insert(int[] array){
        //从第一张开始抓牌
      for(int i=0;i<array.length;i++){
          int key=array[i];

          //已经整理顺序的牌的最后一个下标
          int j=i-1;

          //如果整理好顺序的牌的最后一张都是小于我抓起来的牌，
          // 那么只需要插在已排序好牌的后面即可

          //否则就需要把牌往后挪一个，为我手上的牌六个空位
          for(;j>=0&&array[j]>key;j--){
              array[j+1]=array[j];
          }
          array[j+1]=key;
      }
      return array;
    }


/*
* 希尔排序：利用分组插排的方式，逐步缩进步长，最终对整个数组序列进行排序
*
* 稳定；时间复杂度：O（n），O（n^2）,O(n^1.3--n^2)
* */


public static int[] shellSort(int[] array){
    int step=3;
    while(step>=1) {
    for(int i=0;i<array.length;i+=step){
        int key=array[i];
        int j=i-1;
        for(;j>=0&&array[j]>key;j--){
            array[j+1]=array[j];

        }
        array[j+1]=key;
    }

    step--;
    }
    return array;
}


/*
* 冒泡排序：对数组进行遍历，对每前后两个数进行比较，遇到大的就搬到后面
* */

public static int[] bubbleSort(int[] array){
  /*for(int i=0;i<array.length;i++){
  //把大的向后搬，浮上去的就是小泡泡
      for(int j=1;j<array.length-i;j++){
          if(array[j-1]>array[j]){
              int t=array[j];
              array[j]=array[j-1];
              array[j-1]=t;

          }
      }

  }*/


  for(int i=0;i<array.length;i++){

      //把小泡泡向前排，就需要从最后一个找起
      for(int j=array.length-1;j>i;j--){
          if(array[j]<array[j-1]){
              int t=array[j];
              array[j]=array[j-1];
              array[j-1]=t;
          }
      }
  }
  return array;
}


/*
* 对每一个元素进行遍历，两两比较，,将最大的记录下来，每一次找完之后将最大的放到排好序区间的第一个
* */
public static int[] selectSort(int[] array){
    int max=0;
   for(int i=0;i<array.length;i++){
       for(int j=1;j<array.length-i;j++){
           if(array[j]>array[max]){
               max=j;
           }
       }
       int t=array[max];
       array[max]=array[array.length-1-i];
       array[array.length-1-i]=t;
   }

    return array;
}



/*
* 归并排序：将数组等分，直到分到区间中只有一个值或者没有值为止
*           通过一个外部数组，将经过排序后的元素，一次归并到外部数组中，然后把外部数组赋给原数组
* */
public static int[] mergeSort(int[] array){
    int[] extra=new int[array.length];
    mergeInner(array,0,array.length,extra);

return array;

}

    private static void mergeInner(int[] array, int left, int right, int[] extra) {
    //如果区间中只有一个数，或是不存在数了，就不进行均分了
    if(left==right-1){
        return;
    }
    if(left>=right){
        return;
    }

    int mid=left+(right-left)/2;
    mergeInner(array,left,mid,extra);
    mergeInner(array,mid,right,extra);

    merge(array,left,mid,right,extra);

    }

    private static void merge(int[] array, int left, int mid, int right, int[] extra) {
    //对于每个进行分治的小区间进行排序，将排序好的数组赋给源数组
        int i=left;
        int j=mid;
        int x=0;
        while (i<mid&&j<right){
            if(array[i]<array[j]){
                extra[x++]=array[i++];
            }else {
                extra[x++] = array[j++];
            }

        }
        //处理某一边有剩余的数的情况
        while (i<mid){
            extra[x++]=array[i++];
        }
        while (j<right){
            extra[x++]=array[j++];
        }

        //将排序后的数组赋给源数组
        for(int k=left;k<right;k++){
            array[k]=extra[k-left];
        }
    }

    /*
    * 快速排序分为三大步：1.找基准值
    *                   2.比基准值大的放右边，比基准值小的放左边
    *                   3.对左右区间采用分治
    * */
    public static int[] quickSort(int[] array){


    quickSortInner(array,0,array.length-1);
    return array;
    }

    private static void quickSortInner(int[] array, int left, int right) {
        if(left>=right){
            return;
        }

    //1.找基准值
        int pirvot=right;
        //进行基准值排序
        int pirvorIndex=partation(array,left,right,pirvot);
        //采用分治思想，对两边的区间递归处理
        quickSortInner(array,left,pirvorIndex-1);
        quickSortInner(array,pirvorIndex+1,right);
    }

    private static int partation(int[] array, int left, int right, int pirvot) {
        //利用挖坑法进行基准值排序
        int begin=left;
        int end=right;
        while (begin<end){
            while ( begin<end&& array[begin]<=array[pirvot]){
                begin++;
            }
            while (begin<end&&array[end]>array[pirvot]){
                end--;
            }
            swap(array,begin,end);
        }

        swap(array,begin,pirvot);

        return begin;
    }

    private static void swap(int[] array, int a, int b) {
        int t=array[a];
        array[a]=array[b];
        array[b]=t;
    }

public static int[] heapSort(int[] array){
        makeHeap(array);
      for(int i=0;i<array.length;i++){
          heapSortInner(array,i,array.length-i-1);
      }
        return array;
}

    private static void heapSortInner(int[] array, int first, int last) {
        for(int i=first;i<last;i++){
            swap(array,first,last);
            heapify(array,last,0);
        }
    }

    private static void makeHeap(int[] array) {
        //从最后一个非叶子节点
        int node=(array.length-2)/2;
        for(int i=node;i>=0;i--){
            heapify(array,array.length,i);
        }
    }

    private static void heapify(int[] array, int size,int node) {

        //建大堆：父节点比孩子节点大
        //1.判断当前节点是不是叶子节点，若是，则不需要进行
        //2.找左孩子，找右孩子
        //3.若只有左孩子，这就是最大的 孩子节点
        //若有右孩子，比较左右孩子，选出最大的
        //最大的孩子接待你与根比较，如果比根大，就交换
        while (2*node+1<size){
            int max=2*node+1;
            if(max<size){
                if(max+1<size){
                    if(array[max+1]>array[max]){
                        max=max+1;
                    }
                }
            }

            //max为最大的孩子节点
            if(array[max]>array[node]){
                swap(array,max,node);
            }else{
                //堆化的前提是：只有当前节点不满足堆，因此做break处理即可
                break;
            }

            node=max;
        }
    }


    public static void main(String[] args) {
        int[] arr =new int[]{2,5,1,5,6,9,3,4};
        System.out.println(Arrays.toString(heapSort(arr)));;
    }

}
