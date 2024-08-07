package com.wl;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据库表更新信息字段，无需业务管理
 */
@Data
public abstract class BaseModel implements Serializable {
    @Schema(description = "创建人ID")
    @TableField(fill = FieldFill.INSERT)
    private Long createUserId;
    @Schema(description = "更新人ID")
    @TableField(fill = FieldFill.INSERT)
    private Long updateUserId;
    @Schema(description = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @Schema(description = "更新时间")
    @TableField(fill = FieldFill.INSERT)
    private Date updateDate;
    @Schema(description = "版本号")
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
}
