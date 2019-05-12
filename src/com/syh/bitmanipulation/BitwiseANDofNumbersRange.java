package com.syh.bitmanipulation;

public class BitwiseANDofNumbersRange {
    public static void main(String[] args) {
        BitwiseANDofNumbersRange b = new BitwiseANDofNumbersRange();

        System.out.println(b.rangeBitwiseAnd(0, 1));
        System.out.println(b.rangeBitwiseAnd(5, 7));
    }

    public int rangeBitwiseAnd(int m, int n) {

        int loopTime = 0;
        while (m != n){
            m = m >> 1;
            n = n >> 1;
            ++loopTime;
        }

        return m << loopTime;
    }
}
