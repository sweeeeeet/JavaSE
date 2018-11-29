package datastruction;

/**
 * Author:sweet
 * Created:2018/11/27
 */
public interface ILink {
    boolean add(Object o);
    void clear();
    int size();

    int contains(Object a);

    boolean remove(Object data);

    Object set(int index, Object newData);

    Object get(int index);
    void print();

    Object[] toArray();

}
