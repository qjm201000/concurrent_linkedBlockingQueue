package com.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * LinkedBlockingQueue
 * 适合 单生产者，单消费者
 *      多生产者，单消费者
 * ConcurrentLinkedQueue
 * 适合 单生产者 ，多消费者
 *      多生产者 ，多消费者
 *
 */
public class Main {
    public static void main(String[] args) {
        //声明队列:队列中只允许最多10条数据，超过等待执行
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);

        //三个生产者
        Producer producer1 = new Producer(linkedBlockingQueue);
        producer1.start();
        Producer producer2= new Producer(linkedBlockingQueue);
        producer2.start();
        Producer producer3= new Producer(linkedBlockingQueue);
        producer3.start();

        //一个消费者
        Consumer consumer = new Consumer(linkedBlockingQueue);
        consumer.start();
    }
}
