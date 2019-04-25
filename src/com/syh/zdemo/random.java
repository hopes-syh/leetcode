package com.syh.zdemo;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-6-29
 * Time: 下午10:54
 * To change this template use File | Settings | File Templates.
 */
public class random{
    public static void main(String[] args) throws InterruptedException {
        int x = 0;

        int n = 10;
        x^=(x&(1<<n)) ^ (1<<n);
        System.out.println(x);

        System.out.println((x>>8) & 1);
    }
}
