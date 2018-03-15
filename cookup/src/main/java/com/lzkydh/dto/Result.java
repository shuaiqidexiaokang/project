package com.lzkydh.dto;

/**
 * Created by lzk on 2018/3/1 20:22
 * Description:
 */
public class Result<T> {
    private boolean success;
    private T data;
    private String message;

    public Result() {
    }


    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Result(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
