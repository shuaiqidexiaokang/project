package com.lzkydh.dto;

/**
 * Created by lzk on 2018/3/10 16:52
 * Description:
 */

public class LoginExecution {
    private Boolean success;
    private String info;

    public LoginExecution() {
    }

    public LoginExecution(Boolean success, String info) {
        this.success = success;
        this.info = info;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
