package com.ming.test;

import java.io.*;

/**
 * Created by charminglee on 17-7-18.
 */
public class Test {

    public static void main(String[] arg) throws IOException {
//        File f = new File("/Users/charminglee/Desktop/a.txt");
        FileInputStream fin = new FileInputStream("/Users/charminglee/Desktop/a.txt");
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader buff = new BufferedReader(reader);
        String line = buff.readLine();
        while (line != null){
            System.out.println(line);
            line = buff.readLine();
        }

        buff.close();
        reader.close();
        fin.close();
    }


}