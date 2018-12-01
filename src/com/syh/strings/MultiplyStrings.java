package com.syh.strings;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-12-1
 * Time: 上午9:03
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/multiply-strings/description/
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings zzc = new MultiplyStrings();

        System.out.println(zzc.multiply("123", "456"));
        System.out.println(zzc.multiply("12334", "45634"));
        System.out.println(zzc.multiply("123156", "456345"));
    }

    public String multiply(String num1, String num2) {
        String result = "0";
        if("0".equals(num1) || "0".equals(num2)){
            return result;
        }

        int len1 = num1.length(), len2 = num2.length();
        int[] resultArr = new int[num1.length() + num2.length()];
        for(int i=len2-1; i>=0; i--){
            for(int j=len1-1; j>=0; j--){
                int l = (num2.charAt(i)-'0'), r = (num1.charAt(j)-'0');
                int s = l*r;
                if(s>=10){
                    resultArr[i+j] += s/10;
                    resultArr[i+j+1] += s%10;
                }
                else{
                    resultArr[i+j+1] += s;
                }

                if(resultArr[i+j+1] >= 10){
                    int s2 = resultArr[i+j+1];
                    resultArr[i+j] += s2/10;
                    resultArr[i+j+1] = s2%10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean is0 = true;
        for(int i : resultArr){
            if(i == 0 && is0){
                continue;
            }
            is0 = false;
            sb.append(i);
        }

        return sb.toString();
    }
}
