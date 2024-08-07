package com.wl.service.userInfo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wl.entity.UserInfo;
import com.wl.query.UserInfoQuery;
import com.wl.returnModel.RespInfo;
import com.wl.vo.UserInfoVO;

import java.util.List;

public interface IUserInfoService extends IService<UserInfo> {
    RespInfo<List<UserInfoVO>> getUserInfo(UserInfoQuery query);

    RespInfo<String> updateBatchUserInfo(List<UserInfo> userInfoList);

    RespInfo<String> testUpdateAll();
    RespInfo<String> testDeleteAll();

}
