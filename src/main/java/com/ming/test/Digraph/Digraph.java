package com.ming.test.Digraph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 有向图
 * Created by charminglee on 17-10-12.
 */
public class Digraph {
    private int E;
    private int V;
    private LinkedList<Integer>[] adj;

    public Digraph(int v){
        this.V = v;
        this.E = 0;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            this.adj[i] = new LinkedList<>();
    }

    public Digraph(String fileName) throws Exception {
        FileInputStream in = new FileInputStream(fileName);
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader buff = new BufferedReader(reader);

        this.V = Integer.valueOf(buff.readLine());
        this.adj = new LinkedList[this.V];
        for (int i = 0; i < this.V; i++)
            this.adj[i] = new LinkedList<>();

        int e = Integer.valueOf(buff.readLine());
        for (int i = 0; i < e; i++) {
            String str = buff.readLine();
            String[] split = str.split(" ");
            int v = Integer.valueOf(split[0]);
            int w = Integer.valueOf(split[1]);
            add(v, w);
        }

    }

    /**
     * 反向图
     * @return
     */
    public Digraph reverse(){
        Digraph digraph = new Digraph(this.V);
        for (int v = 0; v < this.V; v++) {
            for (int w :adj(v)) {
                digraph.add(w, v);
            }
        }

        return digraph;
    }

    public void add(int v, int w){
        this.adj[v].push(w);
        this.E ++;
    }

    public LinkedList<Integer> adj(int v){
        return this.adj[v];
    }

    public int getE() {
        return E;
    }

    public int getV() {
        return V;
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
