package com.hyr;

import java.util.concurrent.atomic.AtomicBoolean;

/*******************************************************************************
 * @date 2018-12-21 下午 1:48
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class Constant {

    public static final AtomicBoolean IS_SHUTDOWN = new AtomicBoolean(false);

    public static Integer CONSUMER_THREAD_NUM = 4; // 消费者线程数

}
