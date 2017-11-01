package com.ming.test;

import com.ming.test.UnionFind.QuickUnion;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {

    public static void main(String[] arg) throws IOException {
        FileInputStream fin = new FileInputStream("/home/charminglee/Desktop/图/tinyUF.txt");
        QuickUnion uf = new QuickUnion(fin);

        System.out.println(uf.connected(4, 8));
        System.out.println(uf.count());
    }


}