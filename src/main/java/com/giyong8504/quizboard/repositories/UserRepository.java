package com.giyong8504.quizboard.repositories;

import com.giyong8504.quizboard.entities.QUser;
import com.giyong8504.quizboard.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor {

    Optional<User> findByEmail(String email); // 사용자 email 조회

    default boolean exists(String email) { // 이메일이 존재하는지 확인.
        return exists(QUser.user.email.eq(email)); // Querydls을 사용하여 싱글톤 패턴으로 항목 조회
    }

}
