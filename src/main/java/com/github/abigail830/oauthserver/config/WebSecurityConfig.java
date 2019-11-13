package com.github.abigail830.oauthserver.config;

import com.github.abigail830.oauthserver.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserService customUserService;

    @Autowired
    MD5PasswordEncoder md5PasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService).passwordEncoder(md5PasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/user/*").hasRole("USER")
                .antMatchers("/admin/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/login").permitAll()
//                .and()
//                .addFilterBefore(new JwtLoginFilter("/login", authenticationManager()),
//                        UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(new JwtVerifyFilter(), UsernamePasswordAuthenticationFilter.class)
        ;

    }
}
