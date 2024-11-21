package com.giyong8504.quizboard.dto;

import com.giyong8504.quizboard.entities.BoardData;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardDataResponse {

    private String title;
    private String content;
    private String author;
    private LocalDateTime reg_dt;
    private LocalDateTime mod_dt;

    public BoardDataResponse(BoardData boardData) {
        this.title = boardData.getTitle();
        this.content = boardData.getContent();
        this.author = boardData.getAuthor();
        this.reg_dt = boardData.getReg_dt();
        this.mod_dt = boardData.getMod_dt();
    }
}
