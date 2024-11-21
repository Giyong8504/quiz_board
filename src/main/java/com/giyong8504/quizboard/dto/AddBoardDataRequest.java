package com.giyong8504.quizboard.dto;

import com.giyong8504.quizboard.entities.BoardData;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddBoardDataRequest {

    private String title;
    private String content;
    private String author;

    // 엔티티 객체로 변환하는 메서드
    public BoardData toEntity() {
        return BoardData.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
