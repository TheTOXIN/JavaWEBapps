package com.toxin.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuthDtoRequest implements Serializable {
    private String login;
    private String password;
    private boolean reg;
}
