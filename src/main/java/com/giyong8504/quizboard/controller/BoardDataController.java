package com.giyong8504.quizboard.controller;

import com.giyong8504.quizboard.dto.BoardDataResponse;
import com.giyong8504.quizboard.service.BoardDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // JSON 형태
@RequiredArgsConstructor
public class BoardDataController {

    private final BoardDataService boardDataService;

    // 사용자 게시글 전체 조회
    @GetMapping("/api/board")
    public ResponseEntity<List<BoardDataResponse>> findAllData() {
        List<BoardDataResponse> findAll = boardDataService.findAllData()
                .stream().map(BoardDataResponse::new).toList();

        return ResponseEntity.ok().body(findAll); // 200응답 코드와 함께 body에 담아 반환
    }
}
