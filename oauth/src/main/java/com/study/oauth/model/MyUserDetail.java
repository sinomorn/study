package com.study.oauth.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/1/17 下午4:02
 * @Version 1.0
 */
@Data
public class MyUserDetail implements Serializable,UserDetails {

    private Long uId;

    private String uUsername;

    private String uPassword;

    private List<SecurityRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //查询角色
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        roles.forEach(s->{
            grantedAuthorities.add(new SimpleGrantedAuthority(s.getrName()));
        });
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
