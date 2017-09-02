package com.ming.test.Sort;

/**
 * 快速排序
 * @param <T>
 */
public class QuickSort <T extends Comparable<? super T>> {

    //defaull 10
    private final static int CUTOFF = 2;

    public void quickSort(T[] arr){

        quickSort(arr, 0, arr.length -1);
    }

    private void quickSort(T[] arr, int left, int right){
        if (left + CUTOFF < right){
            T pivot = median3(arr, left, right);
            int i = left;
            int j = right -1;

            while (true){
                while (arr[++i].compareTo(pivot) < 0);
                while (arr[--j].compareTo(pivot) > 0);

                if (i < j){
                    swapReferences(arr, i, j);
                } else {
                    break;
                }
            }

            swapReferences(arr, i, right -1);

            quickSort(arr, left,i);
            quickSort(arr, i + 1, right);

        } else {
            insertSort(arr, left, right);
        }

    }

    private void insertSort(T[] arr, int left, int right){
        int j;
        for (int i = left + 1; i < right; i++) {
            T temp = arr[i];
            for (j = i; j > left && temp.compareTo(arr[j-1]) < 0; j--)
                arr[j] = arr[j-1];

            arr[j] = temp;
        }
    }

    /**
     * 三数中值分割法
     * 从数组left right center的三个值按大小排序取center作为枢纽元(pivot)
     * 最后把枢纽元放到right-1位置。
     * @param arr
     * @param left
     * @param right
     */
    private T median3(T[] arr, int left, int right){
        int center = (left + right)/2;

        if (arr[left].compareTo(arr[center]) > 0)
            swapReferences(arr, left, center);
        if (arr[right].compareTo(arr[center]) < 0)
            swapReferences(arr, right, center);
        if (arr[left].compareTo(arr[right]) > 0)
            swapReferences(arr, left, right);

        swapReferences(arr, center, right - 1);

        return arr[right - 1];
    }

    private void swapReferences(T[] arr, int source, int target){
        T temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;
    }

}
