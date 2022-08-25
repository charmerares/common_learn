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
public class ProviderService {
    @Autowired
    private JedisPool jedisPool;

    public String testSet(String key, String value){
        Jedis jedis=null;
        jedis=jedisPool.getResource();
        return jedis.set(key,value);
    }
}
