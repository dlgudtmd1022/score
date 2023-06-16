package com.spring.bloga.chap.repository;

import com.spring.bloga.chap.entity.Score;

import java.util.List;

public interface ScoreRepository {

     public List<Score> findAll();

     boolean save(Score score);

     boolean deleteByStudentNumber(int studentNumber);

     Score findByStudentNumber(int studentNumber);
}