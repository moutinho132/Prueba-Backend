package com.example.demo.infrastructure.api.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserLoginRequest {
    private  String email;
    private  String password;
}
