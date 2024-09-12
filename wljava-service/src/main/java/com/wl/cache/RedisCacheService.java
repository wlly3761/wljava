package com.wl.cache;

import com.wl.RedisCacheImpl;
import com.wl.returnModel.RespInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {
    private final    RedisCacheImpl redisCacheImpl;
    @Autowired
    public RedisCacheService(RedisCacheImpl redisCacheImpl) {
        this.redisCacheImpl = redisCacheImpl;
    }

    public RespInfo<String> getKey(String key) {
         String value = redisCacheImpl.get(key);
         if(StringUtils.isEmpty(value)) return RespInfo.error("缓存中没有该key的value");
         return RespInfo.ok("获取缓存成功",value);
    }

    public RespInfo<Boolean> setKey(String key,String value) {
        boolean result= redisCacheImpl.set(key,value);
        if(result) return RespInfo.ok(true);
        else return RespInfo.error("设置缓存失败");
    }
}
