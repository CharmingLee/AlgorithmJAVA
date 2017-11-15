package com.ming.test.Digraph;

/**
 * 加权有向边
 * Created by charminglee on 17-11-13.
 */
public class DirectedEdge {
    private int v;
    private int w;
    private double weight;

    public DirectedEdge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public int from(){
        return v;
    }

    public int to(){
        return w;
    }

    @Override
    public String toString() {
        return "DirectedEdge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }
}
