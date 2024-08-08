package com.wl.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 任务调度服务
 */
@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);


    @Scheduled(fixedRate = 5000)
    public void testTask() {
        System.out.println("测试任务调度任务一");
    }
}
