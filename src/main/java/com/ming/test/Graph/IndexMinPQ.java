package com.ming.test.Graph;

import java.util.TreeMap;

/**
 * Created by charminglee on 17-10-30.
 */
public class IndexMinPQ<K, V extends Comparable<? super V>> extends TreeMap<K , V> {

    public K delMin(){
        K min = null;
        for (K k : super.keySet()) {
            if (min == null){
                min = k;
            } else {
                if (get(min).compareTo(get(k)) > 0)
                    min = k;
            }
        }

        remove(min);

        return min;
    }
}
