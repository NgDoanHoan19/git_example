package com.security.JWT.payload;

import lombok.Data;

@Data
public class LoginReponse {
    private String accessToken;
    public String tokenType = "Bearer";

    public LoginReponse (String accessToken){
        this.accessToken=accessToken;
    }
}

