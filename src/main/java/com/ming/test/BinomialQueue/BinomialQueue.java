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

    public BinomialQueue(T x){
        nodeTrees = new Node[DEFULL_SIZE];
        nodeTrees[0] = new Node<T>(x);
        currentSize++;
    }

    public void merge(BinomialQueue<T> rhs){
        if (this == rhs || rhs == null || rhs.currentSize < 1)
            return;

        currentSize += rhs.currentSize;
        if (currentSize > capacity()){
            int maxSize = Math.max(rhs.nodeTrees.length, nodeTrees.length);
            expandTheTrees(maxSize + 1);
        }

        int index = 0;
        int j = 1;
        Node<T> t1 = null;
        Node<T> t2 = null;
        Node<T> carry = null;
        while (j <= currentSize){
            t1 = nodeTrees[index];
            t2 = index < rhs.nodeTrees.length ? rhs.nodeTrees[index] : null;

            int whilCase = t1 == null ? 0 : 1;
            whilCase += t2 == null ? 0 : 2;
            whilCase += carry == null ? 0 : 4;

            switch (whilCase){
                case 0://all null
                    break;
                case 1://t1
                    break;
                case 2://t2
                    nodeTrees[index] = t2;
                    rhs.nodeTrees[index] = null;
                    break;
                case 3://t1 t2
                    carry = comBineTrees(t1, t2);
                    nodeTrees[index] = rhs.nodeTrees[index] = null;
                    break;
                case 4://carry
                    nodeTrees[index] = carry;
                    carry = null;
                    break;
                case 5://t1 carry
                    carry = comBineTrees(t1, carry);
                    nodeTrees[index] = null;
                    break;
                case 6://t2 carry
                    carry = comBineTrees(t2, carry);
                    rhs.nodeTrees[index] = null;
                    break;
                case 7://t1 t2 carry
                    nodeTrees[index] = carry;
                    carry = comBineTrees(t1, t2);
                    rhs.nodeTrees[index] = null;
                    break;
            }

            index++;
            j *= 2;
        }

        rhs.currentSize = 0;
        rhs.nodeTrees = null;
    }

    public void insert(T x){
        if (x != null)
            merge(new BinomialQueue<T>(x));
    }

    public T findMin(){
        int index = findMinNode();
        if (index > -1)
            return nodeTrees[index].data;

        return null;
    }

    public T delMin(){
        int minIndex = findMinNode();
        Node<T> delNode = nodeTrees[minIndex].childrenNode;
        T minData = nodeTrees[minIndex].data;

        BinomialQueue<T> delQueue = new BinomialQueue<>();
        delQueue.expandTheTrees(minIndex);
        delQueue.currentSize = (1 << minIndex)-1;

        for (int i = minIndex -1; i > -1; i--) {
            delQueue.nodeTrees[i] = delNode;
            delNode = delNode.nextNode;
            delQueue.nodeTrees[i].nextNode = null;
        }

        nodeTrees[minIndex] = null;
        currentSize -= delQueue.currentSize + 1;
        merge(delQueue);

        return minData;
    }

    private int capacity(){
        return (1 << nodeTrees.length) -1;
    }

    private void expandTheTrees(int size){
        Node<T>[] newTree = new Node[size];
        for (int i = 0; i < Math.min(size, nodeTrees.length); i++)
            newTree[i] = nodeTrees[i];

        nodeTrees = newTree;
    }

    private int findMinNode(){
        int min = -1;

        for (int i = 0; i < nodeTrees.length; i++){
            if (min == -1 && nodeTrees[i] != null){
                min = i;
                break;
            }

            if (nodeTrees[i] != null && min > -1)
                if (nodeTrees[min].data.compareTo(nodeTrees[i].data) > 0)
                    min = i;
        }

        return min;
    }

    private Node<T> comBineTrees(Node<T> t1, Node<T> t2){
        if (t1.data.compareTo(t2.data) > 0)
            return comBineTrees(t2, t1);
        t2.nextNode = t1.childrenNode;
        t1.childrenNode = t2;
        return t1;
    }

    public int getCurrentSize(){
        return currentSize;
    }

    private static class Node<T>{
        public T data;
        public Node<T> childrenNode;
        public Node<T> nextNode;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node<T> childrenNode, Node<T> nextNode) {
            this.data = data;
            this.childrenNode = childrenNode;
            this.nextNode = nextNode;
        }
    }

}
