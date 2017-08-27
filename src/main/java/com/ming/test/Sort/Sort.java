package com.ming.test.Sort;

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

}
