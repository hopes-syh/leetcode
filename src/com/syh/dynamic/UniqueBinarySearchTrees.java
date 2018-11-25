package com.syh.dynamic;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-11-25
 * Time: 下午3:08
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees/description/
 */
public class UniqueBinarySearchTrees {


    public static void main(String[] args) {
        UniqueBinarySearchTrees st = new UniqueBinarySearchTrees();

        System.out.println(st.numTrees(2));
        System.out.println(st.numTrees(3));
        System.out.println(st.numTrees(4));
        System.out.println(st.numTrees(5));
    }

    public int numTrees(int n){
        int[] results = new int[n];
        return numTrees(n, results);
    }

    public int numTrees(int n, int[] results) {
        int result = 0;
        if(n<=1){
            return 1;
        }
        if(results[n-1] != 0){
            return results[n-1];
        }

        int maxVal = n-1;
        for(int left=0; left<=maxVal; left++){
            int right = maxVal-left;
            if(right < left){
                break;
            }

            if(left != right){
                result += 2 * numTrees(left) * numTrees(right);
            }
            else {
                result += numTrees(left) * numTrees(right);
            }
        }

        if(results[n-1] == 0){
            results[n-1] = result;
        }
        return result;
    }
}
