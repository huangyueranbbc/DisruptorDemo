package com.hyr.blockqueue;

import com.hyr.Constant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/*******************************************************************************
 * @date 2018-12-24 下午 3:39
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class Main {

    public static long consumerStart;
    public static long consumerEnd;

    public static ExecutorService execute = Executors.newFixedThreadPool(8, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("consumer_" + thread.getId());
            return thread;
        }
    });

    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            Constant.CONSUMER_THREAD_NUM = Integer.valueOf(args[0]);
        }

        // 生产者
        new Thread(new Producer()).start();

        // 消费者
        for (int i = 0; i < Constant.CONSUMER_THREAD_NUM; i++) {
            execute.execute(new Consumer("consumer_" + i));
        }
    }

}
