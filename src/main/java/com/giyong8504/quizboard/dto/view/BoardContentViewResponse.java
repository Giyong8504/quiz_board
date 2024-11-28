package com.giyong8504.quizboard.dto.view;

import com.giyong8504.quizboard.entities.BoardData;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardContentViewResponse {

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime reg_dt;
    private LocalDateTime mod_dt;

    public BoardContentViewResponse(BoardData boardData) {
        this.id = boardData.getBoardId();
        this.title = boardData.getTitle();
        this.content = boardData.getContent();
        this.author = boardData.getAuthor();
        this.reg_dt = boardData.getReg_dt();
        this.mod_dt = boardData.getMod_dt();
    }
}
