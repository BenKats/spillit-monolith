package com.project.config;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
        Authentication getAuthentication();

}
