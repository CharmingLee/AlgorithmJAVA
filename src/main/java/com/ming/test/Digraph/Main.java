package com.ming.test.Digraph;

/**
 * Created by charminglee on 17-10-12.
 */
public class Main {

    public static void main(String[] agr) throws Exception {
            Digraph digraph = new Digraph("");
            DepthFirstPath dp = new DepthFirstPath(digraph, 0);
        Iterable<Integer> integers = dp.PathTo(11);

        for (int i : integers) {
            System.out.println(i);
        }
    }

}
