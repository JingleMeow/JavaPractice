package dataStructures.StackAndQueue;

public interface Queue<E> {
    E offer(E item);
    E poll();
    E peek();
    boolean isEmpty();
    int size();
}
