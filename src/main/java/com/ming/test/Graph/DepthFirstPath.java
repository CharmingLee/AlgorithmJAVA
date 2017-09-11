package com.ming.test.Graph;

import java.util.Stack;

/**
 * 深度优先搜索路径
 */
public class DepthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    /**
     *
     * @param g 图数据结构
     * @param s 起点
     */
    public DepthFirstPath(Graph g, int s){
        this.s = s;
        this.marked = new boolean[g.getV()];
        this.edgeTo = new int[g.getV()];

        dfs(g, s);
    }

    private void dfs(Graph g, int v){
        this.marked[v] = true;
        for (int e : g.adj(v)) {
            if (!this.marked[e]){
                this.edgeTo[e] = v;
                dfs(g, e);
            }
        }
    }

    public boolean hasPathTo(int v){
        return this.marked[v];
    }

    public Iterable<Integer> PathTo(int v){
        if (!hasPathTo(v))
            return null;

        Stack<Integer> stack = new Stack<>();
        for (int i = v; i != s; i = this.edgeTo[i]) {
            stack.push(i);
        }
        stack.push(s);
        return stack;
    }

}
