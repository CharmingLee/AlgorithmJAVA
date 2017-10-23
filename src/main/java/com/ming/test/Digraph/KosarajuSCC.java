package com.ming.test.Digraph;

/**
 * 有向图强连通分量
 * Created by charminglee on 17-10-23.
 */
public class KosarajuSCC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph g){
        marked = new boolean[g.getV()];
        id = new int[g.getV()];

        DepthFirstOrder order = new DepthFirstOrder(g.reverse());

        for (int v : order.getReversePost()) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }

    }

    private void dfs(Digraph g, int v){
        marked[v] = true;
        id[v] = count;
        for (Integer w : g.adj(v))
            if (!marked[w])
                dfs(g, w);

    }

    public boolean stronglyConnected(int v, int w){
        if (v > id.length-1 || w > id.length-1)
            return false;

        return id[v] == id[w];
    }

    public int count(){
        return count;
    }

    public int id(int v){
        if (v > id.length-1)
            return -1;

        return id[v];
    }

}
