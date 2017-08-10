package com.ming.test;

interface HashFamily<T> {
    int hash(T x,int swich);
    int getNumOfFunction();
    void generateNewFunction();
}
