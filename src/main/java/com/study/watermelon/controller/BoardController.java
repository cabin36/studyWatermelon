package com.study.watermelon.controller;


import com.study.watermelon.model.BoardModel;
import com.study.watermelon.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save")
    public String save() {
        return "save";
    }

    @PostMapping("/save")
    public String save(BoardModel boardModel)
    {
        System.out.println("boardDTO = " + boardModel);
        boardService.save(boardModel);
        return "index";
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<BoardModel> boardDTOList =boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        System.out.println("boardDTOList = " + boardDTOList);
        return "list";
    }
}