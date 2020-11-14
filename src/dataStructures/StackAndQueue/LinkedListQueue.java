package dataStructures.stackAndQueue;

import dataStructures.ListNode;

public class LinkedListQueue<E> implements Queue<E> {

    private int size;
    private ListNode<E> head;
    private ListNode<E> tail;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public E offer(E item) {
        ListNode<E> node = new ListNode<>(item);
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
        return item;
    }

    @Override
    public E poll() {
        if (this.isEmpty())
            return null;
        ListNode<E> node = this.head;
        this.head = node.next;
        node.next = null;
        this.size--;
        if (this.size == 0)
            this.tail = null;
        return node.value;
    }

    @Override
    public E peek() {
        if (this.isEmpty())
            return null;
        return this.head.value;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }
}
