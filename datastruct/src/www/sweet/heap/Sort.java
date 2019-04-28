package www.sweet.heap;

import java.util.Arrays;

/**
 * Author:sweet
 * Created:2019/4/26
 */
public class Sort {
    /**
     * @Description: 堆排序 （升序）--->建大堆
     * 只能选最大的放前面，不能选最小的放前面
     *O(N*Logn)
     */

    public int[] heapSort(int[] array){
        //建大堆:从第二个叶子节点开始
        for(int i=(array.length-2)/2;i>0;i--){
            biggestHeaplify(array,array.length,i);
        }

        //1.将第一个和最后一个交换
        for(int j=0;j<array.length;j++){
            //无序[0,array.lenth-j)

            int i=array[0];
            array[0]=array[array.length-1-j];
            array[array.length-1-j]=i;

            //有序[array.length-j,array.length]
            //每次减去一个，从头开始向下调整
            biggestHeaplify(array,array.length-1-j,0);
        }

        //2.向下调整
        //3.减一
        //4.重复
        return array;
    }

    public void biggestHeaplify(int[] array,int size,int index){
        //给定节点，向下调整
        //找左右孩子
        int max=2*index+1;
        while (max<size){

            if(max+1<size && array[max+1]>array[max]){
                max=max+1;
            }
            //其余情况 max为左孩子
            //比较根
            if(array[index]>array[max]){
                break;
            }
            int t=array[max];
            array[max]=array[index];
            array[index]=t;
            index=max;
            max=2*index+1;
        }
    }


    /**
     * @Description: 选择排序 （升序）
     *
     * 既可以选最大的放前面，不能选最小的放前面
     */
   static int[] selsectSort(int[] array){
        for(int i=0;i<array.length;i++){
            int max=0;

            //无序：[0，array.lenth-i）
            //有序:[array.length-i,array.length]
            for(int j=1;j<array.length-i;j++){
                if(array[j]>array[max]){
                    max=j;
                }
            }
            //一轮循环走完，减少一个
            //每次都把最大的放到有序区间的最后一个
            int t=array[max];
            array[max]=array[array.length-1-i];
            array[array.length-1-i]=t;

        }

        return array;
    }


    /**
    * @Description: 直接插入排序
    * 时间复杂度：
     * 最坏：n^2
     * 平均：n^2
     * 最好：n^2
    */
public static void insertSort(int[] array){
    for(int i=0;i<array.length;i++){
        //有序：[0,i)
        //无序：[i,array.length)

        //1.在有序区间遍历查找，从后往前
        int j=0;
        for(j=i-1;j>=0&&array[i]<array[j];j--){
                //执行循环，找合适位置
        }
        //array[i]>=array[j]
        //j+1是要插入的位置
//        插入数据,从后向前搬移数据
        int pos=j+1;
        int key=array[i];
        for(int k=i;k>pos;k--){
            array[k]=array[k-1];
        }
        array[pos]=key;
    }
}

/**
* @Description:  直接插入排序,找下标和搬移的过程合并！！！！！
* 时间复杂度：
* 最坏（逆序）：n^2
* 平均：n^2
* 最好（有序）：n^2
 * 空间复杂度：O(1)
 * 稳定性：稳定
*/
    public static void insertSortPlus(int[] array){
    for(int i=0;i<array.length;i++){
        int j=i-1;
        int key=array[i];
        /*
        * 在有序区间中，为array[i]找到一个合适的位置，保证稳定的前提下
        * */
        for(;j>=0&&array[j]>key;j--){
            /*
            * 把array[i]插入到合适的位置处
            * */
            //有序区间的值比要插入的值大了，就把他往后搬
            array[j+1]=array[j];
        }
       //不满足循环条件，说明要插入的数据小于了有序区间当前的数
        array[j+1]=key;
    }


    }
    /**
    * @Description: 利用二分法做直接插入排序
    * @Param: [array]
    * @return: void
     * 时间复杂度：
     * 空间复杂度：
    */
    public static void binaryInsertSortPlus(int[] array){
        for(int i=0;i<array.length;i++){
            int key=array[i];
            int left=0;
            int right=i;
            while(left<right){
                int mid=left+(right-left)/2;
                if(key==array[mid]){
                    //维护稳定性
                    left=mid+1;
                }else if(key<array[mid]){
                    //说明在左侧
                    right=mid;
                }else{
                    left=mid+1;
                }
            }

            int pos=left;
            for(int k=i;k>pos;k--){
                array[k]=array[k-1];
            }
            array[pos]=key;
        }
    }

    /**
    * @Description: 希尔排序：
     * 因为数据越接近有序，插入排序的效率越高
     * 希尔排序通过分组插排的方法让数据基本有序 再进行插排
     * 分组多大合适：分组分的越多，大的数往后走的越快
     *              分组越少 拍完后越接近有序
     *      因此进行多次分组插排：分组个数从大到小{gap=length gap=(gap/3)+1  gap=gap/2}
     *  最好情况：O（n）
     *  最坏情况：O（n^2）
     *  希尔排序的意义：让最坏情况的概率变小了
     * 空间复杂度：O（1）
     * 稳定性：不稳定
    */
    public static void shellSort(int[] array){
        int gap=array.length;
        while(true){
            //gap=gap/2
            gap=(gap/3)/2;
            insertSortWithGap(array,gap);
        }

    }
    private static   void insertSortWithGap(int[] array,int gap){
        for(int i=0;i<array.length;i++){
            int j=i-gap;
            int key=array[i];
            for(;j>=0&&array[j]>key;j-=gap){
                array[j+gap]=array[j];
            }
            array[j+gap]=key;
        }
    }


