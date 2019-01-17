package com.study.oauth;

import com.study.oauth.mapper.SecurityUserMapper;
import com.study.oauth.model.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kevin
 * @Date: 2019/1/17 下午3:34
 * @Version 1.0
 */
@RestController
public class TestController {
    @Autowired
    private SecurityUserMapper securityUserMapper;

    @RequestMapping("test")
    public SecurityUser test(){
        SecurityUser securityUser = securityUserMapper.selectByPrimaryKey(1L);
        return securityUser;
    }
}
