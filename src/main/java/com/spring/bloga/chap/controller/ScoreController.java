package com.spring.bloga.chap.controller;

import com.spring.bloga.chap.entity.Score;
import com.spring.bloga.chap.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
list : get방식 : 정보 보여주기
register : post방식 : 성적 등록
remove : post방식 : 삭제
detail : get방식 상세 정보 요청
 */
    @Controller
    @RequestMapping("score")
    @RequiredArgsConstructor
public class ScoreController {

        private final ScoreRepository repository;

        @GetMapping ("list")
        public String list(Model model){
            List<Score> scoreList = repository.findAll();
            model.addAttribute("scoreList",scoreList);
            return "chap/score-list";
        }

        @PostMapping("register")
        public String register(Score score){
            boolean result = repository.save(score);
            return"redirect:/score/list";
        }

        @PostMapping("remove")
        public String remove(int studentNum){
            repository.deleteByStudentNumber(studentNum);
            return "redirect:/score/list";
        }

    @GetMapping("/detail")
    public String detail(int studentNumber, Model model){

        Score score = repository.findByStudentNumber(studentNumber);

        model.addAttribute("score", score);

        return "chap/detail";
    }
}
