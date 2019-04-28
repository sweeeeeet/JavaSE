package www.sweet.heap;

/**
 * Author:sweet
 * Created:2019/4/26
 */
public class SmallHeap {

    private void adjustHeap(int[] tree, int index) {
        int min = index + 1;
        //找左孩子
        while (min < tree.length) {
            //找右孩子，取最小的
            if (min + 1 < tree.length && tree[min + 1] < tree[min]) {
                min = min + 1;
            }

            //与根比较
            if (tree[index] < tree[min]) {
                return;
            }
            int t = tree[min];
            tree[min] = tree[index];
            tree[index] = t;

            index = min;
            min = 2 * index + 1;


        }
    }
}
