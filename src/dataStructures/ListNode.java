package dataStructures;

public class ListNode<E> {
    public E value;
    public ListNode<E> next;
    public ListNode(E value) {
        this.value = value;
        this.next = null;
    }
}
