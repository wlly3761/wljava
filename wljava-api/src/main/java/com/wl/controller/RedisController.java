package com.wl.controller;

import com.wl.cache.RedisCacheService;
import com.wl.returnModel.RespInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private final RedisCacheService redisService;
    @Autowired
    public RedisController(RedisCacheService redisService) {
        this.redisService = redisService;
    }
    @GetMapping("/getKey")
    @PostMapping(value = "/getKey",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespInfo<String> getKey(@Param(value = "key") String key) {
        return redisService.getKey(key);
    }
    @GetMapping("/setKey")
    @PostMapping(value = "/setKey",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespInfo<Boolean> setKey(@Param(value = "key") String key,@Param(value = "value") String value) {
        return redisService.setKey(key,value);
    }
}
