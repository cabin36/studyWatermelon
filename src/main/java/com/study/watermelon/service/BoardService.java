package com.study.watermelon.service;

import com.study.watermelon.model.BoardModel;
import com.study.watermelon.reopsitory.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardModel boardMdoel) {
        boardRepository.save(boardMdoel);
    }

    public List<BoardModel> findAll() {
        return  boardRepository.findAll();
    }
}
