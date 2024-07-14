package com.study.watermelon.service;

import com.study.watermelon.model.BoardFileModel;
import com.study.watermelon.model.BoardModel;
import com.study.watermelon.reopsitory.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardModel boardModel) throws IOException {
        if(boardModel.getBoardFile().get(0).isEmpty())
        {
            boardModel.setFileAttached(0);
            // db 저장
            boardRepository.save(boardModel);
        }
        else
        {
            boardModel.setFileAttached(1);
            BoardModel saveBoard = boardRepository.save(boardModel);

            for(MultipartFile boardFile : boardModel.getBoardFile()){
                String originalFilename = boardFile.getOriginalFilename();
                String storedFileName = System.currentTimeMillis() + "_" + originalFilename;

                BoardFileModel boardFileModel = new BoardFileModel();
                boardFileModel.setOriginalFileName(originalFilename);
                boardFileModel.setStoredFileName(storedFileName);
                boardFileModel.setBoardId(saveBoard.getId());

                String savePath = "file:///C:/Users/cabin3613/Desktop/watermelon/src/main/resources/upload_files/";
                boardFile.transferTo(new File(savePath));
                boardRepository.saveFile(boardFileModel);
            }
        }
    }
    public BoardModel findById(Long id) {

        return boardRepository.findById(id);
    }

    public List<BoardFileModel> findFile(Long id) {
        return boardRepository.findFile(id);
    }

    public List<BoardModel> findAll() {
        return  boardRepository.findAll();
    }

    // 수정
    public void update(BoardModel boardModel){
        boardRepository.update(boardModel);
    }

    // 삭제
    public void delete(Long id){
        boardRepository.delete(id);
    }


}
