package com.wl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class RedisCacheImpl implements ICache {
    private static Logger logger = LoggerFactory.getLogger(ICache.class);

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisCacheImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean exists(String key) {
        Boolean has = stringRedisTemplate.hasKey(key);
        return has!=null && has;
    }

    @Override
    public String get(String key) {
        return Objects.requireNonNull(stringRedisTemplate.opsForValue().get(key));
    }

    @Override
    public boolean set(String key, String value, int expireTime) {
        boolean result = false;
        try {
            stringRedisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            logger.error("redis set ( {} : {} : {} ) error", key, value, expireTime, e);
        }
        return result;
    }

    @Override
    public boolean set(String key, String value) {
        boolean result = false;
        try {
            stringRedisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            logger.error("redis set ( {} : {} ) error", key, value, e);
        }
        return result;
    }

    @Override
    public boolean del(String key) {
        boolean result = false;
        try {
            if (exists(key)) {
                stringRedisTemplate.delete(key);
            }
            result = true;
        } catch (Exception e) {
            logger.error("redis del ( {} ) error", key, e);
        }
        return result;
    }
}
