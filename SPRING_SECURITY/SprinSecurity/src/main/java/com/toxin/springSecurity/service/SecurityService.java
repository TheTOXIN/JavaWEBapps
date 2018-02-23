package com.toxin.springSecurity.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
