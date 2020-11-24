package dataStructures.tree;

public class AVLNode<K> extends ValuedBinaryTreeNode<K> {
    public int height;
    public AVLNode<K> left;
    public AVLNode<K> right;

    public AVLNode(K key)  {
        super(key);
        height = 1;
        this.left = null;
        this.right = null;
    }

    public int leftHeight() {
        return this.left == null ? 0 : this.left.height;
    }

    public int rightHeight() {
        return this.right == null ? 0 : this.right.height;
    }

    public void updateHeight() {
        this.height = Math.max(this.leftHeight(), this.rightHeight()) + 1;
    }

    public int balanceFactor() {
        return this.leftHeight() - rightHeight();
    }

    public boolean isBalanced() {
        return Math.abs(this.balanceFactor()) < 2;
    }
}
