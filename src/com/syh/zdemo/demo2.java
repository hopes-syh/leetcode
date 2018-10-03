package com.syh.zdemo;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-6-29
 * Time: 下午10:54
 * To change this template use File | Settings | File Templates.
 */
public class demo2 {
    public static void main(String[] args) throws InterruptedException {

        int k = 4;
        System.out.println( (k - 1) >>> 1);

        int n = 10;
        System.out.println( n >>> 1);

        // LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(2);
        // System.out.println(blockingQueue.size());
        // blockingQueue.offer(1);
        // System.out.println(blockingQueue.size());
        //
        // ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(2);
        // arrayBlockingQueue.offer(2);
        //
        // PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<Integer>();
        // priorityBlockingQueue.offer(2);

        // 创建大小为5的线程池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(0);

        for (int i = 0; i < 3; i++) {
            Task worker = new Task("task-" + i);
            // 只执行一次
            // scheduledThreadPool.schedule(worker, 5, TimeUnit.SECONDS);

            // 周期性执行，每5秒执行一次
            scheduledThreadPool.scheduleAtFixedRate(worker, 0,5, TimeUnit.SECONDS);
        }

        Thread.sleep(10000);

        System.out.println("Shutting down executor...");
        // 关闭线程池
        scheduledThreadPool.shutdown();
        boolean isDone;
        // 等待线程池终止
        do {
            isDone = scheduledThreadPool.awaitTermination(1, TimeUnit.DAYS);
            System.out.println("awaitTermination...");
        } while(!isDone);

        System.out.println("Finished all threads");
    }

    static class Task implements Runnable {

        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("name = " + name + ", startTime = " + new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("name = " + name + ", endTime = " + new Date());
        }
    }
}
