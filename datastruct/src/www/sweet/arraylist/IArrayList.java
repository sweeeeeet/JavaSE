package www.sweet.arraylist;

/**
 * Author:sweet
 * Created:2019/3/30
 */
public interface IArrayList {

    //增
    void pushFront(int item);
    void pushBack(int item);
    void add(int item,int index);
    //删

    void popFront();
    void popBack();

    void remove(int index);
}
