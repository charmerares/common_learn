package com.iris.service.rabbitmq;

import com.iris.domain.rabbitmq.type.QueueEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: royalvald
 * @Date: 2022/8/23 22:49
 */
@Service
public class ProviderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void testProvider(){
        rabbitTemplate.convertAndSend(QueueEnum.QUEUE_DEMO.getExchange(), QueueEnum.QUEUE_DEMO.getRouteKey(), "生产者数据DEMO");
    }
}
