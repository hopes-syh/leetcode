package com.syh.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-7-21
 * Time: 下午6:21
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("23456"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<String>();
        if("".equals(digits)){
            return results;
        }

        Map<String, String[]> letterMap = new HashMap<String, String[]>();
        letterMap.put("2", new String[]{"a", "b", "c"});
        letterMap.put("3", new String[]{"d", "e", "f"});
        letterMap.put("4", new String[]{"g", "h", "i"});
        letterMap.put("5", new String[]{"j", "k", "l"});
        letterMap.put("6", new String[]{"m", "n", "o"});
        letterMap.put("7", new String[]{"p", "q", "r", "s"});
        letterMap.put("8", new String[]{"t", "u", "v"});
        letterMap.put("9", new String[]{"w", "x", "y", "z"});

        char[] digitArr = digits.toCharArray();
        List<String[]> letterList = new ArrayList<String[]>();
        for(char digit : digitArr){
            letterList.add(letterMap.get(String.valueOf(digit)));
        }

        String result = "";
        doLetterCombinations(results, letterList, letterList.size(), result);

        return results;
    }

    private static String doLetterCombinations(List<String> results, List<String[]> letterList, int size, String result) {
        if(result.length() == size){
            results.add(new String(result));
            return result;
        }

        String[] letters = letterList.get(0);

        for(String letter : letters){
            result += letter;
            result = doLetterCombinations(results, letterList.subList(1, letterList.size()), size, result);

            if(result.length() >= 2){
                result = result.substring(0, result.length() - 1);
            } else {
                result = "";
            }
        }

        return result;
    }
}
