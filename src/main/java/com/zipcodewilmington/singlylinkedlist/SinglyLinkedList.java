package com.zipcodewilmington.singlylinkedlist;


/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<E extends Comparable> {

    class Node {

        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Integer count;
    Node start;

    public SinglyLinkedList() {
        count = 0;
    }

    public void add(E element) {

        if(start == null) {

            start = new Node(element, null);
        }

        else {

            Node node = start;

            while(node.next != null) {
                node = node.next;
            }

            node.next = new Node(element, null);

        }

        count += 1;
    }

    public void remove(int index) {
        Node node = start;
        Node previous = start;

        if(index < count && index >= 0) {
            for (int i = 0; i <= index; i++) {

                if(i == index && i == 0) {
                    start = node.next;
                }

                else if (i == index) {
                    previous.next = node.next;
                }

                else {
                    previous = node;
                    node = node.next;
                }
            }

            count--;
        }
    }

    public Boolean contains(E element) {
        Node node = start;

        for(int i = 0; i < count; i++) {
            if(node.value.equals(element)) return true;
            node = node.next;
        }
        return false;
    }

    public Integer find(E element) {
        Node node = start;
        Integer counter = 0;

        for(int i = 0; i < count; i++) {
            if(node.value.equals(element)) return counter;
            node = node.next;
            counter++;
        }
        return -1;
    }

    public Integer size() {
        return count;
    }

    public E get(int index) {
        Node node = start;

        if(index < count) {
            for (int i = 0; i <= index; i++) {
                if (i == index) return node.value;
                node = node.next;
            }
        }
        return null;
    }

    public SinglyLinkedList<E> copy() {
        SinglyLinkedList<E> copy = new SinglyLinkedList<E>();
        for(int i = 0; i < count; i++) {
            copy.add(get(i));
        }
        return copy;
    }

    public void sort() {

        Boolean sorted = false;

        while(!sorted) {

            Node node = start;
            Node previous = null;
            sorted = true;

            for (int i = 0; i < count - 1; i++) {

                Node next = node.next;
                int compare = node.value.compareTo(next.value);

                if(compare > 0) {
                    node.next = next.next;
                    next.next = node;
                    if(previous != null) {
                        previous.next = next;
                    }
                    if(i == 0) start = next;
                    node = next;
                    sorted = false;
                }

                previous = node;
                node = node.next;

            }

        }
    }

    public void reverse() {
        Node node = start;
        Node previous = start;


        for(int i = 0; i < count; i++) {

            Node next = node.next;

            if(!previous.equals(node)) node.next = previous;
            if(i == 0) node.next = null;
            if(i == count - 1) {
                start = node;
            }
            else {
                previous = node;
                node = next;
            }
        }
    }

    public SinglyLinkedList<E> slice(int inclusive, int exclusive) {
        SinglyLinkedList<E> copy = new SinglyLinkedList<E>();
        if(inclusive < count && inclusive >= 0 && exclusive > inclusive && exclusive <= count) {
            for (int i = inclusive; i < exclusive; i++) {
                copy.add(get(i));
            }
        }
        return copy;
    }
}
