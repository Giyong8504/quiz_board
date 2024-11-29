package com.giyong8504.quizboard.models;

import com.giyong8504.quizboard.entities.User;
import com.giyong8504.quizboard.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));

        return UserInfo.builder()
                .userNo(user.getUserNo())
                .password(user.getPassword())
                .userNm(user.getUserNm())
                .email(user.getEmail())
                .mobile(user.getMobile())
                .build();

    }
}
