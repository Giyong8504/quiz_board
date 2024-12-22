package com.giyong8504.quizboard.service;

import com.giyong8504.quizboard.common.Role;
import com.giyong8504.quizboard.controller.user.JoinForm;
import com.giyong8504.quizboard.controller.user.JoinValidator;
import com.giyong8504.quizboard.entities.User;
import com.giyong8504.quizboard.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
@RequiredArgsConstructor
public class UserJoinService {

    private final UserRepository userRepository;
    private final JoinValidator joinValidator;
    private final PasswordEncoder passwordEncoder;

    public void join(JoinForm form, Errors errors) {
        joinValidator.validate(form, errors);

        if (errors.hasErrors()) {
            return;
        }

        User user = User.builder()
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword())) // 암호화 저장
                .userNm(form.getUserNm())
                .mobile(form.getMobile())
                .role(Role.USER)
                .build();

        userRepository.saveAndFlush(user);
    }
}
