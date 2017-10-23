package com.ming.test.Digraph;

/**
 * Created by charminglee on 17-10-12.
 */
public class Main {

    public static void main(String[] agr) throws Exception {
        Digraph digraph = new Digraph("/home/charminglee/Desktop/图/tinyDG.txt");
        KosarajuSCC kosarajuSCC = new KosarajuSCC(digraph);

    }

}
