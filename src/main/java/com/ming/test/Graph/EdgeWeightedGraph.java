package com.ming.test.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Created by charminglee on 17-10-27.
 */
public class EdgeWeightedGraph {
    private final int V;
    private  int E;
    private LinkedList<Edge>[] adj;

    public EdgeWeightedGraph(int v){
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Edge>();
        }
    }

    public EdgeWeightedGraph(InputStream in) throws IOException {
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader buff = new BufferedReader(reader);

        this.V = Integer.valueOf(buff.readLine());
        adj = new LinkedList[this.V];
        for (int i = 0; i < this.V; i++) {
            adj[i] = new LinkedList<>();
        }

        int e = Integer.valueOf(buff.readLine());
        for (int i = 0; i < e; i++) {
            String str = buff.readLine();
            String[] split = str.split(" ");
            int v = Integer.valueOf(split[0]);
            int w = Integer.valueOf(split[1]);
            double weight = Double.valueOf(split[2]);

            addEdge(new Edge(v, w, weight));
        }

        buff.close();
        reader.close();
    }

    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);

        this.adj[v].add(e);
        this.adj[w].add(e);
        this.E++;
    }

    public LinkedList<Edge> adj(int v){
        if (v > this.adj.length - 1)
            return new LinkedList<>();

        return this.adj[v];
    }

    public LinkedList<Edge> edges(){
        LinkedList<Edge> edges = new LinkedList<>();

        for (int v = 0; v < this.V; v++)
            for (Edge e : adj(v))
                if (e.other(v) > v)
                    edges.add(e);

        return edges;
    }

}
