package com.giyong8504.quizboard.service;

import com.giyong8504.quizboard.entities.BoardData;
import com.giyong8504.quizboard.repositories.BoardDataRepository;
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
}
