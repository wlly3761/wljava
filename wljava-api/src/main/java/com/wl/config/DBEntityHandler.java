package com.wl.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.wl.defined.Constant;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;

@Component
public class DBEntityHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Date now = new Date();
        metaObject.setValue("version", 1);
        metaObject.setValue("createDate", now);
        metaObject.setValue("updateDate", now);
        //        metaObject.setValue(Constant.DELETED_FLAG_FIELD_NAME,Constant.NO);
        TableInfo tableInfo = this.findTableInfo(metaObject);
        List<TableFieldInfo> fieldList = tableInfo.getFieldList();
        TableFieldInfo deletedField = fieldList.stream().filter(f -> f.getField().getName().equals(Constant.DELETED_FLAG_FIELD_NAME)).findAny().orElse(null);
        if (deletedField != null) {
            Object deleted = this.getFieldValByName(Constant.DELETED_FLAG_FIELD_NAME, metaObject);
            if (null == deleted) {
                this.setFieldValByName(Constant.DELETED_FLAG_FIELD_NAME, Constant.NO, metaObject);
            }
        }
        if (isLonginUser()) {
            metaObject.setValue("updateUserId", currentUserId());
            metaObject.setValue("createUserId", currentUserId());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date now = new Date();
        metaObject.setValue("updateDate", now);
        if (isLonginUser()) {
            metaObject.setValue("updateUserId", currentUserId());
        }
    }

    private boolean isLonginUser() {
        return false;
    }

    private Long currentUserId() {
        return 10000L;
    }
}
