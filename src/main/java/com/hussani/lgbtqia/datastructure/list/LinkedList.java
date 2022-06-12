package com.hussani.lgbtqia.datastructure.list;

public class LinkedList<T> {
    private ListNode<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void add(T element) {
        ListNode<T> newNode = new ListNode<>(element);
        if (head == null) {
            head = newNode;
        } else {
            ListNode<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public boolean isEmpty() {
        return null == head;
    }

    public void print() {
        ListNode<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
