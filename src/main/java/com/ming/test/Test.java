package com.ming.test;

import com.ming.test.AVLTree.AVLTree;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {
    public static void main(String[] arg) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(5);
        avlTree.insert(4);
        avlTree.insert(3);
        avlTree.insert(2);
        avlTree.insert(1);

//        avlTree.remove(3);

        avlTree.printTree();

    }
}