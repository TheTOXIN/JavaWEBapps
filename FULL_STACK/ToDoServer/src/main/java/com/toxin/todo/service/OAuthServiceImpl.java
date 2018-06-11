package com.toxin.todo.service;

import com.toxin.todo.dto.OAuthDtoRequest;
import com.toxin.todo.dto.OAuthDtoResponse;
import com.toxin.todo.entity.User;
import com.toxin.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OAuthServiceImpl implements OAuthService {

    private final UserRepository userRepository;

    @Autowired
    public OAuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuthDtoResponse login(OAuthDtoRequest request) {
        OAuthDtoResponse dto = new OAuthDtoResponse();

        UUID userId = request.isReg() ? reg(request) : log(request);
        dto.setUserId(userId);

        return dto;
    }

    private UUID reg(OAuthDtoRequest request) {
        User user = userRepository.findByLogin(request.getLogin());

        if (user == null) {
            user = new User();
            user.setLogin(request.getLogin());
            user.setPassword(request.getPassword());

            return userRepository.save(user).getId();
        }

        return null;
    }

    private UUID log(OAuthDtoRequest request) {
        User user = userRepository.findByLogin(request.getLogin());

        if (user != null) {
            return user.getId();
        }

        return null;
    }

}