package com.hyr.disruptor;

import com.hyr.Constant;
import com.hyr.Queue;
import com.hyr.disruptor.consumer.Consumer;
import com.hyr.disruptor.event.PvDataEvent;
import com.hyr.disruptor.exception.handler.MyExceptionHandler;
import com.hyr.disruptor.produce.Producer;
import com.lmax.disruptor.RingBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static long consumerStart;
    public static long consumerEnd;

    private static final ExecutorService consumerPool = Executors.newFixedThreadPool(8, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("consumer-thread" + thread.getId());
            return thread;
        }
    });

    /**
     * java -jar DisruptorDemo.jar 8
     * @param args
     */
    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            Constant.CONSUMER_THREAD_NUM = Integer.valueOf(args[0]);
        }

        addShutDownHook();

        // 启动多个线程消费
        CountDownLatch countDownLatch = new CountDownLatch(1);
        consumerPool.execute(new Consumer(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Queue.disruptor.setDefaultExceptionHandler(new MyExceptionHandler()); // 自定义异常处理
        RingBuffer<PvDataEvent> ringBuffer = Queue.disruptor.start();

        // 多生产者模式 2个生产者 每个生产者生产500万数据
        new Thread(new Producer("Producer1", ringBuffer)).start();
        new Thread(new Producer("Producer2", ringBuffer)).start();

        // 测试Shutdown Hook
        //        try {
        //            Thread.sleep(5000);
        //            log.info("start shut down");
        //            System.exit(0);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
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
