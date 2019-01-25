package com.syh.strings;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-1-26
 * Time: 上午5:57
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams zzc = new GroupAnagrams();

        System.out.println(zzc.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }


    public List<List<String>> groupAnagrams(String[] strs) {

        Integer listIndex = 0;
        List<List<String>> resultList = new ArrayList<List<String>>();
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        for(String str: strs){
            char[] newChar = Arrays.copyOf(str.toCharArray(), str.length());
            Arrays.sort(newChar);

            String newStr = Arrays.toString(newChar);
            if(resultMap.containsKey(newStr)){
                resultList.get(resultMap.get(newStr)).add(str);
            }
            else{
                List<String> strlist = new ArrayList<String>();
                strlist.add(str);
                resultList.add(strlist);

                resultMap.put(newStr, listIndex);
                listIndex++;
            }
        }

        return resultList;
    }
}
