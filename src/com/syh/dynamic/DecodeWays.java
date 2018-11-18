package com.syh.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-11-18
 * Time: 下午1:14
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 */
public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();

//        System.out.println(decodeWays.numDecodings("0"));
//        System.out.println(decodeWays.numDecodings("1"));
//        System.out.println(decodeWays.numDecodings("10"));
//        System.out.println(decodeWays.numDecodings("12"));
//        System.out.println(decodeWays.numDecodings("02"));
//        System.out.println(decodeWays.numDecodings("110"));
//        System.out.println(decodeWays.numDecodings("101"));
//        System.out.println(decodeWays.numDecodings("301"));
//        System.out.println(decodeWays.numDecodings("1001"));
//        System.out.println(decodeWays.numDecodings("1029"));
        System.out.println(decodeWays.numDecodings("12120"));
//        System.out.println(decodeWays.numDecodings("0226"));
//        System.out.println(decodeWays.numDecodings("1231"));
    }

    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0 || s.startsWith("0")){
            return 0;
        }
        if(len == 1){
            return 1;
        }

        int[] dp = new int[len+1];
        dp[0] = 1;

        Integer start = Integer.valueOf(s.substring(0, 2));
        if(start>0 && start<10){
            return 0;
        } else if(start == 10){
            dp[1] = 1;
        } else if(start>10 && start<20){
            dp[1] = 2;
        } else if(start == 20){
            dp[1] = 1;
        } else if(start>20 && start<=26){
            dp[1] = 2;
        }
        else if(start>26 && start%10!=0){
            dp[1] = 1;
        } else {
            return 0;
        }
        if(len == 2){
            return dp[1];
        }

        for(int i=2; i<len; i++){
            String tmpStr = s.substring(i-1, i+1);
            Integer tmpInt = Integer.parseInt(tmpStr);

            if((tmpInt>26 && tmpInt%10!=0) || (tmpInt>0 && tmpInt<10)){
                dp[i] = dp[i-1];
            }else if(tmpInt>10 && tmpInt<=26&& tmpInt!=20){
                dp[i]=dp[i-1]+dp[i-2];
            }else if(tmpInt==10 || tmpInt==20){
                dp[i]=dp[i-2];
            }else if(tmpInt==0 || tmpInt%10==0){
                return 0;
            }
        }
        return dp[s.length()-1];
    }

/*    public int numDecodings(String s) {
        if("".equals(s) || (s.length()<=2 && Integer.valueOf(s)<=0) || s.startsWith("0")){
            return 0;
        }

        Map<String, Integer> resultMap = new HashMap<String, Integer>();

        for(int i=1; i<=s.length(); i++){
            dp(resultMap, s, i);
        }

        return resultMap.get(s);
    }

    private void dp(Map<String, Integer> resultMap, String s, int index) {
        if(s.length()<=1){
            resultMap.put(s, checkNum(s));
            return;
        }

        String preResultKey2 = index-2 < 0? "" : s.substring(0, index-2);

        String nowResultKey = s.substring(0, index);
        if(resultMap.containsKey(nowResultKey)){
            return ;
        }

        Integer preResult2 = resultMap.get(preResultKey2);
        preResult2 = null == preResult2 ? 0 : preResult2;

        String single0 = index-3 < 0? "0"          : s.substring(index-3, index-1);
        String single1 = index-2 < 0? nowResultKey : s.substring(index-2, index-1);
        String single2 = index-2 < 0? ""           : s.substring(index-2, index);

        Integer result1 = (single2.endsWith("0") ? 0 : checkNum(single1));
        Integer result2 = (single2.startsWith("0") ? 0 : checkNum(single2));
        Integer result0 = (single0.startsWith("0") || checkNum(single0) == 0) ? 0 : (single2.endsWith("0") ? 0 : preResult2);
        Integer result = result0 + result1 + result2;
        resultMap.put(nowResultKey, result);
    }

    public int checkNum(String numStr){
        if("".equals(numStr)){
            return 0;
        }

        Integer num = Integer.valueOf(numStr);
        if(num>0 && num<27){
            return 1;
        }

        return 0;
    }*/
}
