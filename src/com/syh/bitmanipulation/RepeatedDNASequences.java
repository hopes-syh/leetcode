package com.syh.bitmanipulation;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-9-1
 * Time: 下午12:04
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 */
public class RepeatedDNASequences {

    public static void main(String[] args) {
        RepeatedDNASequences dna = new RepeatedDNASequences();
        System.out.println(dna.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        if(null == s || "".equals(s)){
            return result;
        }

        Set<String> resultSet = new HashSet<String>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int key = 0;
        for(int i=0; i<s.length(); i++){
            key = ((key << 2) | (s.charAt(i) & 0x6)) & 0x1fffff;
            if( i < 9 ) {
                continue;
            }

            if(!map.containsKey(key)){
                map.put(key, 1);
            }
            else{
                resultSet.add(s.substring(i-9, i+1));
                map.put(key, 2);
            }
        }

        result = new ArrayList<String>(resultSet);
        return result;
    }
}
