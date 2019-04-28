package www.sweet.heap;

import java.util.Arrays;

/**
 * Author:sweet
 * Created:2019/4/26
 */
public class CreateHeap {
    private int[] array;
    private int size;

    public CreateHeap(int[] array, int size) {
        this.array = new int[100];
        for (int i = 0; i < size; i++) {
            this.array[i] = array[i];
        }
        this.size = size;
        getHeap(this.array, size);
    }

    private void getHeap(int[] array, int size) {
        //大堆,从非叶子节点开始建
        for(int i=(size-2)/2;i>=0;i--){
            heaplify2(array,i);
        }

    }

    private void heaplify(int[] array, int nowParent) {
        int max = nowParent * 2 + 1;
        if (max > size) {
            return;
        }
        if (max + 1 < size && array[max + 1] > array[max]) {
            max++;
        }
        //与根比较
        if (array[nowParent] > array[max]) {
            return;
        }

        //叶子比根大，调整
        int t = array[max];
        array[max] = array[nowParent];
        array[nowParent] = t;
        //继续向下调整
        heaplify(array, max);
    }
private static void heaplify2(int[] array,int index){

    while (index<array.length) {
        int max=index*2+1;
        if(max>array.length){
            break;
        }
        int right=index*2+2;
        if(right>array.length){
            break;
        }
        if(array[right]>array[max]){
            max=right;
        }


        if(array[max]<array[index]){
            break;
        }

        //做交换
        int t=array[index];
        array[index]=array[max];
        array[max]=t;

        index=max;

    }

}


    private int top() {
        return this.array[0];
    }

    private int pop() {
        int v = array[0];
        //将最后一个节点放到根节点上，再做堆的重建
        array[0] = array[this.size - 1];
        size--;
        getHeap(array, size);
        return v;
    }

    public static void adjustUP(int[] tree, int size, int index) {
        //建大堆
        //向上和双亲比较
        int parent = (index - 1) / 2;
        if (parent == 0) {
            return;
        }
        if (tree[index] <= tree[parent]) {
            return;
        }
        //向上调整，与双亲节点做交换
        int t = tree[index];
        tree[index] = tree[parent];
        tree[parent] = tree[index];
        //终止条件：
        adjustUP(tree, size, parent);
    }

    public static void adjustUP2(int[] tree, int size, int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (tree[index] <= tree[parent]) {
                return;
            }
            int t = tree[index];
            tree[index] = tree[parent];
            tree[parent] = t;
            index = parent;
        }
    }


    void bubble(int[] array) {

    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 2, 8, 5, 3, 7, 2, 9, 5};
        CreateHeap test = new CreateHeap(array, array.length);
        System.out.println(test.top());
        System.out.println(test.size);
        System.out.println(test.pop());
        System.out.println(test.size);
        ;
    }

}
