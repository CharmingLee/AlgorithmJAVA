package com.ming.test.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by charminglee on 17-11-1.
 */
public class QuickUnion implements UF {
    private int[] id;
    private int count;

    public QuickUnion(InputStream in) throws IOException {
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader buff = new BufferedReader(reader);

        int n = Integer.valueOf(buff.readLine());
        init(n);

        String str = null;
        while ( (str = buff.readLine()) != null){
            String[] split = str.split(" ");
            int p = Integer.valueOf(split[0]);
            int q = Integer.valueOf(split[1]);
            union(p, q);
        }
    }

    public QuickUnion(int n){
        init(n);
    }

    private void init(int n){
        id = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        id[i] = j;
        count--;
    }

    @Override
    public int find(int p) {
        while (p != id[p]){
            p = id[p];
        }

        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
