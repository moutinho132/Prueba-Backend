package com.example.demo.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponseToken extends Throwable {
    private String message;
    private int statusCode;
}
