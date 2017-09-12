package com.ming.test;

import com.ming.test.Graph.BreadthFirstPath;
import com.ming.test.Graph.Graph;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {

    public static void main(String[] arg) throws IOException {
        FileInputStream fin = new FileInputStream("/home/charminglee/桌面/a.txt");
        Graph g = new Graph(fin);

        BreadthFirstPath path = new BreadthFirstPath(g, 0);
        System.out.println(path.PathTo(6));
    }


}