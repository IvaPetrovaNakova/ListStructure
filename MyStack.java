package dataStructure.listStructure;

import java.util.Iterator;

public class MyStack <E> extends MyArrayList<E> implements Iterable<E>{

    private final MyLinkedList<E> list;

    public MyStack() {
        this.list = new MyLinkedList<>();
    }

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E peek() {
        return list.get(getSize() - 1);
    }

    public void push (E element) {
        list.addLast(element);
    }

    public E pop() {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

//    public int find(E element) {
//        return list.find(element);
//    }

    @Override
    public String toString() {
        return "stack: " + list.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return super.iterator();
    }
}
