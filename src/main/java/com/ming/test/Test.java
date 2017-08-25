package com.ming.test;

import com.ming.test.Sort.Sort;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {
    public static void main(String[] arg) {
        Integer[] arr = new Integer[10];
        for (int i = 0,j = 10; j > 0 ; j--,i++) {
            arr[i] = j;
        }


        Sort<Integer> s = new Sort<>();
        s.shellSort(arr);

        for (Integer i : arr) {
            System.out.println(i);
        }

    }
}