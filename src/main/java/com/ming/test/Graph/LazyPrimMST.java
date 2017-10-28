package com.ming.test.Graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * prim延迟算法
 * Created by charminglee on 17-10-28.
 */
public class LazyPrimMST {
    private boolean[] marked;
    private LinkedList<Edge> mst;
    private PriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph g){
        this.marked = new boolean[g.getV()];
        this.mst = new LinkedList<>();
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

        visit(g, 0);
        while (!pq.isEmpty()){
            Edge poll = this.pq.poll();
            int v = poll.either();
            int w = poll.other(v);
            if (this.marked[v] && this.marked[w])
                continue;

            this.mst.add(poll);
            if (!this.marked[v])
                visit(g, v);
            if (!this.marked[w])
                visit(g, w);
        }

    }

    private void visit(EdgeWeightedGraph g, int v){
        this.marked[v] = true;
        for (Edge e : g.adj(v))
            if (!this.marked[e.other(v)])
                pq.add(e);
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
