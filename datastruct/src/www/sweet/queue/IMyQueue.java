package www.sweet.queue;

/**
 * Author:sweet
 * Created:2019/4/14
 */
public interface IMyQueue {
    boolean empty();
    int peek();
    int poll();
    void add(int item);
    int size();
}
