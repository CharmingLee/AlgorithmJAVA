package com.ming.test;

import com.ming.test.RBTree.RedBlackBST;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {

    public static void main(String[] arg) {
        RedBlackBST<String, String> bst = new RedBlackBST<>();
        bst.put("s","s");
        bst.put("e","e");
        bst.put("a","a");

        System.out.println(bst.getCount());
    }


}