package com.iris.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: royalvald
 * @Date: 2022/8/25 21:26
 */
@Configuration
public class JedisPoolFactory {
    /**
     * redis种第几个库
     */
    @Value("${spring.redis.database:0}")
    private Integer dbNum;
    /**
     * ip
     */
    @Value("${spring.redis.url:localhost}")
    private String host;
    /**
     * 端口
     */
    @Value("${spring.redis.port:6379}")
    private Integer port;

    /**
     * 密码
     */
    @Value("${spring.redis.password}")
    private String password;

    /**
     * 连接超时时间
     */
    @Value("${spring.redis.timeout:3000}")
    private Integer timeout;

    /**
     * 最大连接数
     */
    @Value("${spring.redis.jedis.pool.max-active:20}")
    private Integer maxActive;
    /**
     * 最多维持空闲连接
     */
    @Value("${spring.redis.jedis.pool.max-idle:8}")
    private Integer maxIdle;
    /**
     * 最少维持空闲连接
     */
    @Value("${spring.redis.jedis.pool.min-idle:0}")
    private Integer minIdle;
    /**
     * 连接池出借连接的最长期限
     */
    @Value("${spring.redis.jedis.pool.max-wait:10000}")
    private Long maxWaitMillis;


    @Bean
    public JedisPool generateJedisPoolFactory() {
        if (StringUtils.isEmpty(password)){
            password = null;
        }
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxWaitMillis(maxWaitMillis);
        JedisPool jedisPool = new JedisPool(poolConfig, host, port, timeout, password, dbNum);
        return jedisPool;
    }

}
