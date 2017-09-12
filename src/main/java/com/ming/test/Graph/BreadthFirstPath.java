package com.ming.test.Graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 广度优先路径搜索
 */
public class BreadthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPath(Graph g, int s){
        this.s = s;
        this.marked = new boolean[g.getV()];
        this.edgeTo = new int[g.getV()];

        bfs(g, s);
    }

    private void bfs(Graph g, int v){
        LinkedList<Integer> queue = new LinkedList<>();
        this.marked[v] = true;
        queue.addLast(v);

        while (!queue.isEmpty()){
            Integer pop = queue.pop();
            for (int w: g.adj(pop)) {
                if (!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = pop;
                    queue.addLast(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        if (v > marked.length)
            return false;
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
