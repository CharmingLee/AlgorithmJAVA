package com.ming.test.Digraph;

/**
 * Created by charminglee on 17-10-12.
 */
public class Main {

    public static void main(String[] agr) throws Exception {
            Digraph digraph = new Digraph("/Users/charminglee/Desktop/graph/tinyDG.txt");
            DirectedDFS dfs = new DirectedDFS(digraph, 2);

        for (int i = 0; i < digraph.getV(); i++) {
            if (dfs.marked(i))
                System.out.println(i);
        }
    }

}
