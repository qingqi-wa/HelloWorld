package com.afuyan.www.GUIHRDeom;

public class HR {
    // 登录角色HR：登录名称 ，密码
    private String username;
    private String password;

    public HR() {
    }

    public HR(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
