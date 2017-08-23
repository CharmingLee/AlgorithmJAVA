package com.ming.test.BinomialQueue;


/**
 * 二项队列
 * @param <T>
 */
public class BinomialQueue <T extends Comparable<? super T>> {
    private int DEFULL_SIZE = 1;
    private Node<T>[] nodeTrees;
    private int currentSize;

    public BinomialQueue(){
        this.nodeTrees = new Node[DEFULL_SIZE];
    }

    public BinomialQueue(Node<T> nodes){

    }

    public void merge(BinomialQueue<T> rhs){
        if (this == rhs || rhs == null || rhs.currentSize < 1)
            return;


    }

    public void insert(Node<T> x){

    }

    public T findMin(){
        return null;
    }

    public T delMin(){
        return null;
    }

    private Node<T> comBineTrees(Node<T> t1, Node<T> t2){
        if (t1.data.compareTo(t2.data) > 0)
            return comBineTrees(t2, t1);
        t2.nextNode = t1.childeNode;
        t1.childeNode = t2;
        return t1;
    }

    public int getCurrentSize(){
        return currentSize;
    }

    private static class Node<T>{
        public T data;
        public Node<T> childeNode;
        public Node<T> nextNode;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node<T> childeNode, Node<T> nextNode) {
            this.data = data;
            this.childeNode = childeNode;
            this.nextNode = nextNode;
        }
    }

}
