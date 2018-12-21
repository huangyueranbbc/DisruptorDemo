package com.hyr.disruptor;

import com.lmax.disruptor.*;

import java.text.DecimalFormat;
import java.util.concurrent.LinkedBlockingQueue;

public class Disruptor_Compare_BlockQueue {

    //待生产的对象个数
    final long objCount = 1000000;
    final long bufSize;//缓冲区大小
    {
        bufSize = getRingBufferSize(objCount);
    }
    
    //获取RingBuffer的缓冲区大小（2的幂次！加速计算）
    static long getRingBufferSize(long num)
    {
        long s = 2;
        while ( s < num )
        {
            s <<= 1;
        }
        return s;
    }
    
    //使用LinkedBlockingQueue测试
    public void testBlocingQueue() throws Exception
    {
        final LinkedBlockingQueue<TestObj> queue = new LinkedBlockingQueue<TestObj>();
        Thread producer = new Thread(new Runnable() {//生产者
            @Override
            public void run() {
                try{
                    for ( long i=1;i<=objCount;i++ )
                    {
                        queue.put(new TestObj(i));//生产
                    }
                }catch ( InterruptedException e ){
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {//消费者
            @Override
            public void run() {
                try{
                    TestObj readObj = null;
                    for ( long i=1;i<=objCount;i++ )
                    {
                        readObj = queue.take();//消费
                        //DoSomethingAbout(readObj);
                    }
                }catch ( InterruptedException e ){
                }
            }
        });
        
        long timeStart = System.currentTimeMillis();//统计时间
        producer.start();
        consumer.start();
        consumer.join();
        producer.join();
        long timeEnd = System.currentTimeMillis();
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
        System.out.println((timeEnd - timeStart) + "/" + df.format(objCount) +
                " = " + df.format(objCount/(timeEnd - timeStart)*1000) );
    }
    
    //使用RingBuffer测试
    public void testRingBuffer() throws Exception
    {
        //创建一个单生产者的RingBuffer，EventFactory是填充缓冲区的对象工厂
        //            YieldingWaitStrategy等"等待策略"指出消费者等待数据变得可用前的策略
        final RingBuffer<TestObj> ringBuffer = RingBuffer.createSingleProducer(new EventFactory<TestObj>() {
            @Override
            public TestObj newInstance() {
                return new TestObj(0);
            }
        } , (int)bufSize, new YieldingWaitStrategy());
        //创建消费者指针
        final SequenceBarrier barrier = ringBuffer.newBarrier();
        
        Thread producer = new Thread(new Runnable() {//生产者
            @Override
            public void run() {
                for ( long i=1;i<=objCount;i++ )
                {
                    long index = ringBuffer.next();//申请下一个缓冲区Slot
                    ringBuffer.get(index).setValue(i);//对申请到的Slot赋值
                    ringBuffer.publish(index);//发布，然后消费者可以读到
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {//消费者
            @Override
            public void run() {
                TestObj readObj = null;
                int readCount = 0;
                long readIndex = Sequencer.INITIAL_CURSOR_VALUE;
                while ( readCount < objCount )//读取objCount个元素后结束
                {
                    try{
                        long nextIndex = readIndex + 1;//当前读取到的指针+1，即下一个该读的位置
                        long availableIndex = barrier.waitFor(nextIndex);//等待直到上面的位置可读取
                        while ( nextIndex <= availableIndex )//从下一个可读位置到目前能读到的位置(Batch!)
                        {
                            readObj = ringBuffer.get(nextIndex);//获得Buffer中的对象
                            //DoSomethingAbout(readObj);
                            readCount++;
                            nextIndex ++;
                        }
                        readIndex = availableIndex;//刷新当前读取到的位置
                    }catch ( Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        long timeStart = System.currentTimeMillis();//统计时间
        producer.start();
        consumer.start();
        consumer.join();
        producer.join();
        long timeEnd = System.currentTimeMillis();
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
        System.out.println((timeEnd - timeStart) + "/" + df.format(objCount) +
                " = " + df.format(objCount/(timeEnd - timeStart)*1000) );
        
    }
    
    public static void main(String[] args) throws Exception {
        Disruptor_Compare_BlockQueue ins = new Disruptor_Compare_BlockQueue();
        //执行测试
        ins.testBlocingQueue();
        ins.testRingBuffer();
    }

    //简单对象：缓冲区中的元素，里面只有一个value，提供setValue
    private class TestObj {

        public long value;

        public TestObj(long value)
        {
            this.value = value;
        }

        public void setValue(long value)
        {
            this.value = value;
        }

    }

}

