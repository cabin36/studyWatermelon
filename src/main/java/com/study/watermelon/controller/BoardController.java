package com.study.watermelon.controller;


import com.study.watermelon.model.BoardFileModel;
import com.study.watermelon.model.BoardModel;
import com.study.watermelon.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
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
    public String save(BoardModel boardModel) throws IOException {
        boardService.save(boardModel);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<BoardModel> boardModelList =boardService.findAll();
        model.addAttribute("boardModelList", boardModelList);
        return "list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        BoardModel boardModel = boardService.findById(id);
        model.addAttribute("board", boardModel);
        if(boardModel.getFileAttached() == 1){
            List<BoardFileModel> boardFileModelList = boardService.findFile(id);
            model.addAttribute("boardFileModelList", boardFileModelList);
        }
        return "detail";
    }
}