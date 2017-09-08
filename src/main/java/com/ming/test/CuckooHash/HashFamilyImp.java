package com.ming.test.CuckooHash;

import java.util.Random;

public class HashFamilyImp implements HashFamily<String> {
    private int[] function;
    private Random r;
    private  int COUNT = 77;

    public HashFamilyImp(int size){
        COUNT = size;
        function = new int[COUNT];
        r = new Random();

        generateNewFunction();
    }


    @Override
    public int hash(String x, int swich) {
        int val = function[swich];
        int hashVal = 0;

//        System.out.println("计算hash="+x);
        for (int i = 0; i < x.length(); i++) {
            hashVal += val * x.charAt(i);
        }

        return hashVal;
    }

    @Override
    public int getNumOfFunction() {
        return function.length;
    }

    @Override
    public void generateNewFunction() {
        for (int i = 0; i < function.length; i++) {
            function[i] = r.nextInt();
        }

    }
}
