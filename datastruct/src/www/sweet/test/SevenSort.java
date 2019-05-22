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
return null;

}

    public static void main(String[] args) {
        int[] arr =new int[]{2,5,1,5,6,9,3,4};
        System.out.println(Arrays.toString(selectSort(arr)));;
    }

}
