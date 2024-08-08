package com.wl.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wl.Pager;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserInfoQuery extends Pager {
    @Schema(description = "用户名")
    private String name;
}
