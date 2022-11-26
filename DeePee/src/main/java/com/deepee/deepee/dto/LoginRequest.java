package com.deepee.deepee.dto;

import lombok.*;

@Getter
@Setter
//@NoArgsConstructor
@RequiredArgsConstructor
public class LoginRequest {
    private String email;
    private String password;
}
