package com.ming.test.Graph;

import com.ming.test.UnionFind.WeightedQuickUnionUF;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by charminglee on 17-11-1.
 */
public class KruskaMST {
    private LinkedList<Edge> mst;
    private PriorityQueue<Edge> pq;
    private WeightedQuickUnionUF uf;

    public KruskaMST(EdgeWeightedGraph g){
        this.mst = new LinkedList<>();
        this.uf = new WeightedQuickUnionUF(g.getV());
        this.pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.getWeight() < o2.getWeight())
                    return -1;
                if (o1.getWeight() > o2.getWeight())
                    return 1;

                return 0;
            }
        });

        for (Edge e: g.edges()) {
            this.pq.add(e);
        }

        while (!this.pq.isEmpty() && this.mst.size() < g.getV()-1){
            Edge poll = this.pq.poll();
            int v = poll.either();
            int w = poll.other(v);
            if (this.uf.connected(v, w)){
                continue;
            }

            this.uf.union(v, w);
            this.mst.add(poll);
        }

    }

    public LinkedList<Edge> edges(){
        return this.mst;
    }

    public double weight(){
        double weight = 0;
        for (Edge e : this.mst) {
            weight += e.getWeight();
        }

        return weight;
    }
}
