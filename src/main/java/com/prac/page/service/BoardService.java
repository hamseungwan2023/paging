package com.prac.page.service;

import com.prac.page.dto.BoardReqDto;
import com.prac.page.dto.BoardResDto;
import com.prac.page.entity.Board;
import com.prac.page.repository.BoardMapping;
import com.prac.page.repository.BoardRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Page<BoardMapping> getBoards(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return boardRepository.findAllByOrderByModifiedAtDesc(pageable);
    }

    public BoardResDto createBoard(BoardReqDto reqDto) {
        Board board = Board.builder()
                .title(reqDto.getTitle())
                .content(reqDto.getContent())
                .build();
        boardRepository.save(board);
        return new BoardResDto(board);
    }

    public BoardResDto updateBoard(Long id,BoardReqDto reqDto) {
        Board board = boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("보드아이디가 없음"));
        Board updatedBoard = board.toBuilder()
                .title(reqDto.getTitle())
                .content(reqDto.getContent())
                .build();
        boardRepository.save(updatedBoard);
        return new BoardResDto(updatedBoard);
    }
}
