package www.sweet.arraylist;

/**
 * Author:sweet
 * Created:2019/4/3
 * 利用数组实现顺序表
 * use arrays to realize sequential table
 */
public class MyArrayList implements IArrayList {
    private int[] array;
    private int size;
    private int capacity;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        this.size = 0;
    }

    /**
     * @Description: 顺序链表中的前插法
     * @Param:
     * @return:
     */
    @Override
    public void pushFront(int item) {
        if (this.size < capacity) {
            for (int i = size; i > 0; i--) {
                this.array[i] = this.array[i - 1];
            }
            this.array[0] = item;
            this.size++;

        }
    }

    /**
     * @Description: 顺序链表的尾插法
     * @Param:
     * @return:
     */
    @Override
    public void pushBack(int item) {
        if (this.size < capacity) {
            array[this.size] = item;
            this.size++;
        }
    }

    /**
     * @Description: 顺序链表中，在指定下标中添加元素，需从后向前遍历
     * @Param:
     * @return:
     */
    @Override
    public void add(int item, int index) {
        if (this.size < this.capacity) {
            for (int i = this.size; i > index; i--) {
                this.array[i] = this.array[i - 1];
            }
            this.array[index] = item;
            this.size++;
        }
    }

    /**
     * @Description: 顺序链表的头删法，将后一个直接覆盖前一个
     * @Param:
     * @return:
     */
    @Override
    public void popFront() {
        if (this.size > 0) {
            for (int i = 1; i < this.size; i++) {
                this.array[i - 1] = this.array[i];
            }
            array[this.size - 1] = 0;
            this.size--;

        }

    }

    /**
     * @Description: 顺序链表的尾删
     * @Param:
     * @return:
     */
    @Override
    public void popBack() {
        if (this.size > 0) {
            array[this.size - 1] = 0;
            this.size--;
        }
    }

    /**
     * @Description: 顺序链表中，删除指定下标的元素，直接将后一个覆盖前一个，size-1
     * @Param:
     * @return:
     */
    @Override
    public void remove(int index) {
        //数据
        if (this.size > index) {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            array[this.size--] = 0;
        }

    }

    public static void main(String[] args) {
        MyArrayList my = new MyArrayList(12);
        my.pushFront(12);
        my.pushFront(90);
        my.pushFront(11);
        my.pushBack(23);
        my.pushBack(234);
        my.add(55, 1);
        my.pushFront(14);
        my.pushFront(1);
        my.remove(2);
        my.remove(1);
        my.pushBack(3);

    }
}
