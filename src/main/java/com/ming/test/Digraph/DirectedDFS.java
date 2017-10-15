package com.ming.test.Digraph;

import java.util.List;

/**
 * 路径是否可达
 */
public class DirectedDFS {
    private boolean[] marked;

    /**
     * s 能到达的所有顶点
     * @param g
     * @param s
     */
    public DirectedDFS(Digraph g, int s){
        this.marked = new boolean[g.getV()];
        dfs(g, s);
    }

    /**
     * sources中所有的点能达到的所有顶点
     * @param g
     * @param sources
     */
    public DirectedDFS(Digraph g, List<Integer> sources){
        this.marked = new boolean[g.getV()];
        for (Integer i : sources)
            dfs(g, i);
    }

    private void dfs(Digraph g, int s){
        for (Integer w : g.adj(s))
            this.marked[w] = true;
    }

    public boolean marked(int v){
        return this.marked[v];
    }

}
