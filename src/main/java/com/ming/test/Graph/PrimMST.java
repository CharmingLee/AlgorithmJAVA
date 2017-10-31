package com.ming.test.Graph;

import java.util.LinkedList;

/**
 * Created by charminglee on 17-10-30.
 */
public class PrimMST {
    private Edge[] edgeTo;
    private double[] disTo;
    private boolean[] marked;
    private IndexMinPQ<Integer, Double> pq;

    public PrimMST(EdgeWeightedGraph g){
        this.edgeTo = new Edge[g.getV()];
        this.disTo = new double[g.getV()];
        this.marked = new boolean[g.getV()];
        this.pq = new IndexMinPQ<>();

        for (int v = 0; v < g.getV(); v++) {
            this.disTo[v] = Double.POSITIVE_INFINITY;
        }

        this.disTo[0] = 0;
        this.pq.put(0,this.disTo[0]);
        while (!this.pq.isEmpty()){
            visit(g, this.pq.delMin());
        }

    }

    private void visit(EdgeWeightedGraph g, int v){
        this.marked[v] = true;
        for (Edge e : g.adj(v)) {
            int w = e.other(v);

            if (this.marked[w]){
                continue;
            }

            if (e.getWeight() < this.disTo[w]){
                this.edgeTo[w] = e;
                this.disTo[w] = e.getWeight();
                this.pq.put(w, this.disTo[w]);
            }

        }
    }

    public LinkedList<Edge> edges(){
        LinkedList<Edge> mst = new LinkedList<>();

        for (int i = 0; i < this.edgeTo.length; i++) {
            Edge e = this.edgeTo[i];
            if (e != null)
                mst.add(e);
        }

        return mst;
    }

    public double weight(){
        double weight = 0;

        for (int i = 1; i < this.edgeTo.length; i++) {
            Edge e = this.edgeTo[i];
            if (e != null)
                weight += e.getWeight();
        }

        return weight;
    }

}
