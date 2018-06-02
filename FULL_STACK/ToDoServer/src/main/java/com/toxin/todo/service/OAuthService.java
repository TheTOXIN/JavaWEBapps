package com.toxin.todo.service;

import com.toxin.todo.dto.OAuthDtoRequest;
import com.toxin.todo.dto.OAuthDtoResponse;

public interface OAuthService {
    OAuthDtoResponse login(OAuthDtoRequest request);
}
