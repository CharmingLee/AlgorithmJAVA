package com.ming.test.Graph;

import java.util.LinkedList;

/**
 * 无向图
 */
public class Graph<T> {
    private final int V;//顶点
    private int E;//边
    private LinkedList<T>[] adj;//邻接表

    public Graph(int v){
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<T>();
        }
    }

//    public Graph(InputStream in){
//
//    }

}
