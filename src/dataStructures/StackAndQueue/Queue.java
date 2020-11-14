package dataStructures.stackAndQueue;

public interface Queue<E> {
    E offer(E item);
    E poll();
    E peek();
    boolean isEmpty();
    int size();
}
