package com.example.tryshop.dto;


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
////package com.example.tryshop.dto;

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