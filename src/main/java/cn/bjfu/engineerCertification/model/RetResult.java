package cn.bjfu.engineerCertification.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by jxy on 2021/4/19 0019 16:48
 */
@Data
@Accessors(chain = true)
public class RetResult<T> {

    private Integer code;
    private String msg;
    private T data;

    public RetResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RetResult() {
    }

    public RetResult(RetResultEnum retResultEnum) {
        this.code = retResultEnum.getRetCode();
        this.msg = retResultEnum.getRetDesc();
    }

    public RetResult(RetResultEnum retResultEnum, T data) {
        this.code = retResultEnum.getRetCode();
        this.msg = retResultEnum.getRetDesc();
        this.data = data;
    }

    public static RetResult<Object> SUCCESS(Object data) {
        return new RetResult<>(RetResultEnum.RET_SUCCESS).setData(data);
    }

    public static RetResult<Object> NO_DATA() {
        return new RetResult<>(RetResultEnum.NO_DATA);
    }

    public static RetResult<Object> ERROR() {
        return new RetResult<>(RetResultEnum.ERROR);
    }

    public static RetResult<Object> SYSTEM_ERROR() {
        return new RetResult<>(RetResultEnum.ERROR);
    }
}
