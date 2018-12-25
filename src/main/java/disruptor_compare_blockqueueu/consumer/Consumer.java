package disruptor_compare_blockqueueu.consumer;

import com.hyr.Queue;
import com.hyr.disruptor.thread.QuartzJob;
import disruptor_compare_blockqueueu.vo.PvData;
import com.lmax.disruptor.Sequencer;

import static com.hyr.Queue.barrier;

/*******************************************************************************
 * @date 2018-12-25 上午 10:27
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class Consumer implements QuartzJob {
    @Override
    public void run() {
        int readCount = 0;
        long readIndex = Sequencer.INITIAL_CURSOR_VALUE;
        while (readCount < 10000000)//读取objCount个元素后结束
        {
            try {
                long nextIndex = readIndex + 1;//当前读取到的指针+1，即下一个该读的位置
                long availableIndex = barrier.waitFor(nextIndex);//等待直到上面的位置可读取
                while (nextIndex <= availableIndex)//从下一个可读位置到目前能读到的位置(Batch!)
                {
                    PvData pvData = Queue.ringBuffer.get(nextIndex);//获得Buffer中的对象
                    //System.out.println("pvData:" + pvData);
                    readCount++;
                    nextIndex++;
                }
                readIndex = availableIndex;//刷新当前读取到的位置
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
