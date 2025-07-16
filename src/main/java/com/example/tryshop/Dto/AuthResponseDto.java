package com.example.tryshop.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//
////@NoArgsConstructor
//@Data
//public class AuthResponseDto {
//    private String acesstoken;
//    private String tokentype;
//
//    public AuthResponseDto(String acesstoken, String tokentype) {
//        this.acesstoken = acesstoken;
//        this.tokentype = tokentype;
//    }
//}
////package com.example.tryshop.Dto;

    public class AuthResponseDto {
    private String token;

    public AuthResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}