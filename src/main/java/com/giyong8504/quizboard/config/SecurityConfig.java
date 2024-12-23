package com.giyong8504.quizboard.config;

import com.giyong8504.quizboard.models.LoginFailureHandler;
import com.giyong8504.quizboard.models.LoginSuccessHandler;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable(); // csrf 비활성화

        //회원 인증 설정 - 로그인
        http.formLogin(f -> {
            f.loginPage("/login") // 로그인 페이지 설정
                    .defaultSuccessUrl("/board")
                    .usernameParameter("email") // 사용자 아이디 파라미터 설정
                    .passwordParameter("password") // 사용자 비밀번호 파라미터 설정
                    .successHandler(new LoginSuccessHandler()) //로그인 성공시 핸들러 설정.
                    .failureHandler(new LoginFailureHandler()); //로그인 실패시 핸들러 설정.
        });

        // 회원 설정 - 로그아웃
        http.logout(f -> {
            f.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //로그아웃 URL 설정
                    .logoutSuccessUrl("/board") // 로그아웃 성공 후 이동할 페이지
                    .invalidateHttpSession(true) // HTTP 세션 무효화
                    .clearAuthentication(true) // 사용자 인증정보 제거
                    .deleteCookies("JSESSIONID", "refresh_token"); // 쿠키에 담긴 세션, 리프레시 토큰 제거
        });

        http.authorizeHttpRequests(c -> {
            //.requestMatchers("/admin/**").hasAuthority("ADMIN") // "/admin/" 경로 요청은 'ADMIN' 권한을 가진 사용자만 접근 가능
            c.requestMatchers("/mypage/**", "/new-board", "/board/**").authenticated() // "/mypage", "/board" 경로 요청은 인증된 사용자만 접근 가능
                    .anyRequest().permitAll(); // 그 외 모든 요청은 누구나 접근 가능
        });

        // 관리자, 회원 페이지 접근할 때 오류코드, 리다이렉트
        http.exceptionHandling(c -> {
            c.authenticationEntryPoint((req, res, e) -> {
                String URI = req.getRequestURI();

                if (URI.indexOf("/admin") != -1) { // 관리자 페이지로 접근 시
                    res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "NOT AUTHORIZED"); // 401 Unauthorized 에러 반환
                } else { // 회원 전용 페이지로 접근 시
                    String redirectURL = req.getContextPath() + "/login"; // 로그인 페이지로 리다이렉트 URL 생성
                    res.sendRedirect(redirectURL); // 로그인 페이지로 리다이렉트
                }
            });
        });

        // /api로 시작하는 url인 경우 401 상태코드를 반환하도록 예외 처리
        http.exceptionHandling()
                .defaultAuthenticationEntryPointFor(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED),
                        new AntPathRequestMatcher("/api/**"));;

        return http.build(); // SecurityFilterChain 반환

    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return w -> w.ignoring().requestMatchers(
                "/admin/css/**",
                "/admin/js/**",
                "/admin/images/**",
                "/board/css/**",
                "/board/js/**",
                "/board/images/**"
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() { //암호 해시화
        return new BCryptPasswordEncoder();
    }


}
