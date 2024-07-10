package com.study.watermelon.reopsitory;


import com.study.watermelon.model.BoardFileModel;
import com.study.watermelon.model.BoardModel;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final SqlSessionTemplate sql;

    public BoardModel save(BoardModel boardModel) {
        sql.insert("Board.insertTest", boardModel);
        return boardModel;
    }

    public BoardModel findById(Long id) {
        return sql.selectOne("Board.findById", id);
    }

    public void saveFile(BoardFileModel boardFileModel) {
        sql.insert("Board.saveFile", boardFileModel);
    }

    public List<BoardFileModel> findFile(Long id) {
        return sql.selectList("Board.findFile", id);
    }
    public List<BoardModel> findAll() {
        return sql.selectList("Board.findAll");
    }
}