package dataStructures.stackAndQueue;

public interface Deque<E> {
    E offerFirst(E item);
    E offerLast(E item);
    E pollFirst();
    E pollLast();
    E peekFirst();
    E peekLast();
    boolean isEmpty();
    int size();
}
