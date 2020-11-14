package dataStructures.stackAndQueue;

public class ArrayQueue<E> implements Queue<E> {
    private E[] array;
    private int head;
    private int tail;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    private static final float FACTOR = 1.5f;

    public ArrayQueue() {
        //noinspection unchecked
        this.array = (E[])(new Object[DEFAULT_CAPACITY]);
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    @Override
    public E offer(E item) {
        if (this.size == this.capacity) {
            int newCapacity = (int)(this.capacity * FACTOR);
            @SuppressWarnings("unchecked")
            E[] newArray = (E[])(new Object[newCapacity]);
            for (int i = 0; i < this.size; i++) {
                newArray[i] = this.array[head];
                this.head = this.nextIndex(head);
            }
            this.array = newArray;
            this.head = 0;
            this.tail = this.size;
            this.capacity = newCapacity;
        }
        this.array[tail] = item;
        this.tail = this.nextIndex(this.tail);
        this.size++;
        return item;
    }

    @Override
    public E poll() {
        if (this.isEmpty())
            return null;
        E item = this.array[this.head];
        this.head = this.nextIndex(this.head);
        this.size--;
        return item;
    }

    @Override
    public E peek() {
        if (this.isEmpty())
            return null;
        return this.array[this.head];
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int nextIndex(int index) {
        index++;
        if (index == this.capacity)
            index = 0;
        return index;
    }
}
