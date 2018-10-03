package com.syh.zdemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-7-15
 * Time: 下午4:01
 * To change this template use File | Settings | File Templates.
 */
public class LockSupportDemo {
    private static boolean flag = true;
    private static final Object lock = new Object();
    private static Thread parkedThread;

    public static void main(String[] args) throws Exception {
//        Thread waitThread = new Thread(new Wait(), "Wait Thread");
//        waitThread.start();
//        Thread.sleep(30000);
//        Thread notifyThread = new Thread(new Notify(), "Notify Thread");
//        notifyThread.start();

        /*
         * 创建线程池，最小线程数为2，最大线程数为4，线程池维护线程的空闲时间为3秒，
         * 使用队列深度为4的有界队列，如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，
         * 然后重试执行程序（如果再次失败，则重复此过程），里面已经根据队列深度对任务加载进行了控制。
         */
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        Future<String> f = tpe.submit(new Wait2());

        Thread.sleep(1000);
        String re = f.get();

        System.out.println(Thread.currentThread() + " flag is false. running @ " + re);
//        ExecutorService laodaA = Executors.newFixedThreadPool(7);
    }

    private static class Wait2 implements Callable<String> {
        /*@Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " flag is false. running @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }*/

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread() + " flag is false. running @ " +
                    new SimpleDateFormat("HH:mm:ss").format(new Date()));
            return "2323";
        }
    }

    private static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    System.out.println(Thread.currentThread() + " flag is true. wait @ " +
                            new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    parkedThread = Thread.currentThread();
                    LockSupport.park(parkedThread);
                    System.out.println("wati");
//                    LockSupport.park();
                }
                System.out.println(Thread.currentThread() + " flag is false. running @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    private static class Notify implements Runnable {
        @Override
        public void run() {
//            synchronized (lock) {
            System.out.println(Thread.currentThread() + " hold lock. notify @ " +
                    new SimpleDateFormat("HH:mm:ss").format(new Date()));
            flag = false;
            LockSupport.unpark(parkedThread);
            try {
                Thread.sleep(5000); // Thread.sleep() 不会释放锁
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
//            }
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
