package com.ming.test.Sort;

/**
 * Max堆排序
 */
public class BinaryHeapSort<T extends Comparable<? super T>> {

    private void percDown(T[] arr, int i, int length){
        T temp = arr[i];
        int child;
        while (leftChild(i) < length){
            child = leftChild(i);
            if (child + 1 < length && arr[child].compareTo(arr[child + 1]) < 0)
                child++;
            if (temp.compareTo(arr[child]) < 0)
                arr[i] = arr[child];
             else
                break;

            i = child;
        }
        arr[i] = temp;
    }

    private int leftChild(int i){
        return 2*i+1;
    }

    public void binaryHeapSort(T[] arr){
        for (int i = arr.length/2 - 1; i > -1; i--)
            percDown(arr, i, arr.length);
        for (int i = arr.length - 1; i > -1; i--) {
            swap(arr, 0, i);
            percDown(arr, 0, i);
        }
    }

    private void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
