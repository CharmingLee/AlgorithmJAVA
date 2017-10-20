package com.ming.test.Digraph;

import java.util.Stack;

/**
 * Created by charminglee on 17-10-19.
 */
public class Topological {

    private Stack<Integer> order;

    public Topological(Digraph g){
        DireckedCycle cycle = new DireckedCycle(g);
        if (!cycle.hasCycle()){
            DepthFirstOrder depOrder = new DepthFirstOrder(g);
            order = depOrder.getReversePost();
        }
    }

    public Stack<Integer> getOrder() {
        return order;
    }

    public boolean idDAG(){
        return order != null;
    }
}
