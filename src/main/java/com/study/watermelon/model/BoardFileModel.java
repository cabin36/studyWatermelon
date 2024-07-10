package com.study.watermelon.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardFileModel {
    private Long id;
    private Long boardId;
    private String originalFileName;
    private String storedFileName;
}
