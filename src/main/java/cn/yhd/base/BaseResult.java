package cn.yhd.base;

import java.io.Serializable;


public class BaseResult<T> implements Serializable {

    private Boolean success;    // 是否成功
    private Integer code;       // 返回code
    private String message;     // 返回消息
    private T data;             // 返回字符串

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseResult() {
        this.success = true;
    }

    public BaseResult(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public BaseResult(Boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
