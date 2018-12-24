package com.hyr.disruptor.event;

import com.hyr.disruptor.pb.PbTransfer;
import com.lmax.disruptor.EventTranslatorOneArg;

/*******************************************************************************
 * @date 2018-12-21 下午 2:11
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class MyEventTranslator implements EventTranslatorOneArg<PvDataEvent, PbTransfer.PvData> {

    /**
     *
     * @param pvDataEvent   event为从RingBuffer entry中读取的事件内容，消费者从event中读取数据，并完成业务逻辑处理
     * @param sequence  序号，声明一个序号，用于跟踪ringbuffer中任务的变化和消费者的消费情况；
     * @param pvData
     */
    @Override
    public void translateTo(PvDataEvent pvDataEvent, long sequence, PbTransfer.PvData pvData) {
        pvDataEvent.setPvData(pvData);
        pvDataEvent.setSequence(sequence);
    }

}
