package com.syh.zdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-6-29
 * Time: 下午10:54
 * To change this template use File | Settings | File Templates.
 */
public class demo implements Runnable{
    private final static Semaphore mutex = new Semaphore(1);
    public static ReentrantLock lock=new ReentrantLock();
    public static int i=0;
    @Override
    public void run() {
        for(int j=0;j<10000000;j++){
            lock.lock();
            //支持重入锁
            lock.lock();
            try{
                i++;
            }finally{
                //执行两次解锁
                lock.unlock();
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        // CountDownLatch down = new CountDownLatch(2);
        // Condition producer_con = lock.newCondition();



        demo tl=new demo();
        Thread t1=new Thread(tl);
        Thread t2=new Thread(tl);
        t1.start();t2.start();
        t1.join();t2.join();
        //输出结果：20000000
        System.out.println(i);

        ThreadLocal<String> localName = new ThreadLocal();
        localName.set("占小狼");
        String name = localName.get();
        mutex.acquire();
        mutex.release();
    }
}
