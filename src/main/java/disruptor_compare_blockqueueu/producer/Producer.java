package disruptor_compare_blockqueueu.producer;

import com.hyr.Queue;
import com.hyr.disruptor.thread.QuartzJob;
import disruptor_compare_blockqueueu.vo.PvData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*******************************************************************************
 * @date 2018-12-25 上午 10:26
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class Producer implements QuartzJob {

    private final static Logger log = LoggerFactory.getLogger(com.hyr.disruptor.produce.Producer.class);

    private String producerName;
    private int count;

    public Producer(int count, String producerName) {
        this.count = count;
        this.producerName = producerName;
    }

    @Override
    public void run() {
        long index = 0;
        while (index < count) {
            //long startN=System.nanoTime();
            long seq = Queue.ringBuffer.next();//申请下一个缓冲区Slot
            PvData pvData = Queue.ringBuffer.get(index);
            pvData.setIndex(index);

            Queue.ringBuffer.publish(seq);//发布，然后消费者可以读到

            //long endN=System.nanoTime();
            //log.info("produce cost time:{}",endN-startN); // 测试生产耗时 如果生产耗时过长 会导致效率低
            index++;
        }
    }
}
