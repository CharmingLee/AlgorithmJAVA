package com.ming.test.Digraph;

/**
 * Created by charminglee on 17-10-12.
 */
public class Main {

    public static void main(String[] agr) throws Exception {
            Digraph digraph = new Digraph("/Users/charminglee/Desktop/graph/tinyDG.txt");
            DepthFirstPath dp = new DepthFirstPath(digraph, 9);
        Iterable<Integer> integers = dp.PathTo(12);

        for (int i : integers) {
            System.out.println(i);
        }
    }

}
