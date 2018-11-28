package datastruction;

/**
 * Author:sweet
 * Created:2018/11/27
 */
public class Link implements ILink {


    private Node head;
    private Node tail;
    private int size;

    public Link(Object s) {
        Node node=new Node(s,null);
    }


    @Override
    public boolean add(Object data) {

        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int contains(Object a) {
        return 0;
    }

    @Override
    public boolean remove(Object data) {
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public void print() {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}



