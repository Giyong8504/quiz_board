package com.giyong8504.quizboard.controller;

import com.giyong8504.quizboard.dto.view.BoardContentViewResponse;
import com.giyong8504.quizboard.dto.view.BoardListViewResponse;
import com.giyong8504.quizboard.entities.BoardData;
import com.giyong8504.quizboard.service.BoardDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    //게시글 내용 뷰
    @GetMapping("/board/{id}")
    public String getBoardContent(@PathVariable Long id, Model model) { // id 값으로 전달
        BoardData boardData = boardDataService.findById(id);
        BoardContentViewResponse boardContent = new BoardContentViewResponse(boardData); // dto로 감싸줌

        model.addAttribute("boardContent", boardContent);

        return "userBoard/boardContent";
    }

    // 게시글 수정, 생성
    @GetMapping("/newBoard")
    public String newBoard(@RequestParam(required = false) Long id, Model model) { // id값이 없으면 null 반환함
        if (id == null) { // id 값이 없을 경우 생성
            model.addAttribute("board", new BoardContentViewResponse());
        }
        else { // id 값이 있을 경우 조회 후 뷰로 전달
            BoardData boardData = boardDataService.findById(id);
            model.addAttribute("board", new BoardContentViewResponse(boardData));
        }

        return "userBoard/newBoard";
    }

}
