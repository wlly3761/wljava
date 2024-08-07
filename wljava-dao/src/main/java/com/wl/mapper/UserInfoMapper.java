package com.wl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wl.models.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
