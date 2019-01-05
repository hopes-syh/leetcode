package com.syh.twopointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-1-5
 * Time: 上午11:22
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters zzc = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(zzc.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(zzc.lengthOfLongestSubstring("bbbbb"));
        System.out.println(zzc.lengthOfLongestSubstring("pwwkew"));
        System.out.println(zzc.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {

        int max = 0, n1 = 0, n2 = 0;
        for(int i=0; i<s.length(); i++){
            n2 = i;

            while (true){
                String chat = s.substring(i, i+1);
                String sub = s.substring(n1, n2);
                if(sub.contains(chat)){
                    if(n1<n2)
                        ++n1;
                    else
                        break;
                }
                else{
                    max = Math.max(sub.length()+1, max);
                    break;
                }
            }
        }
        return max;
    }
}
