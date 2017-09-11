package com.ming.test.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 无向图
 */
public class Graph {
    private int V;//顶点
    private int E;//边
    private LinkedList<Integer>[] adj;//邻接表

    public Graph(int v){
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    /**
     *
     * 文件内容格式，第一行表示定点数，第二行表示边数，第三行及以后表示边的连接
     * 13
     * 13
     * 0 5
     * 4 3
     * 0 1
     * 9 12
     * 6 4
     * 5 4
     * 0 2
     * 11 12
     * 9 10
     * 0 6
     * 7 8
     * 9 11
     * 5 3
     *
     * @param in
     * @throws IOException
     */
    public Graph(InputStream in) throws IOException {
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader buff = new BufferedReader(reader);

        this.V = Integer.valueOf(buff.readLine());
        adj = new LinkedList[this.V];
        for (int i = 0; i < this.V; i++) {
            adj[i] = new LinkedList<Integer>();
        }

        buff.readLine();//因前2行表示顶点数和边数，读到第二行
        for (int i = 0; i < this.V; i++) {
            String str = buff.readLine();
            String[] split = str.split(" ");
            int v = Integer.valueOf(split[0]);
            int w = Integer.valueOf(split[1]);
            addEde(v, w);
        }

        buff.close();
        reader.close();
    }

    public void addEde(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        this.E++;
    }

    public LinkedList<Integer> adj(int v){
        if (v < this.V)
            return adj[v];

        return new LinkedList<>();
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    @Override
    public String toString() {
        String str = this.E + " edge " + this.V + " vertex \r\n";
        for (int i = 0; i < this.V; i++) {
            for (Integer w: this.adj[i]) {
                str += "s:"+i + " w:"+w + "\r\n";
            }
        }

        return str;
    }
}
