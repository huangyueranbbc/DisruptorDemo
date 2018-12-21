# Disruptor Demo

Study Disruptor Demo

Disruptor是一个开源的Java框架，它被设计用于在生产者—消费者（producer-consumer problem，简称PCP）问题上获得尽量高的吞吐量（TPS）和尽量低的延迟。Disruptor是LMAX在线交易平台的关键组成部分，LMAX平台使用该框架对订单处理速度能达到600万TPS，除金融领域之外，其他一般的应用中都可以用到Disruptor，它可以带来显著的性能提升。其实Disruptor与其说是一个框架，不如说是一种设计思路，这个设计思路对于存在“并发、缓冲区、生产者—消费者模型、事务处理”这些元素的程序来说，Disruptor提出了一种大幅提升性能（TPS）的方案。



com.hyr.disruptor.demo

实现生产者消费者模式，消费者通过多线程进行消费。

程序停止会终止生产者从缓存队列取出数据进行，并通知消费者将程序终止后还未处理的数据保存，避免程序停止导致数据丢失。

Disruptor和BlockQueue比较

BlockQueue:  188/1,000,000 = 5,319,000

Disruptor:   24/1,000,000 = 41,666,000

学习更新中......










