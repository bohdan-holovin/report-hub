package com.holovin.reporthub;

import com.holovin.reporthub.config.SecurityConfig;
import com.holovin.reporthub.config.jwt.JwtService;
import com.holovin.reporthub.service.UserAuthService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;

@ComponentScan(basePackageClasses = {SecurityConfig.class})
public class AbstractIntegratedTest {

    @MockBean
    private UserAuthService userAuthService;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private AuthenticationManager authenticationManager;
}
