package com.ming.test;

import com.ming.test.Graph.EdgeWeightedGraph;
import com.ming.test.Graph.KruskaMST;
import com.ming.test.UnionFind.QuickUnion;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {

    public static void main(String[] arg) throws IOException {
        FileInputStream fin = new FileInputStream("/home/charminglee/Desktop/图/tinyEWG.txt");
        EdgeWeightedGraph g = new EdgeWeightedGraph(fin);
        KruskaMST mst = new KruskaMST(g);
        System.out.println(mst.weight());
    }


}