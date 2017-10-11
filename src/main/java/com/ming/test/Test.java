package com.ming.test;

import com.ming.test.Graph.BreadthFirstPath;
import com.ming.test.Graph.DepthFirstPath;
import com.ming.test.Graph.Graph;
import com.ming.test.Graph.SysbolGraph;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {

    public static void main(String[] arg) throws IOException {
//        FileInputStream fin = new FileInputStream("/home/charminglee/桌面/routes.txt");
        SysbolGraph sg = new SysbolGraph("/home/charminglee/桌面/routes.txt", " ");
        Graph g = sg.G();
        BreadthFirstPath path = new BreadthFirstPath(g, sg.index("LAS"));

        Iterable<Integer> integers = path.PathTo(sg.index("MCO"));

        for (Integer i : integers) {
            System.out.println(sg.name(i));
        }
    }


}