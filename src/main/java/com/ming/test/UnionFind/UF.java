package com.ming.test.UnionFind;

/**
 * union-find
 * Created by charminglee on 17-11-1.
 */
public interface UF {
    void union(int p, int q);
    int find(int p);
    boolean connected(int p, int q);
    int count();
}
