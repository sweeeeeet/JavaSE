package www.sweet.heap;

/**
 * Author:sweet
 * Created:2019/4/26
 */
public class BigHeap {
    /**
    * @Description: 向下调整（堆化）
     * 必须满足可以向下调整的前提：只有一个位置不满足堆
    * @Param:  看成完全二叉树 存放在数组中，对下标进行操作
     * index:要调整位置的下标
    * @return:
    */
    //时间复杂度O（logn）
    private static void heapify(int[] tree,int index){
       //找到左右孩子
        int left=2*index+1;
        if(left>=tree.length) {
        return;
        }
        //不是叶子节点，意味着一定有左孩子，不一定有右孩子
        //2.找最大的节点{
        // 1.没有右孩子  left
        // 2. 有右孩子
        //      左边大  left
        //       右边大  right}
        int right=2*index+2;
        int max=left;
        if(right<tree.length&&tree[right]>tree[left]){
            max=right;
        }

        /*
        * 3.直接与根比较
        * 如果根的值大，满足堆的特征 不需要再调整了
        * 否则 交换数组中的两个值 并且以max作为下标，向下调整
        *
        * */
        if(tree[index]>=index){
            return;
        }

        int t=tree[index];
        tree[index]=tree[max];
        tree[max]=t;
        //继续向下调整
        heapify(tree,max);

        }

//    void heapify(int[] tree,int index){
//        //1.找左右孩子
//        int left=2*index+1;
//        if(left>=tree.length){
//            return;
//        }
//        int right=index*2+2;
//        int max=left;
//        //2.比较左右孩子 选大的
//        if(right<tree.length&&tree[right]>tree[left]){
//            max=right;
//        }
//        //将较大的与根比较
//        if(tree[index]>=tree[max]){
//            //如果根节点大于最大的孩子节点 就不用交换了
//            return;
//        }
//
//        int temp=tree[index];
//        tree[index]=tree[max];
//        tree[max]=temp;
//        heapify(tree,max);
//    }

    //时间复杂度O(n)
    //粗略nO(logn)
    public static void createHeap(int[] array){
        //从最后一共非叶子节点的下标开始，一路向下调整至根位置
        for(int i=(array.length-1-1)/2;i>=0;i--){
            heapify(array,i);
        }
    }

    /**
     * @Description: 数组中找最大值
     * 堆   vs    数组
     * 适合多次
    */
    }


