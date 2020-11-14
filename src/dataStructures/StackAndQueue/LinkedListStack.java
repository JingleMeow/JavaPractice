package dataStructures.stackAndQueue;

import dataStructures.ListNode;

public class LinkedListStack<E> implements Stack<E> {
    private ListNode<E> top;
    private int size;

    public LinkedListStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public E push(E item) {
        ListNode<E> newNode = new ListNode<>(item);
        newNode.next = this.top;
        this.top = newNode;
        this.size++;
        return item;
    }

    @Override
    public E pop() {
        if (this.isEmpty())
            return null;
        ListNode<E> node = this.top;
        this.top = node.next;
        node.next = null;
        this.size--;
        return node.value;
    }

    @Override
    public E peek() {
        if (this.isEmpty())
            return null;
        ListNode<E> node = this.top;
        return node.value;
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
