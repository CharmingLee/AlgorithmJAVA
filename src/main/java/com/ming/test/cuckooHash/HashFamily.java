package com.ming.test.cuckooHash;

/**
 * 布谷鸟散列表函数
 * @param <T>
 */
interface HashFamily<T> {
    int hash(T x,int swich);
    int getNumOfFunction();
    void generateNewFunction();
}
