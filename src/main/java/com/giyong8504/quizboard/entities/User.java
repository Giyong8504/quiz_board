package com.giyong8504.quizboard.entities;

import com.giyong8504.quizboard.common.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_no", updatable = false)
    private Long userNo;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userNm;

    @Column(length = 11)
    private String mobile;

    @Enumerated(EnumType.STRING) // 이름 그대로 저장
    private Role role = Role.USER;

    @Builder
    public User(Long userNo, String email, String password, String userNm, String mobile, Role role) {
        this.userNo = userNo;
        this.email = email;
        this.password = password;
        this.userNm = userNm;
        this.mobile = mobile;
        this.role = role;
    }
}
