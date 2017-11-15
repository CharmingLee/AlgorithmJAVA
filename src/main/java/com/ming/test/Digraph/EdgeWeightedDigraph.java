package com.ming.test.Digraph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 带权重的有向图
 * Created by charminglee on 17-11-13.
 */
public class EdgeWeightedDigraph {
    private int E;
    private int V;
    private LinkedList<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(String fileName) throws IOException {
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
            double weight = Double.valueOf(split[2]);
            add(new DirectedEdge(v, w, weight));
        }
    }

    public LinkedList<DirectedEdge> adj(int v){
        if (v > this.V)
            return null;

        return this.adj[v];
    }

    private void add(DirectedEdge edge){
        this.adj[edge.from()].push(edge);
        this.E++;
    }

    public LinkedList<DirectedEdge> edges(){
        LinkedList<DirectedEdge> edges = new LinkedList<>();
        for (int i = 0; i < this.V; i++) {
            for (DirectedEdge e : this.adj[i]) {
                edges.push(e);
            }
        }

        return edges;
    }

    public int getE() {
        return E;
    }

    public int getV() {
        return V;
    }
}
