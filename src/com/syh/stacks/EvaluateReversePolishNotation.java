package com.syh.stacks;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation path = new EvaluateReversePolishNotation();

        //System.out.println(path.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(path.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(path.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length <=0){
            return 0;
        }

        String add = "+", substract = "-", multi = "*", division = "/";
        Stack<Integer> nums = new Stack<>();

        String token;
        for(int i=0, size = tokens.length; i<size; i++){
            token = tokens[i];

            if(add.equals(token)){
                Integer v1 = nums.pop(), v2 = nums.pop();
                nums.push(v1 + v2);
            } else if (substract.equals(token)){
                Integer v1 = nums.pop(), v2 = nums.pop();
                nums.push(v2 - v1);
            } else if (multi.equals(token)){
                Integer v1 = nums.pop(), v2 = nums.pop();
                nums.push(v1 * v2);
            } else if (division.equals(token)){
                Integer v1 = nums.pop(), v2 = nums.pop();
                nums.push(v2 / v1);
            } else {
                nums.push(Integer.valueOf(token));
            }
        }

        return nums.pop();
    }
}
