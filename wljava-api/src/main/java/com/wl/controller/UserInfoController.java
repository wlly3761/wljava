package com.wl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wl.entity.UserInfo;
import com.wl.query.UserInfoQuery;
import com.wl.returnModel.RespInfo;
import com.wl.service.business.IUserInfoService;
import com.wl.vo.UserInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    private final IUserInfoService userInfoService;

    @Autowired
    public UserInfoController(IUserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    /**
     * 获取用户信息
     * @param query
     * @return
     */
    @GetMapping("/getUserInfo")
    public RespInfo<List<UserInfoVO>> getUserInfo(@Param("query") UserInfoQuery query) {
        return userInfoService.getUserInfo(query);
    }
    @PostMapping("/addUserInfo")
    public RespInfo<String> addUserInfo() {
        UserInfo entity = new UserInfo();
        entity.setUserID(new Random().nextLong(500));
        entity.setName("admin");
        entity.setAge("18");
        entity.setEmail("admin@123.com");
        UserInfo entity2=new UserInfo();
        entity2.setUserID(new Random().nextLong(500));
        entity2.setName("admin");
        entity2.setAge("18");
        entity2.setEmail("admin@123.com");
        List<UserInfo> list=new ArrayList<>();
        list.add(entity);
        list.add(entity2);
        userInfoService.saveBatch(list);
        return RespInfo.ok("成功");
    }
    @PostMapping(value = "/updateUserInfo",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespInfo<String> updateUserInfo(@RequestBody List<UserInfo> models) {
        return userInfoService.updateBatchUserInfo(models);
    }
    @PostMapping(value = "/udpateAll")
    public RespInfo<String> udpateAll() {
        return userInfoService.testUpdateAll();
    }
    @PostMapping(value = "/deleteAll")
    public RespInfo<String> deleteAll() {
        return userInfoService.testDeleteAll();
    }
    @PostMapping(value = "/getUserInfoPage",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespInfo<IPage<UserInfoVO>> getUserInfoPage(@RequestBody UserInfoQuery query){
        return userInfoService.getUserInfoPage(query);
    }
}
