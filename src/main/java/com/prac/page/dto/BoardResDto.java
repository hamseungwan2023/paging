package com.prac.page.dto;

import com.prac.page.entity.Board;
import lombok.Getter;

@Getter
public class BoardResDto {
    private String title;
    private String content;

    public BoardResDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
