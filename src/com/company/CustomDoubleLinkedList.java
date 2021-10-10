package com.company;

public interface CustomDoubleLinkedList<T> {

    T get(int index);

    void add(T obj);

    void addFirst(T obj);

    void addLast(T obj);

    void push(T obj);

    T pop();

    void remove(int index);

    boolean remove(T obj);

    T removeFirst();

    T removeLast();

    boolean offerFirst(T obj);

    boolean offerLast(T obj);

    T poll();

    T pollFirst();

    T pollLast();

    int size();

    boolean contains(Object obj);

    /*
    ListIterator<T> listIterator();

    boolean contains(T obj);

    T descendingIterator();

    T iterator();
    interface ListIterator<T>{
        boolean hashNext();
        T next();
    }

     */

}
