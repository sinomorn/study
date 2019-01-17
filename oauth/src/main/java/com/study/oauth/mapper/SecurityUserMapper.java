package com.study.oauth.mapper;

import com.study.oauth.model.SecurityUser;

public interface SecurityUserMapper {
    int deleteByPrimaryKey(Long uId);

    int insert(SecurityUser record);

    int insertSelective(SecurityUser record);

    SecurityUser selectByPrimaryKey(Long uId);

    int updateByPrimaryKeySelective(SecurityUser record);

    int updateByPrimaryKey(SecurityUser record);

    SecurityUser selectByUserName(String uUsername);
}