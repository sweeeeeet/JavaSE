package www.sweet.interview;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Author:sweet
 * Created:2019/4/13
 */
public class StackAndQueue {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(12);
        myQueue.push(11);
        myQueue.push(10);
        System.out.println(myQueue.pop());
        ;
        System.out.println(myQueue.peek());
        ;
        System.out.println(myQueue.empty());
        ;
    }

    /**
     * @Description: 括号匹配
     * solution：利用栈的先进后出特性，遍历每个字符，将左括号压入栈，
     * 遍历到右括号时，与栈顶元素匹配
     * {1.如果栈为空，不匹配
     * 2.若果右括号与栈顶元素不相等 不匹配
     * 3.遍历完栈不为空，左括号多了}
     * @return:
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                case ']':
                case '}': {
                    if (stack.empty()) {
                        return false;
                    } else {
                        char left = stack.pop();
                        if (!(left == '(' && ch == ')' || left == '[' && ch == ']'
                                || left == '{' && ch == '}')) {
                            return false;
                        }
                        break;
                    }
                }
                default:
                    break;
            }
        }


        //字符串遍历结束，如果栈中还有元素 说明也不匹配
        if (!stack.empty()) {
            return false;
        }

        return true;

    }

    /**
     * @Description: 用队列（一头进一头出（先进先出）ABC-->ABC）
     * 实现栈（同一头进出（先进后出）ABC-->CBA）：
     * solution：private LinkedList www.sweet.queue;
     * @return:
     */
    class MyStack {

        private LinkedList<Integer> stack;

        /*
         * Initialize your data structure here.
         */
        public MyStack() {
            this.stack = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
//前插进队列就是栈的实现
            stack.addLast(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
//出栈:后进先出《----》队列中的最后一个元素
            int size = this.stack.size();
            for (int i = 0; i < size - 1; i++) {
                int x = this.stack.get(0);
                this.stack.remove(0);
                this.stack.addLast(x);
            }
            int v = this.stack.get(0);
            this.stack.remove(0);
            return v;
        }

        /**
         * Get the top element.
         */
        public int top() {
            //栈顶元素就是后入队列的元素
            int size = this.stack.size();
            for (int i = 0; i < size - 1; i++) {
                int x = this.stack.get(0);
                this.stack.remove(0);
                this.stack.addLast(x);
            }
            int v = this.stack.get(0);
            this.stack.remove(0);
            this.stack.addLast(v);
            return v;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            if (stack.size() == 0) {
                return true;
            }
            return false;
        }
    }
}


/**
 * @Description: 用两个栈实现一个队列
 * solution：（类似于汉诺塔）出队列：入其中一个栈，
 * 然后遍历，导入另一个栈，此时的元素顺序就是进栈的顺序了
 * 若要继续push元素，在第一个栈中添加元素，如果第二个栈还有元素则出，
 * 如果没有了就再次将第一个栈元素导入第二个元素
 */

class MyQueue {
    /**
     * Initialize your data structure here.
     */
    private Stack<Integer> stackIn = new Stack();
    private Stack<Integer> stackOut = new Stack();

    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        //利用两个栈，两次入栈操作就还原了入栈时本身的时间顺序
        //如果OUt栈为空了就入新的元素进来
        pushEle();

        return stackOut.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {

        pushEle();

        return stackOut.peek();

    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if (stackOut.empty()) {
            if (stackIn.empty()) {
                return true;
            }
        }
        return false;
    }

    private void pushEle() {
        if (stackOut.empty()) {
            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}

/**
 * @Description: 最小栈：设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * @Param: solution：利用两个栈：一个栈正常存入数据 另一个栈压入最小的元素（空间换时间）
 * @return:
 */
class MinStack {

    Stack<Integer> stackPush;
    Stack<Integer> stackMin;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.stackMin = new Stack<>();
        this.stackPush = new Stack<>();
    }

    public void push(int x) {
        stackPush.push(x);
        //如果当前元素是最小的就进栈，否则就最小元素进栈
        // （保证进栈的元素都是当前最小的元素）
        if (stackMin.empty() || stackMin.peek() >= x) {
            stackMin.push(x);
        } else {
            stackMin.push(this.stackMin.peek());
        }
    }

    public void pop() {
        if (!stackPush.empty()) {
            stackMin.pop();
            stackPush.pop();

        }
    }

    public int top() {
        if (!stackPush.empty()) {
            return stackPush.peek();
        }
        return 0;
    }

    public int getMin() {


        if (stackMin.empty()) {
            return 0;
        }
        return stackMin.peek();
    }
}

/**
 * @Description: 设计你的循环队列实现。 循环队列是一种线性数据结构，
 * 其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * <p>
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。
 * 在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。
 * 但是使用循环队列，我们能使用这些空间去存储新的值。
 * @Param: private int[] array;
 * private int size;
 * private int rear;、、下一个可用位置下标
 * private int front;队首元素下标
 * rear front;
 * 实现循环：rear=(rear+1)%length
 * int index=(rear+length-1)%length
 * array[index]
 * 判断队列为空/满：size为0则空 size不为0&&front==rear
 * front-rear=1时就强行判定为满
 * @return:
 */

class MyCircularQueue {
    private int size;
    private int rear;
    private int front;
    private int[] array;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.size = 0;
        this.front = 0;
        this.rear = 0;
        array = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (this.size == this.array.length) {
            return false;
        }
        this.array[this.rear] = value;
        this.rear = (this.rear + 1) % this.array.length;
        this.size++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (this.size == 0) {
            return false;
        }
        this.front = (this.front + 1) % this.array.length;
        this.size--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (this.size == 0) {
            return -1;
        }
        return this.array[this.front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (this.size == 0) {
            return -1;
        }
        int index = (this.rear - 1 + this.array.length) % this.array.length;
        return this.array[index];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return this.size == this.array.length;
    }
}


