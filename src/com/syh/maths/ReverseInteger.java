package com.syh.maths;


/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();

        /*System.out.println(r.reverse(0));
        System.out.println(r.reverse(123));
        System.out.println(r.reverse(-123));
        System.out.println(r.reverse(120));
        System.out.println(r.reverse(2147483647));
        System.out.println(r.reverse(-2147483648));*/
        System.out.println(r.reverse(1963847412));
        System.out.println(r.reverse(-1963847412));
        System.out.println(r.reverse(1962847412));
        System.out.println(r.reverse(-1962847412));
    }

    public int reverse(int x) {
        String str = String.valueOf(x);

        int len = str.length();
        int offset = 1;
        char[] rc = new char[len];
        for(int i=0; i<len; i++){
            char c = str.charAt(i);
            if(c == '-'){
                rc[i] = c;
                offset = 0;
                continue;
            }

            rc[len - offset - i] = c;
        }

        String max;
        if(x >= 0)
            max = String.valueOf(Integer.MAX_VALUE);
        else
            max = String.valueOf(Integer.MIN_VALUE);

        if(max.length() == len){
            int flag = 0, preFlag = 0;
            for(int i=0; i<len; i++){
                char nc = rc[i], mc = max.charAt(i);
                if(nc == '-')
                    continue;

                preFlag = Math.min(preFlag, flag);
                if(nc == mc)
                    flag = 0;
                else if(nc < mc)
                    flag = -1;
                else
                    flag = 1;

                if(preFlag == 0 && flag == 1)
                    return 0;
            }
        }

        return Integer.valueOf(new String(rc));
    }
}
