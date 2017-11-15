package com.ming.test.Digraph;

import com.ming.test.Graph.IndexMinPQ;

import java.util.LinkedList;

/**
 * 加权有向图Dijkstra算法
 * Created by charminglee on 17-11-13.
 */
public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Integer, Double> pq;

    public DijkstraSP(EdgeWeightedDigraph g, int s){
        this.edgeTo = new DirectedEdge[g.getV()];
        this.distTo = new double[g.getV()];
        for (int i = 0; i < g.getV(); i++) {
            this.distTo[i] = Double.POSITIVE_INFINITY;
        }
        this.pq = new IndexMinPQ<>();

        this.distTo[s] = 0.0;
        this.pq.put(s, 0.0);
        while(!this.pq.isEmpty()){
            relax(g, this.pq.delMin());
        }

    }

    private void relax(EdgeWeightedDigraph g, int v){
        for (DirectedEdge e : g.adj(v)) {
            double weight = this.distTo[v] + e.getWeight();
            if (this.distTo[e.to()] > weight){
                this.distTo[e.to()] = weight;
                this.edgeTo[e.to()] = e;
                this.pq.put(e.to(), e.getWeight());
            }
        }
    }

    public LinkedList<DirectedEdge> pathTo(int v){
        if (!hasPath(v) || null == this.edgeTo[v]){
            return null;
        }

        LinkedList<DirectedEdge> path = new LinkedList<>();
        while (this.edgeTo[v].from() > 0){
            path.add(this.edgeTo[v]);
            v = this.edgeTo[v].from();
        }

        return path;
    }

    public boolean hasPath(int v){
        if (v  < this.distTo.length)
            return this.distTo[v] < Double.POSITIVE_INFINITY;

        return false;
    }

}
