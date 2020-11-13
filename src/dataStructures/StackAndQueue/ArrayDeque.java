package dataStructures.StackAndQueue;

public class ArrayDeque<E> implements Deque<E> {
    private E[] array;
    private int head;
    private int tail;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    private static final float FACTOR = 1.5f;

    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        this.array = (E[])(new Object[DEFAULT_CAPACITY]);
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    @Override
    public E offerFirst(E item) {
        if (this.size == this.capacity)
            this.expand();
        this.head = this.prevIndex(this.head);
        this.array[this.head] = item;
        this.size++;
        return item;
    }

    @Override
    public E offerLast(E item) {
        if (this.size == this.capacity)
            this.expand();
        this.array[this.tail] = item;
        this.tail = this.nextIndex(this.tail);
        this.size++;
        return item;
    }

    @Override
    public E pollFirst() {
        if (this.isEmpty())
            return null;
        E item = this.array[this.head++];
        this.size--;
        return item;
    }

    @Override
    public E pollLast() {
        if (this.isEmpty())
            return null;
        E item =  this.array[--this.tail];
        this.size--;
        return item;
    }

    @Override
    public E peekFirst() {
        if (this.isEmpty())
            return null;
        return this.array[this.head];
    }

    @Override
    public E peekLast() {
        if (this.isEmpty())
            return null;
        return this.array[this.tail];
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void expand() {
        int newCapacity = (int)(this.capacity * FACTOR);
        @SuppressWarnings("unchecked")
        E[] newArray = (E[])(new Object[newCapacity]);
        for (int i = 0, index = this.head; i < this.size; i++) {
            newArray[i] = this.array[index];
            index = this.nextIndex(index);
        }
        this.array = newArray;
        this.head = 0;
        this.tail = this.size;
        this.capacity = newCapacity;
    }

    private int nextIndex(int index) {
        index++;
        if (index == this.capacity)
            index = 0;
        return index;
    }

    private int prevIndex(int index) {
        if (index == 0)
            index = this.size;
        return --index;
    }
}
