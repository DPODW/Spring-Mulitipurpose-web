package com.multipurpose.web.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginMember {
    @NotBlank
    @Size(min=2, max= 20)
    private String loginId;

    @NotBlank
    @Size(min=10, max= 20)
    private String loginPwd;

    public LoginMember(String loginId, String loginPwd) {
        this.loginId = loginId;
        this.loginPwd = loginPwd;
    }

    public LoginMember() {

    }
}
