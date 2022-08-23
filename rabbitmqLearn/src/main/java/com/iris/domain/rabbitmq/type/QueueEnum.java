package com.iris.domain.rabbitmq.type;

import lombok.Getter;

/**
 * @Author: royalvald
 * @Date: 2022/8/23 22:42
 */
@Getter
public enum QueueEnum {
    /**
     * Demo队列
     */
    QUEUE_DEMO("direct-demo", "queue-demo", "key-demo");

    /**
     * 交换名称
     */
    private String exchange;

    /**
     * 队列名称
     */
    private String name;

    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
