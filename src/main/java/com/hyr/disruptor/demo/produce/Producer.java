package com.hyr.disruptor.demo.produce;

import com.hyr.disruptor.demo.Constant;
import com.hyr.disruptor.demo.thread.QuartzJob;
import com.hyr.disruptor.demo.vo.PvData;
import com.lmax.disruptor.RingBuffer;

import java.util.UUID;

/*******************************************************************************
 * @date 2018-12-21 上午 11:28
 * @author: <a href=mailto:>黄跃然</a>
 * @Description: 生产者
 ******************************************************************************/
public class Producer implements QuartzJob {

    private RingBuffer<PvData> ringBuffer; // queue

    public Producer(RingBuffer<PvData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void run() {

        long index=0;
        String name = Thread.currentThread().getName();
        while(!Constant.IS_SHUTDOWN.get()){
            index++;
            String uuid = UUID.randomUUID().toString();
            long seq = ringBuffer.next();
            PvData pvData = ringBuffer.get(seq);
            pvData.setPvid(uuid);
            pvData.setContent(name);
            pvData.setNum(index);
            ringBuffer.publish(seq);
            System.out.println("produce data...... index:"+index);
        }
    }
}
