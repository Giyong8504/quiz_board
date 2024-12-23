package com.giyong8504.quizboard.models;

import com.giyong8504.quizboard.common.Role;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
public class UserInfo implements UserDetails {

    private Long userNo;
    private String email;
    private String userNm;
    private String password;
    private String mobile;
    private Role role;

    private Collection<? extends GrantedAuthority> authorities;// 권한에 대한 내용

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // 인가에 대한 권한
        return authorities;
    }

    @Override
    public String getPassword() { // 사용자 패스워드 반환
        return password;
    }

    @Override
    public String getUsername() { // 사용자 이름 반환
        return email;
    }

    @Override
    public boolean isAccountNonExpired() { // 계정 만료 여부
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 계정 잠김 여부
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 인증 자격 증명 여부
        return true;
    }

    @Override
    public boolean isEnabled() { // 계정 활성화 여부
        return true;
    }
}
