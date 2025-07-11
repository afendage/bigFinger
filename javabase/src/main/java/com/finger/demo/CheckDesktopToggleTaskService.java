package com.finger.demo;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 检查桌台切换任务类
 */
public class CheckDesktopToggleTaskService {

    //单列模式的 scheduler
    private final ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1);

    /**
     * 检查-数据库桌台切换状态是否更新-非成功则每10秒发送一次MQ请求，完成则关闭任务
     */
    public void startRetryTask() {
        //间隔时间
        int PERIOD = 10;
        scheduler.scheduleAtFixedRate(() -> {
            // 模拟接口请求逻辑
            System.out.println("执行接口请求: " + System.currentTimeMillis());
            // 获取数据库-切换状态
            // 模拟请求成功
            boolean success = Math.random() > 0.7;
            if (success) {
                System.out.println("请求成功，停止定时任务");
                shutdown();
            }else{
                // 设置一个幂等性的ID
                // dto.setMessageId()
                // 发送 MQ
                //mqService.sendMQToEnvTopic(dto);
            }
        }, 0, PERIOD, TimeUnit.SECONDS);
    }

    /**
     * 停止任务
     */
    public void shutdown() {
        scheduler.shutdown();
    }

    public static void main(String[] args) {
        CheckDesktopToggleTaskService task = new CheckDesktopToggleTaskService();
        task.startRetryTask();
    }
}
