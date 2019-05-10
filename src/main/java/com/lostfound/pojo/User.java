package com.lostfound.pojo;

import java.util.Date;

public class User {
    private Long user_id;

    private String username;

    private String password;

    private String phone;

    private String e_mail;

    private Integer permission;

    private String head;



    public Long getId() {
        return user_id;
    }

    public void setId(Long id) {
        this.user_id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return e_mail;
    }

    public void setEmail(String email) {
        this.e_mail = email == null ? null : email.trim();
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}