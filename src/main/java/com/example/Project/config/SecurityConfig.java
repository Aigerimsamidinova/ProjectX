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
                .antMatchers("/add").hasRole("ADMIN")
                .antMatchers("/delete/{id}").hasRole("ADMIN")
                .antMatchers("/get/{id}").permitAll()
                .antMatchers("/update").hasRole("ADMIN")
                .antMatchers("/getAll").permitAll()
                .antMatchers("/deleteAll").hasRole("ADMIN")
                .antMatchers("/{itemId}/{officeId}/bookItem").permitAll()
                .antMatchers("/{id}/addItem/{itemId}").hasRole("ADMIN")
                .antMatchers("/get/itemsInOffice/{id}").permitAll()
                .and()
                .httpBasic()
                .and()
                .logout();
    }
}
