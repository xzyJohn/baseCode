package com.xzy.basis.core.exception;


import com.xzy.basis.core.utils.ResultCodeEnum;

/**
 * @author xzy
 * @date 2019/9/2 17:50
 */
public class BizException extends RuntimeException {
    private String code;
    private String msg;

    public BizException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMsg());
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
    }

    public String getCode() {
        return code;
    }

    public BizException setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public BizException setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
