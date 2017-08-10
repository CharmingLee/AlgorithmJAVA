package com.ming.test;

public class CuckooHashTable<T> {
    private T[] array;
    //填充因子
    private static final double MAX_LOAD = 0.4;
    //插入时最大rehash次数
    private static final int ALLOWED_REHASHES = 1;
    private static final int DEFAULT_SIZE = 1;
    private HashFamily hf;
    private int numOfFunction;


    public CuckooHashTable(HashFamily hf){
        this(hf,DEFAULT_SIZE);
    }

    public CuckooHashTable(HashFamily hf, int size){
        this.hf = hf;
        allocateArray(size);
        doClean();
        numOfFunction = hf.getNumOfFunction();
        hf.generateNewFunction();
    }

    public boolean contains(T x){
        return findPos(x) != -1;
    }

    public boolean remove(T x){
        int pos = findPos(x);

        if (array[pos] != null){
            array[pos] = null;
            return true;
        }

        return false;
    }

    public boolean insert(T x){

        return false;
    }

    private void insertHelper(){

    }

    private int myHash(T x,int swich){
        int index = hf.hash(x, swich);
         index %= array.length;
        if (index < 0)
            index += array.length;

        return index;
    }

    private int findPos(T x){

        for (int i = 0; i < numOfFunction; i++) {
            int pos = myHash(x, i);
            if (array[pos] != null && array[pos].equals(x))
                return pos;
        }

        return -1;
    }

    private void reHash(){
        reHash(array.length);
    }

    private void reHash(int size){
        T[] old = array;

        size = nextPrimeNum(size);
        allocateArray(size);

        for (T t : old) {
            insert(t);
        }

    }

    //查找下一个素数
    private int nextPrimeNum(int num){
        while (!isPrimeNum(++num));

        return num;
    }

    private boolean isPrimeNum(int num){
        if (num < 3)
            return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    private void expand(){
        reHash( (int)(array.length / MAX_LOAD) );
    }

    private void doClean(){
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    private void allocateArray(int size){
        array = (T[]) new Object[size];
    }
}
