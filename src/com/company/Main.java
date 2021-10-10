package com.company;

public class Main {

    public static void main(String[] args) {

        Integer q = 1;
        Integer w = 2;
        Integer d = 3;
        Integer c = 4;

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        /*
        doublyLinkedList.add(q);
        doublyLinkedList.addFirst(w);
        doublyLinkedList.addLast(c);
        System.out.println(doublyLinkedList.toString());
        doublyLinkedList.add(d);
        doublyLinkedList.addFirst(c);
        System.out.println(doublyLinkedList.toString());
        doublyLinkedList.push(d);
        System.out.println(doublyLinkedList.toString());

        System.out.println(doublyLinkedList.removeFirst());

        System.out.println(doublyLinkedList.removeLast());
        System.out.println(doublyLinkedList.toString());
        System.out.println(doublyLinkedList.size());

        doublyLinkedList.pop();
        System.out.println(doublyLinkedList.toString());
        System.out.println(doublyLinkedList.poll());
        System.out.println(doublyLinkedList.toString());
        doublyLinkedList.add(c);
        System.out.println(doublyLinkedList.size());
        System.out.println(doublyLinkedList.toString());
         */

        doublyLinkedList.add(c);
        doublyLinkedList.add(d);
        doublyLinkedList.add(w);
        doublyLinkedList.add(q);
        doublyLinkedList.addLast(w);
        System.out.println(doublyLinkedList.toString());
        doublyLinkedList.pollFirst();
        System.out.println(doublyLinkedList.toString());
        doublyLinkedList.pollLast();
        doublyLinkedList.addLast(q);
        System.out.println(doublyLinkedList.toString());
        doublyLinkedList.removeLast();
        System.out.println(doublyLinkedList.toString());
        doublyLinkedList.add(d);
        System.out.println(doublyLinkedList.toString());

        // Не получилось
        //System.out.println(doublyLinkedList.iterator());


    }
}
