package com.geowarin

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity
import org.springframework.security.config.http.SessionCreationPolicy

/**
 *
 * Date: 30/04/2014
 * Time: 23:36
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http.httpBasic()
        http.authorizeRequests()
                .antMatchers('/management/**').authenticated()
                .antMatchers('/documentation.html', '/documentation/**').authenticated()
                .anyRequest().permitAll()
    }

    @Value('${adminPassword:password}')
    private String password

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser('admin').password(password).roles('ADMIN');
    }

    @Bean
    @Override
    AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean()
    }
}
