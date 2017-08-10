package com.ming.test;

public class CuckooHashTable<T> {
    private T[] array;
    //填充因子
    private static final double MAX_LOAD = 0.4;
    //插入时最大rehash次数
    private static final int ALLOWED_REHASHES = 1;


    public CuckooHashTable(HashFamily hf){

    }

    public CuckooHashTable(HashFamily hf, int size){

    }

    public boolean contains(T x){
        return false;
    }

    public boolean remove(T x){
        return false;
    }

    public boolean insert(T x){
        return false;
    }

    private int myHash(T x,int swich){
        return -1;
    }

    private int findPos(T x){
        return -1;
    }

    private void reHash(){

    }

    private void expand(){

    }

    private void doClean(){

    }

    private void allocateArray(int size){

    }
}
