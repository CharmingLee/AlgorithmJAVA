package com.ming.test;

import com.ming.test.Sort.Sort;

import java.util.Arrays;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {

    public static void main(String[] arg) {
        String[] str = {"cdv", "ecvd", "bds", "atv", "dffgg"};
        Sort.stringSort(str, 5);
        System.out.println(Arrays.toString(str));
    }


}