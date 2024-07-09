package com.study.watermelon.reopsitory;


import com.study.watermelon.model.BoardModel;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final SqlSessionTemplate sql;

    public void save(BoardModel boardModel) {
        sql.insert("Board.insertTest", boardModel);
    }

    public List<BoardModel> findAll() {
        return sql.selectList("Board.findAll");
    }
}