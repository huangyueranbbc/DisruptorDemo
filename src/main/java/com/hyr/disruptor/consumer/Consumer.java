package com.hyr.disruptor.consumer;

import com.hyr.disruptor.Constant;
import com.hyr.disruptor.Queue;
import com.hyr.disruptor.event.MyEventHandler;
import com.hyr.disruptor.thread.QuartzJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.awt.geom.AreaOp;

import java.util.concurrent.CountDownLatch;

/*******************************************************************************
 * @date 2018-12-21 上午 11:29
 * @author: <a href=mailto:>黄跃然</a>
 * @Description: 消费者
 ******************************************************************************/
public class Consumer implements QuartzJob {

    private final static Logger log = LoggerFactory.getLogger(Consumer.class);

    private CountDownLatch countDownLatch;

    public Consumer(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        try {
            log.info("start consumer......");

            MyEventHandler[] myEventHandlers = new MyEventHandler[Constant.CONSUMER_THREAD_NUM];
            // 消费数据
            for (int i = 0; i < Constant.CONSUMER_THREAD_NUM; i++) {
                myEventHandlers[i] = new MyEventHandler("MyConsummer_" + i);
            }
            Queue.disruptor.handleEventsWithWorkerPool(myEventHandlers);

            countDownLatch.countDown();
        } catch (Exception e) {
            log.error("consumer run has error.", e);
        }
    }
}
