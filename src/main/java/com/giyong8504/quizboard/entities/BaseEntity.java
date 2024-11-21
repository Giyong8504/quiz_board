package com.giyong8504.quizboard.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // 엔티티의 상태 변화 감지
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime reg_dt; // 생성일

    @LastModifiedDate
    @Column(updatable = false)
    private LocalDateTime mod_dt; // 수정일

}
