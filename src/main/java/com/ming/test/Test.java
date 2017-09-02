package com.ming.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {
    public static void main(String[] arg) {
        String[] arr = {"abs","vbd","bbf","Abg","Cbr","Bbw"};

        sort(arr, 3);
        System.out.println(Arrays.toString(arr));

        sort1(arr, 3);
        System.out.println(Arrays.toString(arr));

    }

    private static void sort1(String[] arr, int stringLen){
        final int BUCKETS = 256;
        ArrayList<String>[] buckets = new ArrayList[BUCKETS];

        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (String s : arr) {
            buckets[s.charAt(0)].add(s);
        }

        int idx = 0;
        for (ArrayList<String> thisBuckets : buckets) {
            for (String s : thisBuckets) {
                arr[idx++] = s;
            }

            thisBuckets.clear();
        }

    }

    private static void sort(String[] arr, int stringLen){
        final int BUCKETS = 256;
        ArrayList<String>[] buckets = new ArrayList[BUCKETS];

        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int pos = stringLen - 1; pos >= 0; pos--) {
            for (String s : arr) {
                buckets[s.charAt(pos)].add(s);
            }

            int idx = 0;
            for (ArrayList<String> thisBuckets : buckets) {
                for (String s : thisBuckets) {
                    arr[idx++] = s;
                }

                thisBuckets.clear();
            }
        }

    }

}