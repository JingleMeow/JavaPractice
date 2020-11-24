package dataStructures.tree;

public class ValuedBinaryTreeNode<K> {
    public K key;
    public int value;
    public ValuedBinaryTreeNode<K> left;
    public ValuedBinaryTreeNode<K> right;

    public ValuedBinaryTreeNode(K key) {
        this.key = key;
        this.value = 1;
        this.left = null;
        this.right = null;
    }
}