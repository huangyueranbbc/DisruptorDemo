package disruptor_compare_blockqueueu;

import disruptor_compare_blockqueueu.consumer.Consumer;
import disruptor_compare_blockqueueu.producer.Producer;
import disruptor_compare_blockqueueu.vo.PvData;

import java.text.DecimalFormat;
import java.util.concurrent.LinkedBlockingQueue;

/*******************************************************************************
 * @date 2018-12-25 上午 10:53
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class Main {
    public static int count = 10000000;

    public static void main(String[] args) throws Exception {
        testBlocingQueue();

        Thread producer = new Thread(new Producer(count, "Producer1"));
        Thread consumer = new Thread(new Consumer());

        long timeStart = System.currentTimeMillis();//统计时间
        producer.start();
        consumer.start();
        consumer.join();
        producer.join();
        long timeEnd = System.currentTimeMillis();
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
        System.out.println((timeEnd - timeStart) + "/" + df.format(count) +
                " = " + df.format(count / (timeEnd - timeStart) * 1000));
    }


    //使用LinkedBlockingQueue测试
    public static void testBlocingQueue() throws Exception {
        final LinkedBlockingQueue<PvData> queue = new LinkedBlockingQueue<PvData>(1024);
        Thread producer = new Thread(new Runnable() {//生产者
            @Override
            public void run() {
                try {
                    for (long i = 1; i <= count; i++) {
                        PvData pvData = new PvData();
                        pvData.setIndex(i);
                        queue.put(pvData);//生产
                    }
                } catch (InterruptedException e) {
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {//消费者
            @Override
            public void run() {
                try {
                    PvData pvData = null;
                    for (long i = 1; i <= count; i++) {
                        pvData = queue.take();//消费
                    }
                } catch (InterruptedException e) {
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
        System.out.println((timeEnd - timeStart) + "/" + df.format(count) +
                " = " + df.format(count / (timeEnd - timeStart) * 1000));
    }
}
