package com.study.oauth.model;

import java.io.Serializable;

public class SecurityUser implements Serializable {

    private static final long serialVersionUID = 6940618660878711068L;

    private Long uId;

    private String uUsername;

    private String uPassword;

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername == null ? null : uUsername.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }
}