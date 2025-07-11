package com.finger.producerAndconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    private final BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++){
                String massage = "hello to :"+i;
                System.out.println("producer send "+massage);
                queue.put(massage);
                Thread.sleep(100);  // 模拟生产耗时
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

    }
}
