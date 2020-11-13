package dataStructures.StackAndQueue;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
    private E[] array;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    private static final float FACTOR = 1.5f;

    public ArrayStack() {
        //noinspection unchecked
        this.array = (E[])(new Object[DEFAULT_CAPACITY]);
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    @Override
    public E push(E item) {
        if (this.size == this.capacity) {
            int newCapacity = (int)(this.capacity * FACTOR);
            this.array = Arrays.copyOf(this.array, newCapacity);
            this.capacity = newCapacity;
        }
        this.array[size++] = item;
        return item;
    }

    @Override
    public E pop() {
        if (this.isEmpty())
            return null;
        return this.array[--size];
    }

    @Override
    public E peek() {
        if (this.isEmpty())
            return null;
        return this.array[size - 1];
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
