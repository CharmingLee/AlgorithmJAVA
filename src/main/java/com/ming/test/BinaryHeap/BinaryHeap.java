package com.ming.test.BinaryHeap;

/**
 * 二叉堆(Min)
 * @param <T>
 */
public class BinaryHeap<T extends Comparable<? super T>> {
    private static final int DEFAULT_SIZE = 10;
    private T[] array;
    private int currentSize;

    public BinaryHeap(){
        array = (T[]) new Comparable[DEFAULT_SIZE];
    }

    public BinaryHeap(T[] items){
        currentSize = items.length;
        array = (T[])new Comparable[currentSize * 2 +1];
        for (int i = 0; i < items.length; i++)
            array[i+1] = items[i];

        biuldHelp();
    }

    public void insert(T x){
        if (x == null)
            return;

        percolateUp(x);
    }

    public T findMin(){
        return array[1];
    }

    public T deleteMin(){
        if (isEmpty())
            return null;

        T min = findMin();
        array[1] = null;
        percolateDown(1, array[currentSize--]);

        return min;
    }

    public boolean isEmpty(){
        return array == null ? true : (currentSize == 0);
    }

    public void print(){
        if (array != null)
            for (T x : array)
                if (x != null)
                    System.out.println(x);
    }

    private void biuldHelp(){
        for (int i = currentSize/2; i > 0; i--) {
            percolateDown(i, array[i]);
        }
    }

    private void enlargeArray(int size){
        T[] old = array;
        array = (T[]) new Comparable[size];
        for (int i = 0; i < old.length; i++)
            array[i] = old[i];
    }

    private void percolateDown(int hole, T x){
        int index;
        while (hole * 2 <= currentSize){
            index = hole*2;
            if (array[index+1] != null && array[index].compareTo(array[index+1]) > 0)
                index++;

            if (x.compareTo(array[index]) > 0)
                array[hole] = array[index];
            else
                break;

            hole = index;
        }

        array[hole] = x;
    }

    private void percolateUp(T x){
        if (currentSize == array.length -1)
            enlargeArray(array.length * 2 +1);

        int hole = ++currentSize;
        while (array[hole/2] != null && x.compareTo(array[hole/2]) < 0){
            array[hole] = array[hole/2];
            hole /= 2;
        }

        array[hole] = x;
    }

}
