package com.giyong8504.quizboard.controller.user;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class JoinForm {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8) // 8자리 이상
    private String password;

    @NotBlank
    private String userPwRe;

    @NotBlank
    private String userNm;

    @NotBlank
    private String mobile;

    @AssertTrue
    private boolean agree;


}
