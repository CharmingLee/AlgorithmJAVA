package com.ming.test;

import com.ming.test.Graph.EdgeWeightedGraph;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {

    public static void main(String[] arg) throws IOException {
        FileInputStream fin = new FileInputStream("/home/charminglee/Desktop/图/tinyEWG.txt");
        EdgeWeightedGraph graph = new EdgeWeightedGraph(fin);

        System.out.println(graph);
    }


}