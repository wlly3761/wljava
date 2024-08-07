package com.wl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wl.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
