package com.hyr.disruptor.event;

import com.hyr.disruptor.pb.PbTransfer;

/*******************************************************************************
 * @date 2018-12-24 上午 10:01
 * @author: <a href=mailto:>黄跃然</a>
 * @Description: 原始消息事件
 ******************************************************************************/
public class PvDataEvent {
    private PbTransfer.PvData pvData;

    private Long sequence; // 序号，声明一个序号，用于跟踪ringbuffer中任务的变化和消费者的消费情况；

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public PbTransfer.PvData getPvData() {
        return pvData;
    }

    public void setPvData(PbTransfer.PvData pvData) {
        this.pvData = pvData;
    }
}
