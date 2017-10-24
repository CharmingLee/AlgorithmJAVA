package com.ming.test.Digraph;

/**
 * 定点对的可达性
 * Created by charminglee on 17-10-24.
 */
public class TransitiveClosure {
    private DirectedDFS[] all;

    public TransitiveClosure(Digraph g){
        all = new DirectedDFS[g.getV()];

        for (int v = 0; v < g.getV(); v++)
            all[v] = new DirectedDFS(g, v);
    }

    public boolean reachable(int v, int w){
        if (v > all.length-1 || w > all.length-1)
            return false;

        return all[v].marked(w);
    }

}
