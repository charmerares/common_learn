package com.iris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author: royalvald
 * @Date: 2022/8/25 20:55
 */
@Service
public class ConsumerService {
    @Autowired
    private JedisPool jedisPool;

    public String testGet(String key){
        Jedis jedis=jedisPool.getResource();
        return jedis.get(key);
    }
}
