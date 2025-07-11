package com.finger.producerAndconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueTest {

    /**
     * 生产消费者模式-测试
     * 使用 BlockingQueue来实现，因为 BlockingQueue 内部已经实现了线程同步机制，无需我们手动处理同步问题。相比传统使用 wait()/notify()，BlockingQueue 提供了更高级的抽象，代码更简洁可靠，并提供了多种实现（如 ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue 等）适应不同场景
     * 实现步骤: 1. 生产者通过 BlockingQueue.put 生产消息。 2. 消费者通过 BlockingQueue.take 获取消息
     * @param args
     */
    public static void main(String[] args) {
         BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
         Thread producerThread = new Thread(new Producer(queue));
         Thread consumerThread = new Thread(new Consumer(queue));
         producerThread.start();
         consumerThread.start();
    }

}
