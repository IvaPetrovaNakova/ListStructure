package dataStructure.listStructure;

public class MyQueue<E> extends MyLinkedList<E> {

    private final MyLinkedList<E> list;

    public MyQueue() {
        this.list = new MyLinkedList();
    }

    public void enqueue(E element) {
        list.addLast(element);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "Queue: " + list.toString();
    }
}
