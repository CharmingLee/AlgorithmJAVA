package com.ming.test.Graph;

/**
 * Created by charminglee on 17-10-27.
 */
public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int either(){
        return v;
    }

    public int other(int v){
        if (this.v == v)
            return this.w;
        else
            return this.v;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.weight < o.weight)
            return -1;
        if (this.weight > o.weight)
            return 1;

        return 0;
    }
}
