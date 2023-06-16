package com.spring.bloga.chap.entity;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Setter@Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Score {

    private String name;
    private int korScore;
    private int engScore;
    private int mathScore;
    private int studentNumber;
    private int total;
    private double average;
}
