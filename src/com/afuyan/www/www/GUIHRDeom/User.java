package com.afuyan.www.www.GUIHRDeom;

public class User {
    // 登录角色HR：用户名称，登录名称 ，密码
    private String username;
    private  String loginName;
    private String password;

    public User() {
    }

    public User(String username, String loginName, String password) {
        this.username = username;
        this.loginName = loginName;
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


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }




}
