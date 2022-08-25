package com.iris.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: royalvald
 * @Date: 2022/8/25 22:07
 */
//todo fix multi threads bug
@Component
public class RedisUtils {
    @Autowired
    private JedisPool jedisPool;

    ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    public void syncSetKey(String key,String value){
        readWriteLock.writeLock().lock();

    }
}
