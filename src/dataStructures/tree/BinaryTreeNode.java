package dataStructures.tree;

public class BinaryTreeNode<E> {
    public E key;
    public BinaryTreeNode<E> left;
    public BinaryTreeNode<E> right;

    public BinaryTreeNode(E key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}
