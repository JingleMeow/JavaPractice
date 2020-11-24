package dataStructures.tree;

public class TwoThreeTreeNode<K> {
    public boolean isThree;
    public K key1;
    public int value1;
    public K key2;
    public int value2;
    public TwoThreeTreeNode<K> left;
    public TwoThreeTreeNode<K> middle;
    public TwoThreeTreeNode<K> right;

    public TwoThreeTreeNode(K key) {
        this.isThree = false;
        this.key1 = key;
        this.value1 = 1;
        this.key2 = null;
        this.value2 = 0;
        this.left = null;
        this.middle = null;
        this.right = null;
    }

    public TwoThreeTreeNode(K key, int value) {
        this(key);
        this.value1 = value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("(%s: %d", this.key1, this.value1));
        if (this.isThree) {
            sb.append(String.format(", %s: %d", this.key2, this.value2));
        }
        sb.append(")");
        return sb.toString();
    }
}
