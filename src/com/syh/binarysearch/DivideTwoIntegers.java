package com.syh.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-10-20
 * Time: 下午8:28
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/divide-two-integers/description/
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        DivideTwoIntegers di = new DivideTwoIntegers();

//        System.out.println(di.divide(7, -3));
//        System.out.println(di.divide(10, 3));
//        System.out.println(di.divide(100, 3));
//        System.out.println(di.divide(186, 7));
//        System.out.println(di.divide(-186, 7));
//        System.out.println(di.divide(-2147483648, -1));
//        System.out.println(di.divide(-2147483648, 1));
        System.out.println(di.divide(-2147483648, 2));
    }

    public int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        if(divisor == -1 && dividend == Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }

        boolean isLess0 = dividend<0 ^ divisor<0;
        long dividendLong = Math.abs((long)dividend);
        long divisorLong = Math.abs((long)divisor);
        /*if(dividendLong < divisorLong){
            return 0;
        }*/
        if(dividendLong == divisorLong){
            return isLess0 ? -1 : 1;
        }
        else if(divisorLong == 1){
            return (int) (isLess0 ? 0-dividendLong : dividendLong);
        }

        Integer index = 0;
        Stack<Integer> st = new Stack<Integer>();
        while (true){
            long newDivisor = divisorLong << (index+1);
            if(dividendLong > newDivisor){
                st.add(++index);
            }
            else{
                break;
            }
        }

        long flag = 0, newDivisor = 0, newMod = 0;
        while (!st.empty()){
            flag = st.pop();
            newDivisor += (divisorLong << flag);
            newMod += (1 << flag);

            if(dividendLong < newDivisor){
                newDivisor -= (divisorLong << flag);
                newMod -= (1 << flag);
                break;
            }
        }

        while (true){
            if(newDivisor + divisorLong < dividendLong){
                newDivisor += divisorLong;
                newMod++;
            }
            else if(newDivisor + divisorLong == dividendLong){
                newDivisor += divisorLong;
                newMod++;
                break;
            }
            else{
                break;
            }
        }

        if(isLess0){
            return (int) (0-newMod);
        }
        return (int) newMod;
    }
}
