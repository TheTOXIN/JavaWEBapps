package com.toxin.todo.controller;

import com.toxin.todo.dto.OAuthDtoRequest;
import com.toxin.todo.dto.OAuthDtoResponse;
import com.toxin.todo.service.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//TODO rename
@RestController
public class OAuthController {

    private final OAuthService oAuthService;

    @Autowired
    public OAuthController(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }

    @PostMapping("/login")
    public OAuthDtoResponse todo(@RequestBody OAuthDtoRequest request) {
        return oAuthService.login(request);
    }

}
