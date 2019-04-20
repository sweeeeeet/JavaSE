package www.sweet.stack;

/**
 * Author:sweet
 * Created:2019/4/14
 * 栈具有后进先出的特性，进行数据插入和删除的一端称为栈顶，另一端称为栈底
 * 栈的实现利用数组或链表实现
 */
public class MyStack implements IMyStack {
    private int top = 0;
    private int[] array = new int[100];


    @Override
    public boolean empty() {
        if (top == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int peek() {
        if (this.top != 0) {
            int val = array[this.top - 1];
            return val;
        }
        return 0;
    }

    @Override
    public int pop() {
        if (this.top != 0) {
            return array[--this.top];
        }
        return 0;
    }

    @Override
    public void push(int item) {
        array[this.top] = item;
        this.top++;
    }

    @Override
    public int size() {
        return this.top;
    }
}
