package com.hyr.disruptor.event;

import com.lmax.disruptor.EventFactory;

/*******************************************************************************
 * @date 2018-12-21 上午 11:42
 * @author: <a href=mailto:>黄跃然</a>
 * @Description: 事件工厂
 ******************************************************************************/
public class MyEventFactory implements EventFactory<PvDataEvent> {
    @Override
    public PvDataEvent newInstance() {
        return new PvDataEvent();
    }
}
