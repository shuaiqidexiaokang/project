package com.lzkydh.model;

import javax.validation.constraints.Min;

/**
 * Created by lzk on 2018/3/10 14:49
 * Description:
 */
public class User {
    private Integer userId;
    private String email;
    private String phone;
    private String password;
    private String username;
    private String address;

    public User() {
    }

    public User(String email, String phone, String password, String username, String address) {
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.username = username;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int useId) {
        this.userId = useId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "useId=" + userId +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
