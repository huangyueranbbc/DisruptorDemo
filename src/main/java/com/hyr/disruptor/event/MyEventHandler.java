package com.hyr.disruptor.event;

import com.hyr.disruptor.Main;
import com.hyr.disruptor.Constant;
import com.hyr.disruptor.pb.PbTransfer;
import com.lmax.disruptor.WorkHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*******************************************************************************
 * @date 2018-12-21 上午 11:57
 * @author: <a href=mailto:>黄跃然</a>
 * @Description: 处理数据Handler
 ******************************************************************************/
public class MyEventHandler implements WorkHandler<PvDataEvent> {

    private final static Logger log = LoggerFactory.getLogger(MyEventHandler.class);

    private String consumerName;

    public MyEventHandler(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    /**
     * @param pvDataEvent 消费事件处理
     */
    @Override
    public void onEvent(PvDataEvent pvDataEvent) {
        Long sequence = pvDataEvent.getSequence(); // 序号，声明一个序号，用于跟踪ringbuffer中任务的变化和消费者的消费情况；
        // 测试消费时间
        if (sequence == 0) {
            Main.consumerStart = System.currentTimeMillis();
        }
        if (sequence == 10000000) {
            Main.consumerEnd = System.currentTimeMillis();
            log.info("consumer 10000000 datas. startTime:{} ,endTime:{} ,cost time:{} ", Main.consumerStart, Main.consumerEnd, Main.consumerEnd - Main.consumerStart);
        }
        PbTransfer.PvData pvData = pvDataEvent.getPvData();
        if (Constant.IS_SHUTDOWN.get()) {
            // save data to disk. 模拟保存队列数据到redis 下次取出继续消费
            try {
                File file = new File("data/");

                //if file doesnt exists, then create it
                if (!file.exists()) {
                    boolean isCreate = file.mkdir();
                }
                FileWriter fileWriter = new FileWriter(file.getName() + "/pvDate_" + pvData.getPvid());
                fileWriter.append(pvData.toBuilder().toString());
                fileWriter.flush();
                log.info("save to disk success. index:{} ,sequence:{}", pvData.getIndex(), sequence);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        // 正常消费数据
        log.info("consumer:{} handler event. sequence:{} ,data:{}", getConsumerName(), sequence, pvData.toBuilder());
    }

}
