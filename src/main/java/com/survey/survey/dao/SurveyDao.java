package com.survey.survey.dao;

import com.survey.survey.vo.SurveyVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Mapper
@Component
public class SurveyDao {
    @Resource
    SqlSession sqlSession;
    public int insertSurvey(SurveyVo vo){
        return sqlSession.insert("insertSurvey", vo);
    }
    public List<SurveyVo> selectSurveyList(){
        return sqlSession.selectList("selectSurveyList");
    }
    public SurveyVo selectSurveyByIdx(SurveyVo vo){
        return sqlSession.selectOne("selectSurveyByIdx", vo);
    }
}
