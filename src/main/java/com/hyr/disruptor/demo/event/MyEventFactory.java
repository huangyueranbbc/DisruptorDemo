package com.hyr.disruptor.demo.event;

import com.hyr.disruptor.demo.vo.PvData;
import com.lmax.disruptor.EventFactory;

/*******************************************************************************
 * @date 2018-12-21 上午 11:42
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class MyEventFactory implements EventFactory<PvData> {
    @Override
    public PvData newInstance() {
        return new PvData("1", (long) 1,"1");
    }
}
