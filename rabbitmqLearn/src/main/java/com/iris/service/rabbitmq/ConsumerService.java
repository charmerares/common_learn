package com.iris.service.rabbitmq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: royalvald
 * @Date: 2022/8/23 22:52
 */
@Component
@Slf4j
@RabbitListener(queues = "queue-demo")
public class ConsumerService {

    @RabbitHandler
    public void process(String msg, @Header(AmqpHeaders.DELIVERY_TAG)long tag, Channel channel) throws IOException {
        log.info("从MQ队列拿到的消息" + msg);
//        channel.basicAck(tag,false);
    }
}
