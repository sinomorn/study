package com.study.oauth.config;

import com.study.oauth.service.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: kevin
 * @Date: 2019/1/17 下午3:09
 * @Version 1.0
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    将
    @Bean
    public UserDetailsService userService(){
        return new MyUserDetailService();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().permitAll().and().logout().permitAll()
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //
        auth.inMemoryAuthentication().
                passwordEncoder(new BCryptPasswordEncoder())
                .withUser("kevin")
                .password(new BCryptPasswordEncoder().encode("123"))
                .roles("admin");
    }
}
