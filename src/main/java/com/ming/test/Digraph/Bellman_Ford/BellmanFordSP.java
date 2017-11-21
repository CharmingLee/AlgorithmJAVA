package com.ming.test.Digraph.Bellman_Ford;

import com.ming.test.Digraph.DirectedEdge;
import com.ming.test.Digraph.EdgeWeightedDigraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by charminglee on 17-11-21.
 */
public class BellmanFordSP {
    private double[] distTo;//从起点到某个顶点的路径长度
    private DirectedEdge[] edgeTo;//从起点到某个顶点的最后一条边
    private Queue<Integer> queue;//正在被放松的顶点
    private boolean[] onQ;//该顶点是否存在于队列中
    private int cost;//relax()调用次数
    private LinkedList<DirectedEdge> cycle;//edgeTo[]中是否含有负权重环

    public BellmanFordSP(EdgeWeightedDigraph g, int s){
        distTo = new double[g.getV()];
        edgeTo = new DirectedEdge[g.getV()];
        queue = new LinkedList<>();
        onQ = new boolean[g.getV()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0;
        queue.add(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle()){
            Integer v = queue.poll();
            onQ[v] = false;
            relax(g, v);
        }
    }

    private void relax(EdgeWeightedDigraph g, int v){
        for (DirectedEdge e : g.adj(v)) {
            if (distTo[e.to()] > distTo[v] + e.getWeight()){
                distTo[e.to()] = distTo[v] + e.getWeight();
                edgeTo[e.to()] = e;
                if (!onQ[e.to()]){
                    queue.add(e.to());
                    onQ[e.to()] = true;
                }
            }

            if (cost++ %g.getV() == 0){
                findNegativeCycle();
            }
        }
    }

    public double distTo(int v){
        if (v > distTo.length -1 || v < 0 || hasNegativeCycle())
            return Double.POSITIVE_INFINITY;
        return distTo[v];
    }

    public boolean hasPathTo(int v){
        if (v > distTo.length -1 || v < 0 || hasNegativeCycle())
            return false;

        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public LinkedList<DirectedEdge> pathTo(int v){
        if (!hasPathTo(v))
            return null;

        LinkedList<DirectedEdge> path = new LinkedList<>();
        while (edgeTo[v] != null){
            path.add(edgeTo[v]);
            v = edgeTo[v].from();
        }

        return path;
    }

    private void findNegativeCycle(){
        int v = distTo.length;
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(v);
        for (int i = 0; i < v; i++) {
            if (edgeTo[i] != null){
                g.add(edgeTo[i]);
            }
        }

        EdgeWeightedCycleFinder finder = new EdgeWeightedCycleFinder(g);
        cycle = finder.cycle();
    }

    public boolean hasNegativeCycle(){
        return cycle != null;
    }

    public LinkedList<DirectedEdge> negativeCycle(){
        return cycle;
    }

}
