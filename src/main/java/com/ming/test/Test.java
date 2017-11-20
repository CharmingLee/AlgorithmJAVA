package com.ming.test;

import com.ming.test.Digraph.Digraph;
import com.ming.test.Digraph.Topological;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {

    public static void main(String[] arg) throws Exception {
        Digraph g = new Digraph("/home/charminglee/Desktop/图/Topological.txt");
        Topological top = new Topological(g);

        System.out.println(top.getOrder());
    }

}