package com.syh.divideandconquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 */
public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        DifferentWaysToAddParentheses d = new DifferentWaysToAddParentheses();

        //System.out.println(d.diffWaysToCompute("2"));
        System.out.println(d.diffWaysToCompute("2-1"));
        System.out.println(d.diffWaysToCompute("2-1-1"));
        System.out.println(d.diffWaysToCompute("2*3-4*5"));
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if(null == input || "".equals(input.trim())){
            return result;
        }

        Map<String, List<Integer>> map = new HashMap<>();
        return help(map, input);
    }

    public List<Integer> help(Map<String, List<Integer>> map, String input) {
        List<Integer> result = new ArrayList<>();
        if(map.containsKey(input)){
            return map.get(input);
        }

        char add='+', sub='-', mul='*';
        if(!input.contains("+") && !input.contains("-") && !input.contains("*")){
            result.add(Integer.valueOf(input));
            map.put(input, result);
            return result;
        }

        char c;
        List<Integer> left, right;
        for(int i=0, size=input.length(); i<size; i++){
            c = input.charAt(i);
            if(c != add && c != sub && c != mul){
                continue;
            }

            left = help(map, input.substring(0, i));
            right = help(map, input.substring(i+1));

            for(Integer l : left){
                for(Integer r : right){
                    if(c == add)
                        result.add(l + r);
                    else if(c == sub)
                        result.add(l - r);
                    else if(c == mul)
                        result.add(l * r);
                }
            }
        }

        map.put(input, result);
        return result;
    }
}
