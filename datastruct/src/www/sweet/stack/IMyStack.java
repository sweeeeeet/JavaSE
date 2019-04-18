package www.sweet.stack;

/**
 * Author:sweet
 * Created:2019/4/14
 */
public interface IMyStack {
    /** 
    * @Description: 判断栈是否为空 
    * @Param:  
    * @return:  
    */
    boolean empty();
    /** 
    * @Description: 返回栈顶元素但是不出栈 
    * @Param:  
    * @return:  
    */
    int peek();
    /** 
    * @Description: 栈顶元素出栈 
    * @Param:  
    * @return:  
    */
    int pop();
    /** 
    * @Description: 将item压入栈 
    * @Param:  
    * @return:  
    */
    void push(int item);
    /** 
    * @Description: 返回栈中元素个数 
    * @Param:  
    * @return:  
    */
    int size();
}
