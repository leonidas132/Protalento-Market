package com.protalento.market.web.controller;

import com.protalento.market.domain.dto.AuthenticationRequest;
import com.protalento.market.domain.dto.AuthenticationResponse;
import com.protalento.market.domain.service.ProtalentoUserDatailsService;
import com.protalento.market.web.segurityConfig.JWTutility;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validar")
public class AuthController {
/*
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ProtalentoUserDatailsService protalentoUserDatailsService;

    @Autowired
    private JWTutility jwTutility;

  /*  @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){

    }*/

}
