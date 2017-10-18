package com.ming.test.Digraph;

/**
 * Created by charminglee on 17-10-12.
 */
public class Main {

    public static void main(String[] agr) throws Exception {
            Digraph digraph = new Digraph("/home/charminglee/桌面/图/tinyDG.txt");
        DireckedCycle dfs = new DireckedCycle(digraph);

        for (Integer v : dfs.cycle()) {
            System.out.println(v);
        }
    }

}
