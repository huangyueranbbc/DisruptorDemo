package com.hyr.disruptor.exception.handler;

import com.hyr.disruptor.event.PvDataEvent;
import com.lmax.disruptor.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*******************************************************************************
 * @date 2018-12-24 下午 2:30
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class MyExceptionHandler implements ExceptionHandler<PvDataEvent> {

    private final static Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);

    @Override
    public void handleEventException(Throwable throwable, long seq, PvDataEvent pvDataEvent) {
        log.error("handle the seq:{} pvDataEvent has error. PvDataEvent:{}", seq, pvDataEvent.getPvData().toBuilder(), throwable);
    }

    @Override
    public void handleOnStartException(Throwable throwable) {
        log.error("handle On Start Exception.", throwable);
    }

    @Override
    public void handleOnShutdownException(Throwable throwable) {
        log.error("handle On Shutdown Exception.", throwable);
    }
}
