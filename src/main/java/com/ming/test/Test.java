package com.ming.test;

import com.ming.test.Digraph.Bellman_Ford.BellmanFordSP;
import com.ming.test.Digraph.EdgeWeightedDigraph;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {

    public static void main(String[] arg) throws Exception {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph("/home/charminglee/Desktop/图/tinyEWDnc.txt");
        BellmanFordSP sp = new BellmanFordSP(g, 0);

        System.out.println(sp.negativeCycle());
        System.out.println(sp.pathTo(1));

    }

}