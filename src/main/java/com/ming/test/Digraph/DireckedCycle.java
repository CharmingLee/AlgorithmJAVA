package com.ming.test.Digraph;

import java.util.LinkedList;

/**
 * Created by charminglee on 17-10-17.
 */
public class DireckedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private LinkedList<Integer> cycle;//有向环的顶点
    private boolean[] onStack;//当前栈上的点

    public DireckedCycle(Digraph g){
        this.marked = new boolean[g.getV()];
        this.edgeTo = new int[g.getV()];
        this.onStack = new boolean[g.getV()];

        for (int v = 0; v < g.getV(); v++)
            if (!this.marked[v])
                dfs(g, v);
    }

    private void dfs(Digraph g, int v){
        this.marked[v] = true;
        this.onStack[v] = true;
        for (Integer w : g.adj(v)) {
            if (hasCycle()){
                return;
            } else if (!this.marked[w]){
                this.edgeTo[w] = v;
                dfs(g, w);
            } else if (this.onStack[w]){
                this.cycle = new LinkedList<>();
                for (int i = v; i != w ; i = edgeTo[i])
                    this.cycle.push(i);

                this.cycle.push(w);
                this.cycle.push(v);
            }
        }

        this.onStack[v] = false;
    }

    public boolean hasCycle(){
        return this.cycle != null;
    }

    public LinkedList<Integer> cycle(){
        return this.cycle;
    }

}
