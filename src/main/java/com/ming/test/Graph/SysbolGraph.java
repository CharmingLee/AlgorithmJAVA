package com.ming.test.Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 符号图
 * Created by charminglee on 17-10-11.
 */
public class SysbolGraph {
    private Map<String, Integer> st;
    private String[] keys;
    private Graph G;

    /**
     *
     * routes.txt
     * @param delim
     * @throws IOException
     */

    public SysbolGraph(String fileName, String delim) throws IOException {
        st = new HashMap<>();
        File file = new File(fileName);
        FileInputStream fin = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader buff = new BufferedReader(reader);
        String line = null;
        buff.mark((int) (file.length() + 1));
        while ( (line = buff.readLine()) != null){
            String[] split = line.split(delim);

            for (String str : split)
                if (!st.containsKey(str))
                    st.put(str, st.size());
        }

        keys = new String[st.size()];
        for (String key : st.keySet())
            keys[st.get(key)] = key;

        G = new Graph(st.size());
        buff.reset();

        while ( (line = buff.readLine()) != null){
            String[] split = line.split(delim);
            G.addEde(st.get(split[0]), st.get(split[1]));
        }

    }

    public boolean contains(String key){
        return st.containsKey(key);
    }

    public Integer index(String key){
        return st.get(key);
    }

    public String name(int index){
        if (index > keys.length - 1)
            return null;

        return keys[index];
    }

    public Graph G(){
        return G;
    }

}
