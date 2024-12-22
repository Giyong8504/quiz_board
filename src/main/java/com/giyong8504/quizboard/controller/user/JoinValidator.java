package com.giyong8504.quizboard.controller.user;

import com.giyong8504.quizboard.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator {

    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(JoinForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        JoinForm form = (JoinForm)target;

        /**
         * 1. 이메일 중복 체크 - 중복x
         * 2. 비밀번호, 비밀번호 확인 일치 여부
         * 3. 휴대전화번호 형식 체크
         */

        // 1. 이메일 중복 체크 - 중복x
        String email = form.getEmail();
        if (email != null && !email.isBlank() && userRepository.exists(email)) {
            errors.rejectValue("email", "duplicate");
        }

        // 2. 비밀번호, 비밀번호 확인 일치 여부
        String userPw = form.getPassword();
        String userPwRe = form.getUserPwRe();
        if (userPw != null && !userPw.equals(userPwRe) && !userPw.isBlank() && userPwRe != null && !userPwRe.isBlank()) {
            errors.rejectValue("userPwRe", "mismatch");
        }

        // 3. 휴대전화번호 형식 체크
        String mobile = form.getMobile();
        if (mobile != null && !mobile.isBlank()) {

            /**
             * 010-1111-1111, 010.1111.1111 01011111111 -> 형식을 순자만 남기고 제거
             */

            mobile = mobile.replaceAll("\\D", "");
            String patten = "^01[016]\\d{3,4}\\d{4}$";
            if (!mobile.matches(patten)) {
                errors.rejectValue("mobile", "Mobile");
            }

            form.setMobile(mobile);
        }
    }
}
