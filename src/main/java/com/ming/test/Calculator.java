package com.ming.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by charminglee on 17-7-21.
 *
 */
public class Calculator {
    private Map<String,Integer> map;

    public Calculator(){
        map = new HashMap<String, Integer>();
        map.put("+",1);
        map.put("-",1);
        map.put("*",2);
        map.put("/",2);
        map.put("(",0);
        map.put(")",0);
    }

    public Double calculation(String str){
        String conver = conver(str);
        System.out.println(conver);
        Stack<Double> stack = new Stack<Double>();

        for (int i = 0; i < conver.length(); i++) {
            char c = conver.charAt(i);

            if ('+'== c){
                Double pop1 = stack.pop();
                Double pop2 = stack.pop();
                stack.push(pop1 + pop2);
            } else if ('-' == c){
                Double pop1 = stack.pop();
                Double pop2 = stack.pop();
                stack.push(pop2 - pop1);
            } else if ('*' == c){
                Double pop1 = stack.pop();
                Double pop2 = stack.pop();
                stack.push(pop1 * pop2);
            } else if ('/' == c){
                Double pop1 = stack.pop();
                Double pop2 = stack.pop();
                stack.push(pop2 / pop1);
            } else {
                stack.push(Double.valueOf(c + ""));
            }

        }

        return stack.pop();
    }

    //中缀转后缀
    private String conver(String str){
        StringBuffer buffer = new StringBuffer();
        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < str.length(); i++) {
            String num = str.charAt(i) + "";
            Integer integer = map.get(num);

            if (integer == null){
                buffer.append(num);
            }else if ("(".equals(num)){
                stack.push(num);
            } else if(")".equals(num)){
                String popStr = stack.pop();
                while (popStr != null && !"(".equals(popStr)){
                    buffer.append(popStr);
                    popStr = stack.pop();
                }
            } else {
                String popStr = stack.pop();
                Integer popInt = map.get(popStr);

                while ( popStr != null && popInt >= integer ){
                    buffer.append(popStr);
                    popStr = stack.pop();
                    popInt = map.get(popStr);
                }

                if (popStr != null)
                    stack.push(popStr);
                stack.push(num);
            }

        }

        while (stack.hasNext())
            buffer.append(stack.pop());

        return buffer.toString();
    }

}
