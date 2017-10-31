package com.ming.test;

import com.ming.test.Graph.EdgeWeightedGraph;
import com.ming.test.Graph.LazyPrimMST;
import com.ming.test.Graph.PrimMST;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {

    public static void main(String[] arg) throws IOException {
        FileInputStream fin = new FileInputStream("/home/charminglee/Desktop/图/tinyEWG.txt");
        EdgeWeightedGraph graph = new EdgeWeightedGraph(fin);
        LazyPrimMST mst = new LazyPrimMST(graph);
        PrimMST mst1 = new PrimMST(graph);

        System.out.println(mst.weight());
        System.out.println(mst1.weight());

    }


}