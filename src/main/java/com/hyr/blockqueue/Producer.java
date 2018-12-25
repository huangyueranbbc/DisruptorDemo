package com.hyr.blockqueue;

import com.hyr.Queue;
import com.hyr.disruptor.pb.PbTransfer;
import com.hyr.disruptor.thread.QuartzJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*******************************************************************************
 * @date 2018-12-24 下午 3:38
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class Producer implements QuartzJob {

    private final static Logger log = LoggerFactory.getLogger(Producer.class);

    @Override
    public void run() {
        try {
            int index = 0;
            long startTime = System.currentTimeMillis();
            while (index < 10000000) {
                long startN=System.nanoTime();

                PbTransfer.PvData.Builder pvData = PbTransfer.PvData.newBuilder();
                pvData.setIndex(index);
                Queue.blockqueue.put(pvData.build());
                // TODO log.info("produce index:{} data:{}", index, pvData);

                long endN=System.nanoTime();
                //log.info("produce cost time:{}",endN-startN); // 测试生产耗时 如果生产耗时过长 会导致效率低
                index++;
            }
            long endTime = System.currentTimeMillis();
            log.info("produce {} cost time:{}", index, endTime - startTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
