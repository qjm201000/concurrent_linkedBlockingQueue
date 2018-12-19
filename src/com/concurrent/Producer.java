package com.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者
 */
public class Producer extends Thread{
    private LinkedBlockingQueue<Object> linkedBlockingQueue;
    public Producer(LinkedBlockingQueue<Object> linkedBlockingQueue){
        this.linkedBlockingQueue = linkedBlockingQueue;
    }

    @Override
    public void run() {
        int i = 0;
        while(i<12){
            try {
                System.out.println("currentThead:"+Thread.currentThread().getName()+".producer:"+i);
                linkedBlockingQueue.put(new Info(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
