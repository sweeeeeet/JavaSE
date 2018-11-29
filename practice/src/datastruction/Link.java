package datastruction;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Author:sweet
 * Created:2018/11/27
 */
public class Link implements ILink {


    private Node head;
    private Node tail;
    private int size;

    public Link() {
        this.head = null;
        this.size = 0;
        this.tail = null;
    }

    public Link(Object s) {
        Node node = new Node(s, null);
        this.head = node;
        this.tail=node;
        this.head.setNext(this.tail);
        size++;
    }


    @Override
    public boolean add(Object data) {
        Node node = new Node(data, null);
         this.tail.setNext(node);
         this.tail=node;
        size++;
        return true;
    }

    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int contains(Object a) {
        Node curr=head;
        int index=-1;
        while(curr!=null){
            index++;
            Object e=curr.getData();
            if(e.equals(a)){
                return index;
            }
            curr=curr.getNext();
        }
        return -1;
    }

    @Override
    public boolean remove(Object data) {

       Node pre=head;
        Node curr=head;
       while(curr!=null){
           if(curr.getData().equals(data)){
               pre.setNext(curr.getNext());
               size--;
               return true;
           }
           pre=curr;
           curr=curr.getNext();
       }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        if(index==-1){
            return null;
        }
        if(index>size-1){
            return null;
        }
        Node curr=head;
        int currIndex=-1;
        while(curr!=null){
            ++currIndex;
            if(currIndex==index){
                curr.setData(newData);
                return  newData;
            }
            curr=curr.getNext();
        }
        return null;
    }

    @Override
    public Object get(int index) {
        if(index==-1){
            return null;
        }
        if(index>size-1){
            return null;
        }
        Node curr=head;
        int currIndex=-1;
        while(curr!=null){
            ++currIndex;
            if(currIndex==index){
                return  curr.getData();
            }
            curr=curr.getNext();
        }


        return null;
    }

    @Override
    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.getData());
            curr = curr.getNext();
            if (curr != null) {
                System.out.print(" > ");
            }else{
                System.out.println();
            }
        }
    }

    @Override
    public Object[] toArray() {
        Object[] values=new Object[this.size];
        Node curr=head;
        int index=-1;
        while(curr!=null){
            index++;
            values[index]=curr.getData();
            curr=curr.getNext();
        }
        return values;


    }
}



