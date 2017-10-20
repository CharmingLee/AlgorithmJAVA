package com.ming.test.Digraph;

import java.lang.management.GarbageCollectorMXBean;

/**
 * Created by charminglee on 17-10-12.
 */
public class Main {

    public static void main(String[] agr) throws Exception {
        Digraph digraph = new Digraph("/home/charminglee/Desktop/图/Topological1.txt");
        Topological topological = new Topological(digraph);

        DireckedCycle cycle = new DireckedCycle(digraph);
        if (cycle.hasCycle()){
            for (Integer i : cycle.cycle()) {
                System.out.println(i);
            }
        }

        if (topological.idDAG()){
            for (Integer i : topological.getOrder()) {
                System.out.println(i);
            }
        }

    }

}
