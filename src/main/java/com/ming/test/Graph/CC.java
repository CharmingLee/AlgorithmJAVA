package com.ming.test.Graph;

/**
 * 连通分量
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph g){
        marked = new boolean[g.getV()];
        id = new int[g.getV()];

        for (int i = 0; i < g.getV(); i++)
            if (!marked[i]) {
                dfs(g, i);
                count++;
            }
    }

    private void dfs(Graph g, int v){
        marked[v] = true;
        id[v] = count;
        for (int w : g.adj(v)) {
            if (!marked[w])
                dfs(g, w);
        }
    }

    public boolean connected(int v, int w){
        if (v > id.length - 1 || w > id.length - 1)
            return false;

        return id[v] == id[w];
    }

    public int count(){
        return count;
    }

    public int id(int v){
        if (v > id.length - 1)
            return -1;

        return id[v];
    }

}
