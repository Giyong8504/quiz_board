package com.giyong8504.quizboard.controller;

import com.giyong8504.quizboard.dto.view.BoardListViewResponse;
import com.giyong8504.quizboard.service.BoardDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardViewController {

    private final BoardDataService boardDataService;

    // 게시글 목록 뷰
    @GetMapping("/board")
    public String getBoardList(Model model) { // 게시글 전체의 값을 Model에 전달
        List<BoardListViewResponse> boardList = boardDataService.findAllData()
                .stream().map(BoardListViewResponse::new).toList();

        model.addAttribute("board", boardList); // boardList 값을 board로 사용

        return "userBoard/boardList"; // html 파일 경로
    }
}
