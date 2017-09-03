package com.ming.test.Sort;

import java.util.ArrayList;

public class Sort<T extends Comparable<? super T>> {

    /**
     * 插入排序
     * @param arr
     */
    public void insertionSort(T[] arr){
        int j;
        for (int i = 1; i < arr.length; i++) {
            T temp = arr[i];
            for (j = i; j > 0 && temp.compareTo(arr[j-1]) < 0; j--)
                arr[j] = arr[j-1];

            arr[j] = temp;
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public void shellSort(T[] arr){

        for (int i = arr.length/2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                T temp = arr[j];
                int k;
                for (k = j; k >= i && temp.compareTo(arr[k -i]) < 0; k -= i) {
                    arr[k] = arr[k-i];
                }

                arr[k] = temp;
            }
        }


    }

    /**
     * 单一长度字符串(ascii 256以下)排序
     * @param arr
     * @param stringLen
     */
    public static void singleLenStringSort(String[] arr, int stringLen){
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

    /**
     * 不同长度字符串(ascii 256以下)数组排序
     * @param arr
     * @param maxLen
     */
    public static void stringSort(String[] arr, int maxLen){
        //为每个长度的字符串创建一个桶
        ArrayList<String>[] stringByLen = new ArrayList[maxLen + 1];
        for (int i = 0; i < stringByLen.length; i++) {
            stringByLen[i] = new ArrayList<String>();
        }

        //不同ascii码的字符串创建一个桶
        final int BUCKETS = 256;
        ArrayList<String>[] buckets = new ArrayList[BUCKETS];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<String>();
        }

        //把字符串按照长度放到对应的桶里，stringByLen数组的下标表示字符串的长度
        for (int i = 0; i < arr.length; i++) {
            stringByLen[arr[i].length()].add(arr[i]);
        }

        //按照数组下标遍历每个桶并放回到arr数组中，这时数组中的字符串已经按照长度不同排序
        int index = 0;
        for (ArrayList<String> strLenArr : stringByLen) {
            for (String s : strLenArr) {
                arr[index++] = s;
            }
        }

        int startIndex = arr.length;
        for (int pos = maxLen - 1; pos >= 0 ; pos--) {
            //startIndex表示pos + 1长度的字符串在arr中下标的起点
            startIndex -= stringByLen[pos + 1].size();
            //按当前字符在ascii中对应的数值放入对应下标的桶里
            for (int i = startIndex; i < arr.length; i++) {
                buckets[arr[i].charAt(pos)].add(arr[i]);
            }

            //从桶中按下标从小到大去除字符串并放到数组相应位置
            int idx = startIndex;
            for (ArrayList<String> strArr : buckets) {
                for (String s : strArr) {
                    arr[idx++] = s;
                }

                strArr.clear();
            }

        }

    }

}
