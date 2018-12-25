package com.hyr.disruptor.produce;

import com.hyr.Constant;
import com.hyr.Queue;
import com.hyr.disruptor.event.MyEventTranslator;
import com.hyr.disruptor.event.PvDataEvent;
import com.hyr.disruptor.pb.PbTransfer;
import com.hyr.disruptor.thread.QuartzJob;
import com.lmax.disruptor.RingBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.UUID;

/*******************************************************************************
 * @date 2018-12-21 上午 11:28
 * @author: <a href=mailto:>黄跃然</a>
 * @Description: 生产者 每个生产者生产500万数据
 ******************************************************************************/
public class Producer implements QuartzJob {

    private final static Logger log = LoggerFactory.getLogger(Producer.class);


    private String producerName;

    //生产者持有RingBuffer实例，可以直接向RingBuffer实例中的entry写入数据
    private RingBuffer<PvDataEvent> ringBuffer; // queue

    public Producer(String producerName, RingBuffer<PvDataEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
        this.producerName = producerName;
    }

    public void run() {
        long start = System.currentTimeMillis();

        long index = 0;
        String name = Thread.currentThread().getName();
        while (!Constant.IS_SHUTDOWN.get() && index < 5000000) {
            long startN = System.nanoTime();

            // String uuid = UUID.randomUUID().toString(); // FIXME 该操作会导致生产时间过长 效率变低

            PbTransfer.PvData.Builder pvData = PbTransfer.PvData.newBuilder();
            ringBuffer.publishEvent( new MyEventTranslator(), pvData.build());

//            long seq = ringBuffer.next(); // 当前生产下标
//            PvDataEvent pvDataEvent = ringBuffer.get(seq);
//            PbTransfer.PvData.Builder pvData = PbTransfer.PvData.newBuilder();
//            pvDataEvent.setPvData(pvData.build());
//            pvDataEvent.setSequence(seq);
//            ringBuffer.publish(seq);

            long endN = System.nanoTime();
            //log.info("produce cost time:{}",endN-startN); // 测试生产耗时 如果生产耗时过长 会导致效率低

            // TODO log.info("producer:{} produce data... pvid:{} index:{} ,monitorTime:{}", producerName, pvData.getPvid(), index, pvData.getMonitorTime());
            index++;
        }
        long end = System.currentTimeMillis();
        log.info("producer:{} produce {} datas. start:{} end:{} cost time:{}", producerName, index, start, end, end - start);
    }
}
