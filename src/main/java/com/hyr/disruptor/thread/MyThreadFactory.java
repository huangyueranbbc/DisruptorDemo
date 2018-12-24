package com.hyr.disruptor.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/*******************************************************************************
 * @date 2018-12-21 上午 11:51
 * @author: <a href=mailto:>黄跃然</a>
 * @Description: 自定义Thread Factory
 ******************************************************************************/
public class MyThreadFactory implements ThreadFactory {

    private final static Logger log = LoggerFactory.getLogger(MyThreadFactory.class);

    private long index;
    private String threadFactoryName;
    private List<String> stats;

    public MyThreadFactory(String threadFactoryName) {
        this.threadFactoryName = threadFactoryName;
        stats = new ArrayList<String>();
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, threadFactoryName + "-Thread_" + index);
        index++;
        log.info(String.format("Created thread %d with name %s on %s \n", thread.getId(), thread.getName(), new Date()));
        stats.add(String.format("Created thread %d with name %s on %s \n", thread.getId(), thread.getName(), new Date()));
        return thread;

    }

    public String getStats() {
        StringBuilder buffer = new StringBuilder();
        for (String stat : stats) {
            buffer.append(stat);
        }
        return buffer.toString();
    }
}
