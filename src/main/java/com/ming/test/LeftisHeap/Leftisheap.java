package com.ming.test.LeftisHeap;

public class Leftisheap <T extends Comparable<? super T>>{
    public Node<T> root;

    public void merge(Leftisheap<T> rhs){
        if (rhs == null)
            return;

        root = merge(root, rhs.root);
        rhs.root = null;
    }

    public void insert(T x){
        if (x == null)
            return;

        root = merge(new Node<T>(x), root);
    }

    public T findMin(){
        if (root == null)
            return null;

        return root.data;
    }


    public T deleteMin(){
        if (root == null)
            return null;

        T data = root.data;
        root = merge(root.left, root.right);

        return data;
    }

    public void print(){
        print(root);
    }

    private void print(Node<T> root){
        if (root == null)
            return;

        System.out.println(root.data);
        print(root.left);
        print(root.right);
    }

    public static class Node<T> {
        public T data;
        public Node<T> left;
        public Node<T> right;
        public int npl;

        public Node(T data){
            this(data,null,null,0);
        }

        public Node(T data, int npl){
            this(data,null,null,npl);
        }

        public Node(T data, Node<T> left, Node<T> right, int npl){
            this.data = data;
            this.left = left;
            this.right = right;
            this.npl = npl;
        }
    }

    private Node<T> merge(Node<T> h1, Node<T> h2){
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
        if (h1.data.compareTo(h2.data) < 0)
            return merge1(h1, h2);
        else
            return merge1(h2, h1);
    }

    private Node<T> merge1(Node<T> h1, Node<T> h2){
        if (h1.left == null){
            h1.left = h2;
        } else {
            h1.right = merge(h1.right, h2);
            if (h1.left.npl < h1.right.npl)
                swapChildren(h1);
            h1.npl = h1.right.npl + 1;
        }

        return h1;
    }

    private void swapChildren(Node<T> h){
        Node<T> temp = h.left;
        h.left = h.right;
        h.right = temp;
    }
}
