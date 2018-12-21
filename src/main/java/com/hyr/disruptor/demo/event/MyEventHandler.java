package com.hyr.disruptor.demo.event;

import com.hyr.disruptor.demo.Constant;
import com.hyr.disruptor.demo.vo.PvData;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*******************************************************************************
 * @date 2018-12-21 上午 11:57
 * @author: <a href=mailto:>黄跃然</a>
 * @Description: 处理数据Handler
 ******************************************************************************/
public class MyEventHandler implements WorkHandler<PvData> {

    private String consumerName;

    public MyEventHandler(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    /**
     *
     * @param pvData       消费到的数据
     */
    @Override
    public void onEvent(PvData pvData) throws Exception {
        if(Constant.IS_SHUTDOWN.get()){
            // save data to disk. 模拟保存队列数据到redis 下次取出继续消费
            try {
                File file =new File("data/");

                //if file doesnt exists, then create it
                if(!file.exists()){
                    boolean isCreate = file.mkdir();
                }
                FileWriter fileWriter = new FileWriter(file.getName()+"/pvDate_"+pvData.getPvid());
                fileWriter.append(pvData.toString());
                fileWriter.flush();
                System.out.println("save to disk success. index:"+pvData.getNum());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        System.out.println(Thread.currentThread().getName()+" -- get data:"+pvData.toString());
    }
}
