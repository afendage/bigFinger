package com.finger.threadPool;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义策略线程池
 */
public class ThreadPoolTest {

   @Test
   public void threadPoolExecutorTest(){
       ThreadPoolExecutor executor = new ThreadPoolExecutor(
               10,
               30,
               50000,
               TimeUnit.SECONDS,
               new LinkedBlockingQueue<Runnable>(10),
               new ThreadPoolExecutor.AbortPolicy()
       );
       try {
           for (int i = 0; i < 40; i++) {
               int finalI = i+1;
               executor.execute(()->{
                   System.out.println(Thread.currentThread().getName()+"\t"+ finalI);
               });
           }
       } catch (Exception e) {
           throw new RuntimeException(e);
       } finally {
           executor.shutdown();
       }

   }

}
