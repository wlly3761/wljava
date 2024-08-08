package com.wl.service.business;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wl.entity.UserInfo;
import com.wl.query.UserInfoQuery;
import com.wl.returnModel.RespInfo;
import com.wl.vo.UserInfoVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserInfoService extends IService<UserInfo> {
    RespInfo<List<UserInfoVO>> getUserInfo(UserInfoQuery query);

    RespInfo<String> updateBatchUserInfo(List<UserInfo> userInfoList);

    RespInfo<String> testUpdateAll();
    RespInfo<String> testDeleteAll();

    RespInfo<IPage<UserInfoVO>> getUserInfoPage(UserInfoQuery query);


}
