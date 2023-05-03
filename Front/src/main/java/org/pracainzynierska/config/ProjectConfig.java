package org.pracainzynierska.config;

import org.pracainzynierska.services.AuthenticationProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProviderService authenticationProvider;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**","/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/", true);
        http.logout()
                .logoutSuccessUrl("/").addLogoutHandler((httpServletRequest, httpServletResponse, authentication) ->

                        httpServletRequest.getSession().setAttribute("userId", null) //handler który sę wywołuje w momencie, gdy ktoś poprawnie się wylogował, pobierane jest session z request i ustawiane userId na null
                    );
        http.authorizeRequests().antMatchers("/", "/registration","/registration_car", "/user",  "/car", "/schedule", "/css/**", "/js/**", "/images/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
    }
}