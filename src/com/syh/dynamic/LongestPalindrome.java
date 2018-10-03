package com.syh.dynamic;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-6-29
 * Time: 下午10:54
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindrome {

    public static void main(String[] args) {

        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("bb"));

    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int size = 2 * chars.length + 1;

        // 将字符串变成奇数长度的字符串
        char[] newChars = new char[size];
        char spiltStr = '-';
        newChars[0] = spiltStr;
        for (int i = 0; i < size - 1; i++) {
            if (i % 2 == 0) {
                newChars[i] = spiltStr;
            } else {
                newChars[i] = chars[i/2];
            }
        }
        newChars[size - 1] = spiltStr;

        // 查找最大的回文字符串
        int max_len=0, start=0;
        boolean[][] dp = new boolean[newChars.length][newChars.length];
        for(int j = 0; j < size; j++){
            int i=0;
            dp[j][j] = true;
            for(; i<j; i++){

                dp[i][j] = (newChars[j] == newChars[i] && j-i<=1)
                        || (newChars[j] == newChars[i] && j-i>=2 && dp[i+1][j-1]);

                if(dp[i][j]){
                    if(j-i+1 > max_len){
                        max_len = j-i+1;
                        start = i;
                    }
                }
            }
        }

        String newStr = Arrays.toString(newChars).replaceAll(", ", "").replaceAll("\\[", "").replaceAll("]", "");
        return newStr.substring(start+1, start + max_len).replaceAll("-", "");
    }
}
