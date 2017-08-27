package com.ming.test.AVLTree;

/**
 * Created by charminglee on 17-7-28.
 *  AVL树
 */
public class AVLTree <T extends Comparable<? super T>>{

    private AVLNode <T> root;

    public static class AVLNode <T>{

        public AVLNode(T data){
            this.data = data;
        }

        public T data;
        public AVLNode<T> leftNode;
        public AVLNode<T> rightNode;
        public int height;
    }

    private int height(AVLNode t){
        return t == null ? -1 : t.height;
    }

    public void insert(T x){
        if (x == null)
            return;

        root = insert(x, root);
    }

    private AVLNode<T> insert(T x, AVLNode<T> t){
        if (t == null)
            return new AVLNode(x);

        int i = x.compareTo(t.data);
        if (i < 0)
            t.leftNode = insert(x, t.leftNode);
        if (i > 0)
            t.rightNode = insert(x, t.rightNode);

        return balance(t);
    }

    public T remove(T t){
        if (t == null)
            return null;

        AVLNode<T> remove = remove(t, root);

        return remove.data;
    }

    private AVLNode<T> remove(T t, AVLNode<T> node){
        if (t == null || node == null)
            return node;

        int result = t.compareTo(node.data);
        if (result > 0){
            node.rightNode = remove(t, node.rightNode);
        } else if (result < 0){
            node.leftNode = remove(t, node.leftNode);
        } else if (node.leftNode != null && node.rightNode != null){
            AVLNode<T> min = findMin(node.rightNode);
            node.data = min.data;
            node.rightNode = remove(node.data, node.rightNode);
        } else {
            node = node.leftNode != null ? node.leftNode : node.rightNode;
        }

        return balance(node);
    }

    private AVLNode<T> findMin(AVLNode<T> node){
        while (node.leftNode != null)
            node = node.leftNode;

        return node;
    }

    public void printTree(){
        printTree(root);
    }

    private void printTree(AVLNode<T> node){
        System.out.println(node.data);
        if (node.leftNode != null)
            printTree(node.leftNode);
        if (node.rightNode != null)
            printTree(node.rightNode);
    }

    private static final int ALLOWED_IMBALANCE = 1;

    private AVLNode<T> balance(AVLNode t){
        if (t == null)
            return null;

        if (height(t.leftNode) - height(t.rightNode) > ALLOWED_IMBALANCE) {
            if (height(t.leftNode.leftNode) >= height(t.leftNode.rightNode))
                t = rotateWithLeftChild(t);
            else
                doubleWithRightChild(t);
        } else if (height(t.rightNode) - height(t.leftNode) > ALLOWED_IMBALANCE) {
            if (height(t.rightNode.rightNode) >= height(t.rightNode.leftNode))
                t = rotateWithRightChild(t);
            else
                t = doubleWithLeftChild(t);
        }

        t.height = Math.max(height(t.leftNode), height(t.rightNode)) + 1;

        return t;
    }

    //左左
    private AVLNode rotateWithLeftChild(AVLNode<T> k2){
        AVLNode<T> k1 = k2.leftNode;
        k2.leftNode = k1.rightNode;
        k1.rightNode = k2;

        k2.height = Math.max(height(k2.leftNode), height(k2.rightNode)) + 1;
        k1.height = Math.max(height(k2), height(k1.leftNode)) + 1;

        return k1;
    }

    //右右
    private  AVLNode rotateWithRightChild(AVLNode<T> k1) {
        AVLNode<T> k2 = k1.rightNode;
        k1.rightNode = k2.leftNode;
        k2.leftNode = k1;

        k1.height = Math.max(height(k1.leftNode), height(k1.rightNode)) + 1;
        k2.height = Math.max(height(k1), height(k2.rightNode)) + 1;

        return k2;
    }

    //左右
    private AVLNode doubleWithRightChild(AVLNode<T> k3){
        k3.leftNode = rotateWithRightChild(k3.leftNode);

        return rotateWithLeftChild(k3);
    }

    //右左
    private AVLNode doubleWithLeftChild(AVLNode<T> k3){
        k3.rightNode = rotateWithLeftChild(k3.rightNode);

        return rotateWithRightChild(k3);
    }

}
