package com.giyong8504.quizboard.service;

import com.giyong8504.quizboard.dto.AddBoardDataRequest;
import com.giyong8504.quizboard.dto.UpdateBoardDataRequest;
import com.giyong8504.quizboard.entities.BoardData;
import com.giyong8504.quizboard.repositories.BoardDataRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // final 필드에 대한 생성자 자동생성
public class BoardDataService {

    private final BoardDataRepository repository;

    // 전체 조회
    public List<BoardData> findAllData() {
        return repository.findAll();
    }

    // 게시글 조회
    public BoardData findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " +id));

    }

    // 게시글 저장
    public BoardData save(AddBoardDataRequest request) {
        return repository.save(request.toEntity());
    }

    // 게시글 삭제
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // 게시글 수정
    @Transactional // 작업 단위 처리
    public BoardData update(Long id, UpdateBoardDataRequest request) {
        BoardData updateBoardData = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found "+id));

        updateBoardData.update(request.getTitle(), request.getContent());

        return updateBoardData;
    }

}
