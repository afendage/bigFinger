package com.finger.producerAndconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private final BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true){
                String message = (String) queue.take();
                System.out.println("Consumer get massage:"+message);
                Thread.sleep(200);  // 模拟消费耗时
                // 消费完10个数据后退出（仅用于演示）
                if (message.contains("9")) break;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


    }
}
