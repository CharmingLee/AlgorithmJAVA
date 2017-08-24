package com.ming.test;

import com.ming.test.BinomialQueue.BinomialQueue;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {
    public static void main(String[] arg) {
        BinomialQueue<Integer> newQueue = new BinomialQueue<>();
        for (int i = 36; i > 0; i--) {
            newQueue.insert(i);
        }


        int len = newQueue.getCurrentSize();
        for (int i = 0; i < len; i++) {
            System.out.println(newQueue.delMin());
        }
    }
}