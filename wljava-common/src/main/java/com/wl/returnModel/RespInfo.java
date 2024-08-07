package com.wl.returnModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wl.defined.Constant;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RespInfo<T> {
    private int code;
    private String message;
    private T data;

    public static <T> RespInfo<T> ok(T data) {
        return ok(null, data);
    }

    public static <T> RespInfo<T> ok(String message) {
        return ok(message, null);
    }

    public static <T> RespInfo<T> ok(String message, T data) {
        RespInfo<T> info = new RespInfo<>();
        info.code = Constant.SUCCESS;
        info.message = message;
        info.data = data;
        return info;
    }

    public static <T> RespInfo<T> error(String message) {
        RespInfo<T> info = new RespInfo<>();
        info.code = Constant.FAIL;
        info.message = message;
        return info;
    }

    @JsonIgnore
    public boolean isOk() {
        return this.code == Constant.SUCCESS;
    }

    @JsonIgnore
    public boolean isNotOk() {
        return this.code != Constant.SUCCESS;
    }
}
