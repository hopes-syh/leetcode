package com.syh.maths;


/**
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber r = new PalindromeNumber();

        System.out.println(121 % 1000 / 100);
        System.out.println(121 % 100 / 10);
        System.out.println(121 % 10);
        System.out.println(6 / 2);

        System.out.println(r.isPalindrome(0));
        System.out.println(r.isPalindrome(121));
        System.out.println(r.isPalindrome(-121));
        System.out.println(r.isPalindrome(1221));
        System.out.println(r.isPalindrome(12122121));
        System.out.println(r.isPalindrome(12321));
        System.out.println(r.isPalindrome(14321));
    }

    public boolean isPalindrome(int x) {
         if(x < 0){
             return false;
         }
         int len = length(x);

         int base = 10, loop = 1;
         do{
             int r = x % (int) Math.pow(base, loop);
             r = r / (loop-1 == 0 ? 1 : (int) Math.pow(base, loop-1));
             int l = (int) (x % Math.pow(base, len+1-loop));
             l = l / (int) Math.pow(base, len-loop);

             if(r != l) return false;
             loop++;
         } while (loop <= (len / 2));

         return true;
    }

    public int length(int num) {
        if(num<10){
            return 1;
        }

        int count=0; //计数
        while(num>=1){
            num/=10;
            count++;
        }
        return count;
    }
}
