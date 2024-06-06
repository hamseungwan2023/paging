//package com.prac.page.service;
//
//import com.prac.page.entity.Board;
//import com.prac.page.repository.BoardRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    private BoardRepository boardRepository;
//
//    public DataLoader(BoardRepository boardRepository) {
//        this.boardRepository = boardRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        for (int i = 1; i <= 300; i++) {
//            boardRepository.save(Board.builder()
//                    .title("Title " + i)
//                    .content("Content for board " + i)
//                    .build());
//        }
//    }
//}
