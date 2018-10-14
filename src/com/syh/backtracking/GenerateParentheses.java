package com.syh.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-10-13
 * Time: 下午12:27
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses kuohao = new GenerateParentheses();
        System.out.println(kuohao.generateParenthesis(3));
        System.out.println(kuohao.generateParenthesis(10));
    }

    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<String>();
        if(n <= 0){
            return result;
        }

        dfs(result, n, n, "");
        return result;
    }

    private void dfs(List<String> result, int left, int right, String out) {
        if(left < 0 || right < 0 || right < left){
            return;
        }

        if(left == 0 && right == 0){
            result.add(out);
            return;
        }

        dfs(result, left-1, right, out+"(");
        dfs(result, left, right-1, out+")");
    }
}
