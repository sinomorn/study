package com.study.oauth.mapper;

import com.study.oauth.model.SecurityRole;

import java.util.List;

public interface SecurityRoleMapper {
    int deleteByPrimaryKey(Long rId);

    int insert(SecurityRole record);

    int insertSelective(SecurityRole record);

    SecurityRole selectByPrimaryKey(Long rId);

    int updateByPrimaryKeySelective(SecurityRole record);

    int updateByPrimaryKey(SecurityRole record);

    List<SecurityRole> selectListByUsername(String uUsername);

}