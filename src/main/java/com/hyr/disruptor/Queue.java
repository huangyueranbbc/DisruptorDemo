package com.hyr.disruptor;

import com.hyr.disruptor.event.MyEventFactory;
import com.hyr.disruptor.event.PvDataEvent;
import com.hyr.disruptor.thread.MyThreadFactory;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

/*******************************************************************************
 * @date 2018-12-21 上午 11:26
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class Queue {

    /**
     * EventFactory<T>      事件工厂
     * ringBufferSize       Preallocate RingBuffer with 1024 ValueEvents 要求是2的次方
     * ProducerType.SINGLE  单生产者
     * ProducerType.MULTI   多生产者
     * BlockingWaitStrategy 最低效的策略，但其对CPU的消耗最小并且在各种不同部署环境中能提供更加一致的性能表现；
     * SleepingWaitStrategy 性能表现跟 BlockingWaitStrategy 差不多，对 CPU 的消耗也类似，但其对生产者线程的影响最小，适合用于异步日志类似的场景；
     * YieldingWaitStrategy 性能是最好的，适合用于低延迟的系统。在要求极高性能且事件处理线数小于 CPU 逻辑核心数的场景中，推荐使用此策略；例如，CPU开启超线程的特性。
     */
    public static Disruptor<PvDataEvent> disruptor = new Disruptor<PvDataEvent>(new MyEventFactory(), getRingBufferSize(1024), new MyThreadFactory("MyThreadFactory"), ProducerType.MULTI, new YieldingWaitStrategy());

    //获取RingBuffer的缓冲区大小（2的幂次！加速计算）
    private static int getRingBufferSize(int num) {
        int s = 2;
        while (s < num) {
            s <<= 1;
        }
        return s;
    }

}
