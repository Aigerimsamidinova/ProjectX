package com.example.Project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws  Exception{
        auth.inMemoryAuthentication().withUser("admin")
                .password("{noop}admin123").roles("ADMIN")
                .and()
                .withUser("user")
                .password("{noop}user123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("app/add").permitAll()
                .antMatchers("/item/add").hasRole("ADMIN")
                .antMatchers("/client/add").hasRole("ADMIN")
                .antMatchers("/courier/add").hasRole("ADMIN")
                .antMatchers("/office/add").hasRole("ADMIN")
                .antMatchers("office/get/{id}").permitAll()
                .antMatchers("courier/getAll").permitAll()
                .antMatchers("/deleteAll").hasRole("ADMIN")
                .antMatchers("/client/{itemId}/{officeId}/bookItem").permitAll()
                .antMatchers("/office/{id}/addItem/{itemId}").hasRole("ADMIN")
                .antMatchers("/item/get/itemsInOffice/{id}").permitAll()
                .and()
                .httpBasic()
                .and()
                .logout();
    }
}
