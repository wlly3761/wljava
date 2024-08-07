package com.wl.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserInfoQuery {
    @Schema(description = "用户名")
    private String name;
}
