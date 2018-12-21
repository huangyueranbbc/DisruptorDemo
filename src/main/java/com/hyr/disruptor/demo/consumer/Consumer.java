package com.hyr.disruptor.demo.consumer;

import com.hyr.disruptor.demo.Constant;
import com.hyr.disruptor.demo.Queue;
import com.hyr.disruptor.demo.event.MyEventHandler;
import com.hyr.disruptor.demo.thread.QuartzJob;

import java.util.concurrent.CountDownLatch;

/*******************************************************************************
 * @date 2018-12-21 上午 11:29
 * @author: <a href=mailto:>黄跃然</a>
 * @Description: 消费者
 ******************************************************************************/
public class Consumer implements QuartzJob {

    private CountDownLatch countDownLatch;

    public Consumer(CountDownLatch countDownLatch) {
        this.countDownLatch=countDownLatch;
    }

    public void run() {
        System.out.println("start consumer......");

        MyEventHandler[] myEventHandlers=new MyEventHandler[Constant.CONSUMER_THREAD_NUM];
        // 消费数据
        for(int i=0;i<Constant.CONSUMER_THREAD_NUM;i++){
            myEventHandlers[i]=new MyEventHandler("MyConsummer_"+i);
        }
        Queue.disruptor.handleEventsWithWorkerPool(myEventHandlers);

        countDownLatch.countDown();
    }
}
