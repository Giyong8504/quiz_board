package com.giyong8504.quizboard.repositories;

import com.giyong8504.quizboard.entities.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDataRepository extends JpaRepository<BoardData, Long> {
}
