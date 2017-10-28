package com.ming.test;

import com.ming.test.Graph.EdgeWeightedGraph;
import com.ming.test.Graph.LazyPrimMST;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {

    public static void main(String[] arg) throws IOException {
        FileInputStream fin = new FileInputStream("/home/charminglee/Desktop/图/tinyEWG.txt");
        EdgeWeightedGraph graph = new EdgeWeightedGraph(fin);
        LazyPrimMST mst = new LazyPrimMST(graph);

        System.out.println(mst.weight());
    }


}