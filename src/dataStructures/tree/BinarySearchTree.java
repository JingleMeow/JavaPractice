package dataStructures.tree;

public class BinarySearchTree<K extends Comparable<K>> {
    public ValuedBinaryTreeNode<K> root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(K key) {
        return this.contains(key, this.root);
    }

    public void add(K key) {
        this.root = this.add(key, this.root);
    }

    public void remove(K key) {
        this.root = this.remove(key, this.root);
    }

    public void preOrderTraverse() {
        this.visitNodePreOrder(this.root);
    }

    private boolean contains(K key, ValuedBinaryTreeNode<K> node) {
        if (node == null)
            return false;
        if (key.compareTo(node.key) == 0)
            return true;
        else if (key.compareTo(node.key) < 0)
            return this.contains(key, node.left);
        else
            return this.contains(key, node.right);
    }

    private ValuedBinaryTreeNode<K> add(K key, ValuedBinaryTreeNode<K> node) {
        if (node == null) {
            this.size++;
            return new ValuedBinaryTreeNode<>(key);
        }
        else {
            if (key.compareTo(node.key) == 0 )
                node.value ++;
            else if (key.compareTo(node.key) < 0)
                node.left = this.add(key, node.left);
            else
                node.right = this.add(key, node.right);
            return node;
        }
    }

    private ValuedBinaryTreeNode<K> remove(K key, ValuedBinaryTreeNode<K> node) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) < 0) {
            node.left = this.remove(key, node.left);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = this.remove(key, node.right);
            return node;
        }

        if (node.left == null) {
            ValuedBinaryTreeNode<K> ret = node.right;
            node.right = null;
            this.size--;
            return ret;
        }

        if (node.right == null) {
            ValuedBinaryTreeNode<K> ret = node.left;
            node.left = null;
            this.size--;
            return ret;
        }

        ValuedBinaryTreeNode<K> newRoot = this.findMin(node.right);
        newRoot.right = this.removeMin(node.right);
        newRoot.left = node.left;
        node.left = null;
        node.right = null;
        return newRoot;
    }

    private ValuedBinaryTreeNode<K> findMin(ValuedBinaryTreeNode<K> node) {
        if (node.left == null)
            return node;
        return this.findMin(node.left);
    }

    private ValuedBinaryTreeNode<K> removeMin(ValuedBinaryTreeNode<K> node) {
        if (node.left != null) {
            node.left = this.removeMin(node.left);
            return node;
        }

        ValuedBinaryTreeNode<K> ret = node.right;
        node.right = null;
        this.size--;
        return ret;
    }

    private void visitNodePreOrder(ValuedBinaryTreeNode<K> node) {
        if (node == null)
            return;
        this.visitNodePreOrder(node.left);
        //this.printNode(node);
        this.visitNodePreOrder(node.right);
    }

    private void printNode(ValuedBinaryTreeNode<K> node) {
        String output = String.format("%s: %d", node.key.toString(), node.value);
        System.out.println(output);
    }

}
