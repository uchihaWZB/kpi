package com.example.demo.utils.returnMessage;

import com.example.demo.utils.JsonUtils;

/**
 * Created by WZB on 2017/7/13.
 */
public class ReturnMsg<T> {

    // 返回状态码 - 成功
    public static final int RECODE_SUCCESS = 1;

    // 返回状态码 - 失败
    public static final int RECODE_FAIL = -1;

    // 返回状态码 - 未登录
    public static final int NOT_LOGIN = -2;

    // 返回信息 - 成功
    public static final String SUCCESS = "success";

    // 返回信息 - 错误
    public static final String ERROR = "error";

    // 返回信息 - 未登录
    public static final String NEED_LOGIN = "您还没有登录，请登录！";

    // <成功/失败/未登录>状态码
    private int code;

    // <成功/错误/未登录>额外信息
    private String msg;

    //返回结果的内容
    private T result;

    public ReturnMsg() {
        super();
    }

    // 设置状态码和额外信息
    public ReturnMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    // 设置成功状态
    public ReturnMsg<T> successMsg() {
        this.code = RECODE_SUCCESS;
        this.msg = SUCCESS;
        return this;
    }

    // 设置包含成功信息的成功状态
    public ReturnMsg<T> successMsg(String successMsg) {
        this.code = RECODE_SUCCESS;
        this.msg = successMsg;
        return this;
    }

    // 设置错误状态
    public ReturnMsg<T> errorMsg() {
        this.code = RECODE_FAIL;
        this.msg = ERROR;
        return this;
    }

    // 设置包含错误信息的错误状态
    public ReturnMsg<T> errorMsg(String errorMsg) {
        this.code = RECODE_FAIL;
        this.msg = errorMsg;
        return this;
    }

    // 设置未登陆状态
    public ReturnMsg<T> loginMsg() {
        this.code = NOT_LOGIN;
        this.msg = NEED_LOGIN;
        return this;
    }

    //转换为Json格式
    @Override
    public String toString() {
        return JsonUtils.getJsonData(this);
    }
}
