package com.iris.domain.rabbitmq.config;

import com.iris.domain.rabbitmq.type.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: royalvald
 * @Date: 2022/8/23 22:44
 */
@Configuration
public class RabbitMqConfig { /**
 * DEMO队列
 */
@Bean
public Queue demoQueue() {
    return new Queue(QueueEnum.QUEUE_DEMO.getName(), true);
}

    /**
     * DEMO交换机
     */
    @Bean
    DirectExchange demoExchange() {
        return new DirectExchange(QueueEnum.QUEUE_DEMO.getExchange());
    }

    /**
     * 将DEMO队列与DEMO交换机绑定,设置匹配routeKey
     */
    @Bean
    Binding demoBinding() {
        return BindingBuilder.bind(demoQueue()).to(demoExchange()).with(QueueEnum.QUEUE_DEMO.getRouteKey());
    }

}
