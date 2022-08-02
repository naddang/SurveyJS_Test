package com.survey.survey.service;

import com.survey.survey.dao.SurveyDao;
import com.survey.survey.vo.JsonResultVo;
import com.survey.survey.vo.SurveyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyService {
    final SurveyDao dao;

    @Autowired
    public SurveyService(SurveyDao dao) {
        this.dao = dao;
    }

    public JsonResultVo insertSurvey(SurveyVo vo){
        JsonResultVo jsonVo = new JsonResultVo();
        int result = dao.insertSurvey(vo);

        if (result == 1){
            jsonVo.setCode(200);
            jsonVo.setMsg("OK");
        }else {
            jsonVo.setCode(400);
            jsonVo.setMsg("Bad Request");
        }

        return jsonVo;
    }

    public List<SurveyVo> AllSurveyList(){
        return dao.selectSurveyList();
    }

    public SurveyVo getSurveyByIdx(SurveyVo vo){
        return dao.selectSurveyByIdx(vo);
    }


}
