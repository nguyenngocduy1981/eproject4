package com.apt.project4.util;

import com.apt.project4.config.UserPrincipal;
import com.apt.project4.model.User;
import com.apt.project4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class GetCurrentUserFromRequest {
    @Autowired
    private UserService userService;

    public User getCurrentUser(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return userService.findById(userPrincipal.getId());
    }

}
