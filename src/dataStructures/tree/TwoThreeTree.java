package dataStructures.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TwoThreeTree<K extends Comparable<K>> {
    public TwoThreeTreeNode<K> root;
    private int size;

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
//        System.out.println(String.format("-----%s-----", key.toString()));
        this.root = this.add(key, this.root);
//        this.printByLevel();
//        System.out.println();
    }

    public void remove(K key) {

    }

    public void printByLevel() {
        Deque<TwoThreeTreeNode<K>> queue = new ArrayDeque<>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                TwoThreeTreeNode<K> node = queue.poll();
                System.out.print(String.format("%s\t", node.toString()));
                if (node.left != null)
                    queue.offer(node.left);
                if (node.middle != null)
                    queue.offer(node.middle);
                if (node.right != null)
                    queue.offer(node.right);
                count--;
            }
            System.out.println();
        }
    }

    private boolean contains(K key, TwoThreeTreeNode<K> node) {
        if (node == null)
            return false;

        if (key.compareTo(node.key1) == 0)
            return true;
        if (key.compareTo(node.key1) < 0)
            return this.contains(key, node.left);

        if (!node.isThree || key.compareTo(node.key2) < 0)
            return this.contains(key, node.middle);

        if (key.compareTo(node.key2) == 0)
            return true;
        return this.contains(key, node.right);
    }

    private TwoThreeTreeNode<K> add(K key, TwoThreeTreeNode<K> node) {
        if (node == null)
            return new TwoThreeTreeNode<>(key);

        TwoThreeTreeNode<K> subTree;
        if (key.compareTo(node.key1) < 0) {
           subTree  = this.add(key, node.left);
           if (subTree != node.left) {
               node.left = null;
               return this.mergeLeft(node, subTree);
           }
           return node;
        } else if (key.compareTo(node.key1) == 0) {
            node.value1++;
            return node;
        } else if (!node.isThree || key.compareTo(node.key2) < 0) {
            subTree = this.add(key, node.middle);
            if (subTree != node.middle) {
                node.middle = null;
                return this.mergeMiddle(node, subTree);
            }
            return node;
        } else if (key.compareTo(node.key2) == 0) {
            node.value2++;
            return node;
        } else {
            subTree = this.add(key, node.right);
            if (subTree != node.right) {
                node.right = null;
                return this.mergeRight(node, subTree);
            }
            return node;
        }
    }

    private TwoThreeTreeNode<K> mergeLeft(TwoThreeTreeNode<K> node, TwoThreeTreeNode<K> subTree) {
        if (!node.isThree) {
            node.right = node.middle;
            node.key2 = node.key1;
            node.value2 = node.value1;
            node.middle = subTree.middle;
            node.key1 = subTree.key1;
            node.value1 = subTree.value1;
            node.left = subTree.left;
            node.isThree = true;
            return node;
        }

        TwoThreeTreeNode<K> newNode = new TwoThreeTreeNode<>(node.key1, node.value1);
        newNode.left = new TwoThreeTreeNode<>(subTree.key1, subTree.value1);
        newNode.left.left = subTree.left;
        newNode.left.middle = subTree.middle;
        newNode.middle = new TwoThreeTreeNode<>(node.key2, node.value2);
        newNode.middle.left = node.middle;
        newNode.middle.middle = node.right;
        return newNode;
    }

    private TwoThreeTreeNode<K> mergeMiddle(TwoThreeTreeNode<K> node, TwoThreeTreeNode<K> subTree) {
        if (!node.isThree) {
            node.right = subTree.middle;
            node.key2 = subTree.key1;
            node.value2 = subTree.value1;
            node.middle = subTree.left;
            node.isThree = true;
            return node;
        }

        TwoThreeTreeNode<K> newNode = new TwoThreeTreeNode<>(subTree.key1, subTree.value1);
        newNode.left = new TwoThreeTreeNode<>(node.key1, node.value1);
        newNode.left.left = node.left;
        newNode.left.middle = subTree.left;
        newNode.middle = new TwoThreeTreeNode<>(node.key2, node.value2);
        newNode.middle.left = subTree.middle;
        newNode.middle.middle = node.right;
        return newNode;
    }

    private TwoThreeTreeNode<K> mergeRight(TwoThreeTreeNode<K> node, TwoThreeTreeNode<K> subTree) {
        TwoThreeTreeNode<K> newNode = new TwoThreeTreeNode<>(node.key2, node.value2);
        newNode.left = new TwoThreeTreeNode<>(node.key1, node.value1);
        newNode.left.left = node.left;
        newNode.left.middle = node.middle;
        newNode.middle = new TwoThreeTreeNode<>(subTree.key1, subTree.value1);
        newNode.middle.left = subTree.left;
        newNode.middle.middle = subTree.middle;
        return newNode;
    }
}
