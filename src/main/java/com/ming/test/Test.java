package com.ming.test;

import java.util.Arrays;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {
    public static void main(String[] arg) {
        int[] i1 = {1,2};
        int[] i2 = {3,4};

        int[] a1 = i1;
        int[] a2 = i2;

        int[] temp = a1;
        a1 = a2;
        a2 = temp;

        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }
}