package com.ming.test.Digraph;

import java.util.LinkedList;

/**
 * Created by charminglee on 17-10-19.
 */
public class Topological {

    private LinkedList<Integer> order;

    public Topological(Digraph g){
        DireckedCycle cycle = new DireckedCycle(g);
        if (!cycle.hasCycle()){
            DepthFirstOrder depOrder = new DepthFirstOrder(g);
            order = depOrder.getReversePost();
        }
    }

    public LinkedList<Integer> getOrder() {
        return order;
    }

    public boolean idDAG(){
        return order != null;
    }
}
