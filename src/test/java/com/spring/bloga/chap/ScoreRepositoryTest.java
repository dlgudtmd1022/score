package com.spring.bloga.chap;

import com.spring.bloga.chap.entity.Score;
import com.spring.bloga.chap.repository.ScoreRepository;
import com.spring.bloga.chap.repository.ScoreRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreRepositoryTest {

    ScoreRepository repository = new ScoreRepositoryImpl();

    @Test
    @DisplayName("전체")
    public void findAllTest(){
        // given

        // when
        List<Score> result = repository.findAll();
        //then
        assertEquals(3,result.size());
    }

    @Test
    @DisplayName("있는번호")
    public void findByStudentNumberTest(){
        int studentID= 2;

        Score result = repository.findByStudentNumber(studentID);

        assertEquals("이번",result.getName());
    }

    @Test
    @DisplayName("없는번호조회")
    public void notFindByStudentNumberTest(){
        int studentNum = 100;

        Score result = repository.findByStudentNumber(studentNum);

        assertNull(result);
    }

    @Test
    @DisplayName("저장")
    public void saveTest(){
        Score score = new Score();
        score.setName("5번");
        score.setKorScore(35);
        score.setEngScore(36);

        boolean boolResult = repository.save(score);
        List<Score> result = repository.findAll();

        assertEquals(4,result.size());
        assertTrue(boolResult);
    }
}
