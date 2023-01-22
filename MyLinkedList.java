package dataStructure.listStructure;

import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E>{
    private Node<E> head, tail;
    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element) {
            this.element = element;
        }
    }
    /** Create a default list */
    public MyLinkedList() {
    }
    /** Create a list from an array of objects */
    public MyLinkedList(E[] objects) {
        super(objects);
    }

    /** Return the head element in the list */
    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }
    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size
        if (tail == null) // the new node is the only node in list
            tail = head;
    }
    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new for element e
        if (tail == null) {
            head = tail = newNode; // The new node is the only node in list
        } else {
            tail.next = newNode; // Link the new with the last node
            tail = tail.next; // tail now points to the last node
        }
        size++; // Increase size
    }

    /** Add a new element at the specified index in this list
     * The index of the head element is 0 */
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }
    }

    /** Remove the head node and
     * return the object that is contained in the removed
     * node. */
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    /** Remove the element at the specified position in this list.
     * Return the element that was removed from the list. */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    /** Return true if this list contains the element o */
    public boolean contains(E e) {
        Node<E> current = head;
        while(current != null) {
            if (current.element.equals(e))
                return true;
            current = current.next;
        }
        return false;
    }
//public boolean contains(E e) {
// Node<E> current = head;
// for (int i = 0; i < size; i++) {
// if (current.element.equals(e))
// return true;
// current = current.next;
// }
// return false;
//}

    /** Return the element from this list at the index */
    public E get(int index) {
        if(size <= index)
            return null;
        Node<E> current = head;
        for(int i=0; i<index; i++)
            current = current.next;
        return current.element;
    }
    /** Replace the element at the specified position in this list
     * with the specified element. */
    public E set(int index, E e) {
        if(index >= size)
            return null;
        Node<E> current = head;
        for(int i=0; i<index; i++)
            current = current.next;
        E old = current.element;
        current.element = e;
        return old;
    }

    /** Return the index of the head matching element in this list.
     * Return -1 if no match. */
    public int indexOf(E e) {
        Node<E> current = head;
        int i = 0;
        while(current != null) {
            if (current.element.equals(e))
                return i;
            i++;
            current = current.next;
        }
        return -1;
    }
    /** Return the index of the last matching element in this list
     * Return -1 if no match. */
    public int lastIndexOf(E e) {
        Node<E> current = head;
        int i = 0, lastIndex = -1;
        while(current != null) {
            if (current.element.equals(e))
                lastIndex = i;
            i++;
            current = current.next;
        }
        return lastIndex;
    }

    @Override /** Override toString() to return elements in the list */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }
        return result.toString();
    }
    /** Clear the list */
    public void clear() {
        head = tail = null;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<E> {
        Node<E> current = head;
        int index = 0;
        @Override
        public boolean hasNext() {
            return (current !=null);
        }
        @Override
        public E next() {
            Node<E> node = current;
            current = current.next;
            index++;
            return node.element;
        }
        @Override
        public void remove() {
            MyLinkedList.this.remove(index);
        } // to get this object from the outer class
    }
}
