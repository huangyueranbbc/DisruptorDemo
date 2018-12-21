package com.hyr.disruptor.demo;

import com.hyr.disruptor.demo.consumer.Consumer;
import com.hyr.disruptor.demo.produce.Producer;
import com.hyr.disruptor.demo.vo.PvData;
import com.lmax.disruptor.RingBuffer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/*******************************************************************************
 * @date 2018-12-21 上午 11:29
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class Main {

    /********定时批量更新到Redis**********/
    private static final ExecutorService consumerPool = Executors.newFixedThreadPool(8, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("consumer-thread" + thread.getId());
            return thread;
        }
    });

    public static void main(String[] args) {
        addShutDownHook();
        // 启动多个线程消费
        CountDownLatch countDownLatch = new CountDownLatch(1);
        consumerPool.execute(new Consumer(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RingBuffer<PvData> ringBuffer = Queue.disruptor.start();

        // 生产者
        new Thread(new Producer(ringBuffer)).start();

        try {
            Thread.sleep(1000);
            System.out.println("start shut down");
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void addShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Constant.IS_SHUTDOWN) {
                    Constant.IS_SHUTDOWN.set(true);
                    Queue.disruptor.shutdown(); // 停止生产者
                }
            }
        }));
    }

}
