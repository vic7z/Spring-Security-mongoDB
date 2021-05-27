package com.vic.springsecuritymongodb.SecurityConfig;

import com.vic.springsecuritymongodb.Roles.ApplicationRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.vic.springsecuritymongodb.Roles.ApplicationRole.*;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable()
                 .authorizeRequests()
                .antMatchers("/api/admin").hasRole(ADMIN.name())
                .antMatchers("/api/user").hasAnyRole(ADMIN.name(), STUDENT.name())
                .antMatchers("/api").permitAll()
                .and().formLogin();


    }
}
