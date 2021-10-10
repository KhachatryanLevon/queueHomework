package com.company;

import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedList<T> implements CustomDoubleLinkedList<T> {

    public class Node<T> {

        T value;
        Node next;
        Node prev;

        public Node(T value) {
            this.value = value;
        }
    }

    Node first;
    Node last;
    private int size;

    @Override
    public T get(int index) {
        if (index < (size() / 2)) {
            if (first == null) {
                return null;
            }
            Node current = first;
            int count = 0;
            while (current != null) {
                if (count == index) {
                    return (T) current.value;
                }
                count++;
                current = current.next;
            }
        } else {
            Node current = last;
            int count = size() - 1;
            while (current != null) {
                if (count == index) {
                    return (T) current.value;
                }
                count--;
                current = current.prev;
            }
        }
        return null;
    }

    @Override
    public void add(T obj) {
        Node node = new Node(obj);
        if (first == null) {
            first = node;
            last = node;
            size++;
            return;
        }
        last.next = node;
        node.prev = last;
        last = node;
        size++;
    }

    @Override
    public void addFirst(T obj) {
        Node node = new Node(obj);
        if (first == null) {
            first = node;
            last = node;
            size++;
            return;
        }
        node.next = first;
        first.prev = node;
        first = node;
        size++;

    }

    @Override
    public void addLast(T obj) {
        add(obj);
    }

    @Override
    public void push(T obj) {
        addFirst(obj);
    }

    @Override
    public T pop() {
        T first = get(0);
        if (first != null) {
            remove(0);
            return first;
        } else throw new NoSuchElementException("Queue is empty");
    }

    @Override
    public void remove(int index) {
        if (first == null) {
            return;
        }
        Node current = first;
        if (index == 0) {
            first = current.next;
            first.prev = null;
            size--;
            return;
        }
        for (int i = 1; i <= index; i++)
            current = current.next;
        if (current == null) {
            return;
        }
        if (current.next == null) {
            last = current.prev;
            size--;
            return;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev.prev;
        size--;
    }

    @Override
    public T removeFirst() {
        T first = get(0);
        if (first != null) {
            remove(0);
            return first;
        } else throw new NoSuchElementException("Queue is empty");
    }

    @Override
    public T removeLast() {
        T lastV = get(size() - 1);
        if (lastV != null) {
            remove(size() - 1);
            return lastV;
        } else throw new NoSuchElementException("Queue is empty");
    }

    @Override
    public boolean offerFirst(T obj) {
        addFirst(obj);
        return true;
    }

    @Override
    public boolean offerLast(T obj) {
        addLast(obj);
        return true;
    }

    @Override
    public T poll() {
        T first = get(0);
        if (remove(first)) {
            return first;
        }
        return null;
    }

    @Override
    public T pollFirst() {
        T first = get(0);
        if (remove(first)) {
            return first;
        }
        return null;
    }

    @Override
    public T pollLast() {
        T last = get(size() - 1);
        if (remove(last)) {
            return last;
        }
        return null;
    }

    @Override
    public boolean remove(Object obj) {
        Node current2 = new Node(null);
        Node current = new Node(obj);
        current = first;
        current2 = first;
        if (first.value.equals(obj)) {
            first = first.next;
            first.prev = null;
            size--;
            return true;
        }
        for (int i = 0; i < size - 1; i++) {
            current = current2.next;
            if (current.value.equals(obj)) {
                if (i == (size - 2)) {
                    current.next = null;
                    last = current.prev;
                    size--;
                    return true;
                } else {
                    current.next.prev = current2;
                    current2.next = current.next;
                }
                size--;
                return true;
            }
            current2 = current2.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    /*
    Не получилось, скорее всего нерпавильно реализовал
    @Override
    public T descendingIterator() {
        return null;
    }

    @Override
    public T iterator() {
       return listIterator().next();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIterator<T>() {
             int current = 0;

            @Override
            public boolean hashNext() {
                return current < size();
            }

            @Override
            public T next() {
                if (hashNext()) {
                    for (int i = 0; i < size(); i++) {
                        T newElement = get(i);
                        current++;
                        return (T) newElement;
                    }
                }
                return null;
            }
        };
    }


     */

    @Override
    public boolean contains(Object obj) {
        Node current = first;
        while (current != null) {
            if (current.value == obj) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoublyLinkedList that = (DoublyLinkedList) o;
        return size == this.size() && Objects.equals(first, this.first) && Objects.equals(last, this.last);
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = first;
        for (int i = 0; i < size(); i++) {
            result.append(current.value);
            if (i < size() - 1) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }


}
