package com.ming.test.Digraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by charminglee on 17-10-19.
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private List<Integer> pre;
    private List<Integer> post;
    private LinkedList<Integer> reversePost;

    public DepthFirstOrder(Digraph g){
        this.marked = new boolean[g.getV()];
        this.pre = new ArrayList<>();
        this.post = new ArrayList<>();
        this.reversePost = new LinkedList<>();

        for (int v = 0; v < g.getV(); v++)
            if (!marked[v])
                dfs(g, v);
    }

    private void dfs(Digraph g, int v){
        this.marked[v] = true;
        this.pre.add(v);

        for (Integer w : g.adj(v))
            if (!this.marked[w])
                dfs(g, w);

        this.post.add(v);
        this.reversePost.push(v);

    }

    public List<Integer> getPre() {
        return pre;
    }

    public List<Integer> getPost() {
        return post;
    }

    public LinkedList<Integer> getReversePost() {
        return reversePost;
    }
}
