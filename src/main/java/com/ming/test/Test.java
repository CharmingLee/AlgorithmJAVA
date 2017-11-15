package com.ming.test;

import com.ming.test.Digraph.DijkstraSP;
import com.ming.test.Digraph.EdgeWeightedDigraph;

import java.io.IOException;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {

    public static void main(String[] arg) throws IOException {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph("/home/charminglee/Desktop/图/tinyEWD.txt");
        DijkstraSP sp = new DijkstraSP(g, 0);
        System.out.println(sp.pathTo(6));
    }

}