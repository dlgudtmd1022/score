package com.spring.bloga.chap.repository;

import com.spring.bloga.chap.entity.Score;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScoreRepositoryImpl implements ScoreRepository {


    private static final Map<Integer, Score> scoreMap;

    private static int sequence;

    static{
        scoreMap = new HashMap<>();
        Score stu1 = new Score("일번", 100, 50, 70, ++sequence,0,0);
        Score stu2 = new Score("이번", 80, 39, 30, ++sequence,0,0);
        Score stu3 = new Score("삼번", 30, 55, 70, ++sequence,0,0 );

        scoreMap.put(stu1.getStudentNumber(),stu1);
        scoreMap.put(stu2.getStudentNumber(),stu2);
        scoreMap.put(stu3.getStudentNumber(),stu3);
    }
    @Override
    public List<Score> findAll() {
        List<Score> resultList = new ArrayList<>();
        for(Score score : scoreMap.values()){
            resultList.add(score);
        }
        return resultList;
    }

    @Override
    public boolean save(Score score) {
        if(scoreMap.containsKey(score.getStudentNumber())){
            return false;
        }
        score.setStudentNumber(++sequence);
        scoreMap.put(score.getStudentNumber(), score);
        return true;
    }

    @Override
    public boolean deleteByStudentNumber(int studentNumber) {
        if(!scoreMap.containsKey(studentNumber)) return false;
        scoreMap.remove(studentNumber);
        return true;
    }

    @Override
    public Score findByStudentNumber(int studentNumber) {
        return scoreMap.get(studentNumber);
    }
}
