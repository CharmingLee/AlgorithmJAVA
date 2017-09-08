package com.ming.test.CuckooHash;

import java.util.Random;

/**
 * 布谷鸟散列表
 * @param <T>
 */
public class CuckooHashTable<T> {
    private T[] array;
    //填充因子
    private static final double MAX_LOAD = 0.4;
    //插入时最大rehash次数
    private static final int ALLOWED_REHASHES = 1;
    //默认数组大小
    private static final int DEFAULT_SIZE = 101;
    //当前大小
    private int currentSize;
    private HashFamily hf;
    private int numOfFunction;
    private Random r = new Random();

    public CuckooHashTable(HashFamily hf){
        this(hf,DEFAULT_SIZE);
    }

    public CuckooHashTable(HashFamily hf, int size){
        this.hf = hf;
        allocateArray(nextPrimeNum(size));
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

    public void print(){
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
                System.out.println(array[i]);
        }
    }

    public boolean insert(T x){
        if (contains(x))
            return false;

        if (currentSize > array.length * MAX_LOAD)
            expand();

        return insertHelper(x);
    }

    private boolean insertHelper(T x){
        int COUNT_LIMIT = 50;
        int rehashCount = 0;

        while (true){
            int newINdex;
            int lastIndex = -1;

            //尝试替换COUNT_LIMIT次
            for (int i = 0; i < COUNT_LIMIT; i++) {
                //hash后获得的index是否为空，是则直接插入完成
                for (int j = 0; j < numOfFunction; j++) {
                    int index = myHash(x, j);
                    if (array[index] == null){
                        array[index] = x;
                        currentSize++;
                        return true;
                    }
                }

                //如果hash出来的index在数组中都不为空则随机选择一项进行替换，让被替换的去寻找新的位置
                int k = 0;
                //随机选取得位置和最后一次选得相同则重新再选，最多尝试5次
                do{
                    newINdex = myHash(x, r.nextInt(numOfFunction));
                }while (lastIndex == newINdex || k++ < 5);

                lastIndex = newINdex;
                T temp = array[newINdex];
                array[newINdex] = x;
                x = temp;
            }

            //如果替换COUNT_LIMIT次后依然冲突则重新hash,重新hash超过次数后拓展数组
            if (++rehashCount < ALLOWED_REHASHES){
                reHash();
            } else {
                expand();
                rehashCount = 0;
                System.out.println("扩展数组="+x);
            }

        }
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
        hf.generateNewFunction();
        reHash(array.length);
    }

    private void reHash(int size){
        T[] old = array;

        allocateArray(nextPrimeNum(size));
        currentSize = 0;

        for (T t : old)
            if (t != null)
                insert(t);

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

        currentSize = 0;
    }

    private void allocateArray(int size){
        System.out.println("初始化代大小="+size);
        array = (T[]) new Object[size];
    }

}
