# Disruptor Java  
  
[![Travis](https://img.shields.io/badge/Disruptor-v3.4.2-green.svg)](https://github.com/huangyueranbbc/DisruptorDemo)  [![Travis](https://img.shields.io/badge/Disruptor-Github-orange.svg)](https://github.com/LMAX-Exchange/disruptor)  [![Travis](https://img.shields.io/badge/Disruptor-LMAX-blue.svg)](http://lmax-exchange.github.io/disruptor/)    

Study Disruptor Demo

    Disruptor是一个开源的Java框架，它被设计用于在生产者—消费者（producer-consumer problem，简称PCP）问题上获得尽量高的吞吐量（TPS）和尽量低的延迟。Disruptor是LMAX在线交易平台的关键组成部分，LMAX平台使用该框架对订单处理速度能达到600万TPS，除金融领域之外，其他一般的应用中都可以用到Disruptor，它可以带来显著的性能提升。其实Disruptor与其说是一个框架，不如说是一种设计思路，这个设计思路对于存在“并发、缓冲区、生产者—消费者模型、事务处理”这些元素的程序来说，Disruptor提出了一种大幅提升性能（TPS）的方案。

===============================================================================

# com.hyr.disruptor

    Usage: java -jar DisruptorDemo.jar TYPE{1|2} <CONSUMER THREAD NUM>


1.实现多生产者多消费者模式。

2.程序停止会终止生产者从缓存队列取出数据进行，并通知消费者将程序终止后还未处理的数据保存，避免程序停止导致数据丢失。

3.增加自定义消费异常处理。

4.测试10000000数据下的处理耗时。

5.增加等待策略。YieldingWaitStrategy

6.采用protobuf协议生产消费数据，创建pb协议:

    cd pb

    makeproto.bat

===============================================================================

# Disruptor和BlockQueue比较

    BlockQueue:  1742ms/10,000,000pv = 5,740,000

    Disruptor:   173ms/10,000,000pv = 57,803,000

===============================================================================

学习更新中......










