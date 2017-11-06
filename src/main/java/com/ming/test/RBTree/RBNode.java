package com.ming.test.RBTree;

/**
 * Created by charminglee on 17-11-6.
 */
public class RBNode<K extends Comparable<K>, V> {
    static final boolean RED = true;
    static final boolean BLACK = false;
    K key;
    V val;
    RBNode left, right;
    int count;
    boolean color;

    public RBNode(K key, V val, boolean color, int count) {
        this.key = key;
        this.val = val;
        this.color = color;
        this.count = count;
    }

}
