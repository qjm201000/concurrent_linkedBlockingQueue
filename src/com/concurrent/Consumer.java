package com.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 消费者
 */
public class Consumer extends Thread{
    private LinkedBlockingQueue<Info> linkedBlockingQueue;
    public Consumer(LinkedBlockingQueue<Info> linkedBlockingQueue){
        this.linkedBlockingQueue = linkedBlockingQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Info obj = linkedBlockingQueue.take();
                System.out.println("consumer:"+obj.getI());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
