package dataStructures.tree;

public class AVLTree<K extends Comparable<K>> {
    public AVLNode<K> root;
    private int size;

    public AVLTree() {
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
        this.remove(key, this.root);
    }

    public void preOrderTraverse() {
        this.visitNodePreOrder(this.root);
    }

    private boolean contains(K key, AVLNode<K> node) {
        if (node == null)
            return false;

        if (key.compareTo(node.key) == 0)
            return true;

        if (key.compareTo(node.key) < 0)
            return this.contains(key, node.left);
        else
            return this.contains(key, node.right);
    }

    private AVLNode<K> add(K key, AVLNode<K> node) {
        if (node == null) {
            this.size++;
            return new AVLNode<>(key);
        }

        if (key.compareTo(node.key) == 0) {
            node.value++;
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = this.add(key, node.left);
        } else {
            node.right = this.add(key, node.right);
        }

        return this.adjust(node);
    }

    private AVLNode<K> remove(K key, AVLNode<K> node) {
        if (node == null)
            return null;

        AVLNode<K> ret;

        if (key.compareTo(node.key) < 0) {
            node.left = this.remove(key, node.left);
            ret = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = this.remove(key, node.right);
            ret = node;
        } else {
            if (node.left == null) {
                ret = node.right;
                node.right = null;
                return ret;
            }
            if (node.right == null) {
                ret = node.left;
                node.left = null;
                return ret;
            }
            ret = this.findMin(node.right);
            ret.right = this.removeMin(node.right);
            ret.left = node.left;
            node.left = null;
            node.right = null;

        }
        return this.adjust(ret);
    }

    private AVLNode<K> adjust(AVLNode<K> node) {
        if (node == null)
            return null;

        if (node.isBalanced()) {
            node.updateHeight();
            return node;
        }

        if (node.balanceFactor() > 1) {
            if (node.left.balanceFactor() < 0)
                node.left = this.rotateLeft(node.left);
            return this.rotateRight(node);
        } else{
            if (node.right.balanceFactor() > 0)
                node.right = this.rotateRight(node.right);
            return this.rotateLeft(node);
        }
    }

    private AVLNode<K> rotateRight(AVLNode<K> node) {
        AVLNode<K> newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node.updateHeight();
        newRoot.updateHeight();
        return newRoot;
    }

    private AVLNode<K> rotateLeft(AVLNode<K> node) {
        AVLNode<K> newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        node.updateHeight();
        newRoot.updateHeight();
        return newRoot;
    }

    private AVLNode<K> findMin(AVLNode<K> node) {
        if (node == null)
            return null;

        if (node.left == null)
            return node;
        return findMin(node.left);
    }

    private AVLNode<K> removeMin(AVLNode<K> node) {
        if (node.left == null) {
            AVLNode<K> ret = node.right;
            node.right = null;
            this.size--;
            return ret;
        }

        node.left = removeMin(node.left);
        node.updateHeight();
        return node;
    }

    private void visitNodePreOrder(AVLNode<K> node) {
        if (node == null)
            return;
        this.visitNodePreOrder(node.left);
        this.printNode(node);
        this.visitNodePreOrder(node.right);
    }

    private void printNode(AVLNode<K> node) {
        String output = String.format("%s: %d", node.key.toString(), node.value);
        System.out.println(output);
    }
}
