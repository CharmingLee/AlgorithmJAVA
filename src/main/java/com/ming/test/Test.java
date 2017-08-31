package com.ming.test;

import com.ming.test.Sort.QuickSort;

import java.util.Arrays;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {
    public static void main(String[] arg) {
        Integer[] arr = new Integer[8];
        arr[0] = 31;
        arr[1] = 41;
        arr[2] = 59;
        arr[3] = 26;
        arr[4] = 53;
        arr[5] = 58;
        arr[6] = 97;
        arr[7] = 97;

        QuickSort<Integer> s = new QuickSort<>();
        s.quickSort(arr);

        System.out.println(Arrays.asList(arr));

    }

}