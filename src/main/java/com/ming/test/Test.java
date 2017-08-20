package com.ming.test;

import com.ming.test.LeftisHeap.Leftisheap;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {
    public static void main(String[] arg) {
        Leftisheap<Integer> leftisheap = new Leftisheap<>();
        leftisheap.root = new Leftisheap.Node<Integer>(8);
        leftisheap.root.left = new Leftisheap.Node<Integer>(17);
        leftisheap.root.left.left = new Leftisheap.Node<Integer>(26);


        Leftisheap<Integer> leftisheap2 = new Leftisheap<>();
        leftisheap2.root = new Leftisheap.Node<Integer>(6, 2);
        leftisheap2.root.left = new Leftisheap.Node<Integer>(12, 1);
        leftisheap2.root.left.left = new Leftisheap.Node<Integer>(18);
        leftisheap2.root.left.right = new Leftisheap.Node<Integer>(24);
        leftisheap2.root.left.right.left = new Leftisheap.Node<Integer>(33);
        leftisheap2.root.right = new Leftisheap.Node<Integer>(7, 1);
        leftisheap2.root.right.left = new Leftisheap.Node<Integer>(37);
        leftisheap2.root.right.right = new Leftisheap.Node<Integer>(18);

        leftisheap.print();
        System.out.println("================");
        leftisheap2.print();
        System.out.println("================");
        leftisheap.merge(leftisheap2);
        leftisheap.print();
        System.out.println("================");
    }
}