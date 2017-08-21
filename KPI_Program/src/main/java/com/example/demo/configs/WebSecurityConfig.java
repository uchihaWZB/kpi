package com.example.demo.configs;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by lenovopc001 on 2017/7/10.
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {

        //  忽略css/jq/img等文件
        web.ignoring().antMatchers("/**.html","/**.css","/img/**","/**.js");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

    }
}
