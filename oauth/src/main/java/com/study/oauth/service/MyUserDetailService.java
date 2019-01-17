package com.study.oauth.service;

import com.study.oauth.mapper.SecurityUserMapper;
import com.study.oauth.model.MyUserDetail;
import com.study.oauth.model.SecurityRole;
import com.study.oauth.model.SecurityUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/1/17 下午4:07
 * @Version 1.0
 */
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private SecurityUserMapper securityUserMapper;

    @Autowired
    private com.study.oauth.mapper.SecurityRoleMapper SecurityRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String uUsername) throws UsernameNotFoundException {
        MyUserDetail myUserDetail = new MyUserDetail();
        //查询数据库,封装好UserDetails 交给security 做比对凭证
        SecurityUser securityUser = securityUserMapper.selectByUserName(uUsername);
        BeanUtils.copyProperties(securityUser,myUserDetail);


//        List<SecurityRole> roles=SecurityRoleMapper.selectListByUsername(uUsername);
        List<SecurityRole> roles = new ArrayList<>();
        SecurityRole securityRole = new SecurityRole();
        securityRole.setrId(1L);
        securityRole.setrName("admin");

        SecurityRole securityRole2 = new SecurityRole();
        securityRole2.setrId(2L);
        securityRole2.setrName("client");

        roles.add(securityRole);
        roles.add(securityRole2);

        myUserDetail.setRoles(roles);
        System.out.println("查出的myUserDetail:"+myUserDetail);
        return myUserDetail;
    }
}
