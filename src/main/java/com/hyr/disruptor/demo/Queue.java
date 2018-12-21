package com.hyr.disruptor.demo;

import com.hyr.disruptor.demo.thread.MyThreadFactory;
import com.hyr.disruptor.demo.event.MyEventFactory;
import com.hyr.disruptor.demo.vo.PvData;
import com.lmax.disruptor.dsl.Disruptor;

/*******************************************************************************
 * @date 2018-12-21 上午 11:26
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class Queue {

    // Preallocate RingBuffer with 1024 ValueEvents
    public static Disruptor<PvData> disruptor = new Disruptor<PvData>(new MyEventFactory(), getRingBufferSize(1024), new MyThreadFactory("MyThreadFactory"));

    //获取RingBuffer的缓冲区大小（2的幂次！加速计算）
    private static int getRingBufferSize(int num)
    {
        int s = 2;
        while ( s < num )
        {
            s <<= 1;
        }
        return s;
    }

}