    /**
    * @Description:堆排序(层序遍历出来是个有序数组)
    * @Param: [array]
    * @return: void
     * 时间复杂度：O（n*log(n)）
    */
    private static void heapSotP(int[] array){
        createHeap(array);
        //减治处理
        for(int i=0;i<array.length;i++){
            //无序[0,length-i-2]
//            有序[length-i-1,length-1]
            //最大的数在【0】，最大数应该放到的下标是：【length-1-i】
            swap(array,0,array.length-i-1);
            heapify(array,array.length-1-i,0);
        }
    }

    //建堆
    private static void createHeap(int[] array){
        for(int i=(array.length-2)/2;i<array.length;i++){
            heapify(array,array.length,i);
        }

    }

    //向下调整
    private static void heapify(int[] array, int size,int i) {
        int max=i*2+1;
        if(max>array.length){
            return;
        }
        int right=max+1;
        if(right>array.length){
            return;
        }
        if(array[right]>array[max]){
            max=right;
        }
        if(array[i]>array[max]){
            return;
        }
        int t=array[i];
        array[i]=array[max];
        array[max]=t;
        heapify(array,array.length,max);

    }

    /**
     * @Description:冒泡排序
     * @Param: [array]
     * @return: void
     */
    public static void bubbleSort(int[] array){
        //最小的冒泡到最前面
        //要把最小的数冒泡到最前面，需要从后往前冒泡
        boolean isSort=true;
        for(int i=0;i<array.length;i++){
            for(int j=array.length-1;j>i;j--){
                if(array[j]<array[j-1]){
                    swap(array,j,j-1);
                    isSort=false;
                }
            }
            if(isSort){
                break;
            }
        }


    }
    /**
     * @Description:选择排序
     * @Param: [array]
     * @return: void
     */
    public static void selectSort(int[] array){
        //减治算法
        //每次找出最小的放到无序区间的最开始
        for(int i=0;i<array.length;i++){
            int min=i;
            //有序：[0,i)
            //无序[i,arraylength)
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            //找出最小的后进行交换
            swap( array,min,i);
        }
    }

    private static void swap(int[] array, int min, int i) {
        int temp=array[i];
        array[i]=array[min]  ;
        array[min]=temp;
    }


    /*
    * 快速排序
    * 1.选择一个基准值（区间最右边的数）
    * 2.遍历整个区间 ，每个数都和基准值作比较，并且发生一定的交换
    * 遍历结束后，使得：比基准值小（等于）的数都在基准值的左边
    *                   比基准值大的数都在基准值的右边
    * 3.分治算法：分别对左右两个小区间进行同样的方式处理，
    *   直到小区间size==0或size==1
    *
    * */
    private static void quickSort(int[] array){
        quickSortInner(array,0,array.length-1);
    }
    private static void quickSortInner(int[] array,int left,int right){
        //直到size==1||size==0
        if(left>=right){
            return;
        }
        //要排序的区间是array[left,right]
        //1.找基准值，array[right]
        //2.遍历整个区间，把区间分为三部分
        int pivoIndext=partition2(array,left,right);
        //比基准值小的[left,pivoIndext-1]
        //比基准值大的[pivoIndext+1,right]
        //3.分治算法
        //处理比基准值小的区间
        quickSortInner(array,left,pivoIndext-1);
        //处理比基准值大的区间
        quickSortInner(array,pivoIndext+1,right);
    }

//    private static int partition(int[] array, int left, int right) {
//        //前后下标
//
//    }

    private static int partition2(int[] array, int left, int right) {
        //挖坑
        int begin=left;
        int end=right;
        int pivot=array[right];
        while(begin<end){
            while (begin<end&&array[begin]<=pivot){
                begin++;
            }
            //停下了，就填坑
            array[end]=array[begin];
            while (begin<end&&array[end]>=pivot){
                end--;
            }
            array[begin]=array[end];
        }
        //循环结束，将基准值填入坑
       array[begin]=pivot;
        return begin;
    }

    private static int partition3(int[] array, int left, int right) {
        //Hover
        //时间复杂度O（n）
        int begin=left;
        int end =right;
        int pivot=array[right];
        while(begin<end){
            //array[begin]比基准值小，begin就前进
            while (begin<end&&array[begin]<=pivot){
                begin++;
            }
            //array[begin]>pivot

            //array[end]>piot,end就后退
            while(begin<end&&array[end]>=pivot){
                end--;
            }

            //此时都卡住了，说明begin遇到了比基准值大的，end遇到了比基准值小的，
            // 所以一交换，又可以继续走
            swap(array,begin,end);

        }

        //走完了begin==right
        swap(array,begin,right);
            return begin;
    }


    //30
    public static void main(String[] args) {
        int[] array=new int[]{1,0,2,7,5,3,7,2,9,5};

        quickSort(array);
        System.out.println(Arrays.toString(array));
        }
    }

