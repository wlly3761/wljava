package com.wl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.wl.BaseModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(name="用户表")
@Data
@TableName("userInfo")
public class UserInfo extends BaseModel {
    @Schema(description="用户ID")
    @TableId(type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    @NotBlank(message = "用户ID不能为空")
    private Long userID;

    @Schema(description="用户名")
    @NotBlank(message = "用户名不能为空")
    private String name;

    @Schema(description="用户邮箱")
    private String email;

    @Schema(description="用户年龄")
    private String age;

}
