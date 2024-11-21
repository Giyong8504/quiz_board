package com.giyong8504.quizboard.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 추가
@AllArgsConstructor // 모든 필드값을 파라미터로 받음
@Getter @Entity
@Builder
public class BoardData extends BaseEntity{ // 공통 부분 상속

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
    @Column(name = "board_id", nullable = false)
    private Long boardId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "author", nullable = false)
    private String author;


    // 게시글 수정 메서드
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /*

    @Builder를 사용 안할 시.

    public BoardData(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    */

}
