package com.prac.page.controller;

import com.prac.page.dto.BoardReqDto;
import com.prac.page.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody BoardReqDto reqDto) {
        return ResponseEntity.ok(boardService.createBoard(reqDto));
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable Long id, @RequestBody BoardReqDto reqDto) {
        return ResponseEntity.ok(boardService.updateBoard(id, reqDto));
    }

    @GetMapping("/page")
    public ResponseEntity<?> getBoardPage(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(boardService.getBoards(page, size));
    }

//    @GetMapping("/desc")
//    public ResponseEntity<?> getBoardDesc(@RequestParam int page, @RequestParam int size) {
//        return ResponseEntity.ok(boardService.descBoards(page,size));
//    }
}
