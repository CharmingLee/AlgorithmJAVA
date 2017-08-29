package com.ming.test.Sort;

/**
 * 归并排序
 */
public class MergeSort<T extends Comparable<? super T>> {

    public void mergeSort(T[] arr){
        T[] tempArr = (T[]) new Comparable[arr.length];
        mergeSort(arr, tempArr, 0, arr.length -1);
    }

    private void mergeSort(T[] arr, T[] tempArr, int start, int end){
        if (start < end){
            int center = (start + end) / 2;
            mergeSort(arr, tempArr, start, center);
            mergeSort(arr, tempArr, center + 1, end);
            merge(arr, tempArr, start, center+1, end);
        }
    }

    private void merge(T[] arr, T[] tempArr, int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos -1;
        int tempPos = leftPos;
        int elementNums = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (arr[leftPos].compareTo(arr[rightPos]) <= 0)
                tempArr[tempPos++] = arr[leftPos++];
            else
                tempArr[tempPos++] = arr[rightPos++];
        }

        while (leftPos <= leftEnd)
            tempArr[tempPos++] = arr[leftPos++];

        while (rightPos <= rightEnd)
            tempArr[tempPos++] = arr[rightPos++];

        for (int i = 0; i < elementNums; i++,rightEnd--) {
            arr[rightEnd] = tempArr[rightEnd];
        }

    }

}
