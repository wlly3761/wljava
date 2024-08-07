package com.wl.service.userInfo.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wl.mapper.UserInfoMapper;
import com.wl.models.UserInfo;
import com.wl.query.UserInfoQuery;
import com.wl.returnModel.RespInfo;
import com.wl.service.userInfo.IUserInfoService;
import com.wl.vo.UserInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoSericeImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    /**
     * 根据条件查询用户信息
     * @param query
     * @return RespInfo<List<UserInfoVO>>
     */
    @Override
    public RespInfo<List<UserInfoVO>> getUserInfo(UserInfoQuery query) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(query.getName()), "name", query.getName());
        List<UserInfo> userInfoList = baseMapper.selectList(queryWrapper);
        List<UserInfoVO> userInfoVOList = BeanUtil.copyToList(userInfoList, UserInfoVO.class);
        return RespInfo.ok(userInfoVOList);
    }

    @Override
    public RespInfo<String> updateBatchUserInfo(List<UserInfo> userInfoList) {
           if(updateBatchById(userInfoList)) return RespInfo.ok("批量更新成功");
           else return RespInfo.error("批量更新失败");
    }
}
