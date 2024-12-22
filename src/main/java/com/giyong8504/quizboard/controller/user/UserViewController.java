package com.giyong8504.quizboard.controller.user;

import com.giyong8504.quizboard.service.UserJoinService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequiredArgsConstructor
public class UserViewController {

    private final UserJoinService userJoinService;


    // 회원가입 페이지
    @GetMapping("/join") // 모델에서 사용할 속성 이름을 값으로 설정
    public String join(@ModelAttribute JoinForm form) {

        return "user/join";
    }

    @PostMapping("/join") // 검증 실패시 상태코드 응답(400)
    public String joinPs(@Valid JoinForm joinForm, Errors errors, SessionStatus sessionStatus) {
        userJoinService.join(joinForm, errors);

        if (errors.hasErrors()) {
            return "user/join";
        }
        return "redirect:/login";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String login() {

        return "user/login";
    }
}
