package com.giyong8504.quizboard.controller;

import com.giyong8504.quizboard.dto.AddBoardDataRequest;
import com.giyong8504.quizboard.dto.BoardDataResponse;
import com.giyong8504.quizboard.dto.UpdateBoardDataRequest;
import com.giyong8504.quizboard.entities.BoardData;
import com.giyong8504.quizboard.service.BoardDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // 사용자 게시글 조회
    @GetMapping("/api/board/{id}")
    public ResponseEntity<BoardDataResponse> findById(@PathVariable Long id) {
        BoardData findById = boardDataService.findById(id);

        return ResponseEntity.ok().body(new BoardDataResponse(findById));
    }

    // 사용자 게시글 저장
    @PostMapping("/api/board")
    public ResponseEntity<BoardData> save(@RequestBody AddBoardDataRequest request) {
        BoardData saveBoardData = boardDataService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(saveBoardData);
    }

    // 사용자 게시글 삭제
    @DeleteMapping("/api/board/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardDataService.delete(id);

        return ResponseEntity.ok().build();
    }

    // 사용자 게시글 수정
    @PutMapping("/api/board/{id}")
    public ResponseEntity<BoardDataResponse> update(@PathVariable Long id, @RequestBody UpdateBoardDataRequest request) {
        BoardData updateBoardData = boardDataService.update(id, request);

        return ResponseEntity.ok().body(new BoardDataResponse(updateBoardData));
    }

}
