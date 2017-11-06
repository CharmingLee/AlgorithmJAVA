package com.ming.test.RBTree;

/**
 * 红黑树
 * Created by charminglee on 17-11-6.
 */
public class RedBlackBST<K extends Comparable<K>, V> {
    private RBNode<K, V> root;
    private int count;

    public void put(K key, V val){
        this.root = put(this.root, key, val);
        this.root.color = RBNode.BLACK;
    }

    public int getCount() {
        return count;
    }

    private RBNode<K, V> put(RBNode<K, V> node, K key, V val){
        if (node == null){
            this.count++;
            return new RBNode<>(key, val, RBNode.RED, 1);
        }

        int compare = node.key.compareTo(key);
        if (compare < 0){
            node.right = put(node.right, key, val);
        } else if (compare > 0){
            node.left = put(node.left, key, val);
        } else {
            node.val = val;
        }

        if (isRed(node.right) && !isRed(node.left)){
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)){
            node = rotateRight(node);
        }
        if (isRed(node.right) && isRed(node.left)){
            flipColors(node);
        }

        node.count = size(node.left) + size(node.right);

        return node;
    }

    private RBNode<K, V> rotateLeft(RBNode<K, V> node){
        RBNode<K, V> x = node.right;
        node.right = x.left;
        x.left = node;
        node.color = RBNode.RED;
        x.color = node.color;
        x.count = node.count;
        node.count = size(node.left) + size(node.right);

        return x;
    }

    private int size(RBNode<K, V> node){
        if (node == null)
            return 0;

        return node.count;
    }

    private boolean isRed(RBNode<K, V> node){
        if (node == null)
            return false;

        return node.color;
    }

    private RBNode<K, V> rotateRight(RBNode<K, V> node){
        RBNode<K, V> x = node.left;
        node.left = x.right;
        x.right = node;
        node.color = RBNode.RED;
        x.color = node.color;
        x.count = node.count;
        node.count = size(node.left) + size(node.right);

        return x;
    }

    private void flipColors(RBNode<K, V> node){
        node.color = RBNode.RED;
        node.left.color = RBNode.BLACK;
        node.right.color = RBNode.BLACK;
    }

}
