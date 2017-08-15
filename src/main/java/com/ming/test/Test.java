package com.ming.test;

import com.ming.test.BinaryHeap.BinaryHeap;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {
    public static void main(String[] arg) {
        Integer[] arr = {20, 1, 2, 3, 4, 5};

        BinaryHeap<Integer> heap = new BinaryHeap<>(arr);

        heap.print();
    }
}