package com.protalento.market.web.segurityConfig;

import com.protalento.market.domain.service.ProtalentoUserDatailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
public class SegurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private ProtalentoUserDatailsService protalentoUserDatailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(protalentoUserDatailsService); //se le indica el usuario y la contraseña que queremos manejar
    }



}
