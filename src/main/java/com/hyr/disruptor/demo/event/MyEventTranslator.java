package com.hyr.disruptor.demo.event;

import com.hyr.disruptor.demo.vo.PvData;
import com.lmax.disruptor.EventTranslator;

/*******************************************************************************
 * @date 2018-12-21 下午 2:11
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class MyEventTranslator implements EventTranslator<PvData> {

    private PvData pvData;

    public MyEventTranslator(PvData pvData) {
        this.pvData = pvData;
    }

    @Override
    public void translateTo(PvData pvData, long sequence) {
        System.out.println("translateTo pvData:"+pvData.toString()+" sequence:"+sequence);
        pvData = this.pvData;
    }
}
