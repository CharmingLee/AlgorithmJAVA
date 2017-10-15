package com.ming.test.Digraph;

import java.util.Stack;

/**
 * 有向图深度优先搜索
 * Created by charminglee on 17-10-12.
 */
public class DepthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private final int S;

    public DepthFirstPath(Digraph g, int s){
        this.S = s;
        marked = new boolean[g.getV()];
        edgeTo = new int[g.getV()];

        dfs(g, s);
    }

    private void dfs(Digraph g, int v){
        marked[v] = true;
        for (int w : g.adj(v))
            if (!marked[w]){
                edgeTo[w] = v;
                dfs(g, w);
            }
    }

    public boolean hasPathTo(int v){
        if (v > this.marked.length - 1)
            return false;

        return this.marked[v];
    }

    public Iterable<Integer> PathTo(int v){
        if (!hasPathTo(v)){
            return  new Stack<>();
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = v; i != this.S ; i = this.edgeTo[i])
            stack.push(i);

        stack.push(this.S);

        return stack;
    }
}
