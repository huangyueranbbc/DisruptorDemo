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
public class Consumer implements QuartzJob {

    private final static Logger log = LoggerFactory.getLogger(Consumer.class);

    private String consumerName;


    public Consumer(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    @Override
    public void run() {
        try {
            consumer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void consumer() throws InterruptedException {
        do {
            PbTransfer.PvData pvData = Queue.blockqueue.take();
            if (pvData.getIndex() == 0) {
                Main.consumerStart = System.currentTimeMillis();
            }
            // TODO log.info("{} consume data:{}", consumerName, pvData.toBuilder());
            if (pvData.getIndex() == 9999999) {
                Main.consumerEnd = System.currentTimeMillis();
                log.info("consumer 10000000 datas. startTime:{} ,endTime:{} ,cost time:{} ", Main.consumerStart, Main.consumerEnd, Main.consumerEnd - Main.consumerStart);
            }
        } while (true);

    }
}
