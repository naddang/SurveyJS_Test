package com.survey.survey.controller;

import com.survey.survey.service.SurveyService;
import com.survey.survey.vo.JsonResultVo;
import com.survey.survey.vo.SurveyVo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class SurveyController {
    private final SurveyService service;
    @Autowired
    public SurveyController(SurveyService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/")
    public String returnIndex(){
        return "redirect:index";
    }
    @GetMapping("/survey")
    public String survey(){
        return "survey";
    }
    @ResponseBody
    @PostMapping("/survey")
    //순서가 보있는 Map을 사용하기위해 LinkedHashMap을 사용
    public JsonResultVo survey(@RequestBody LinkedHashMap<String, String> params){
        System.out.println(params.size());
        SurveyVo vo = new SurveyVo();
        vo.setUser_name(params.get("name"));
        JSONObject json = new JSONObject(params);
        vo.setUser_data(json.toString());

        return service.insertSurvey(vo);
    }

    @GetMapping("/survey/{idx}")
    public String getOneSurvey(@PathVariable int idx, Model model){
        SurveyVo vo = new SurveyVo();
        vo.setIdx(idx);

        vo = service.getSurveyByIdx(vo);
        model.addAttribute("vo",vo);

        return "surveyInfo";
    }

    @GetMapping("/survey/all")
    public String getAllSurveyList(Model model){
        ArrayList<SurveyVo> list = (ArrayList<SurveyVo>) service.AllSurveyList();
        model.addAttribute("list", list);
        return "surveyList";
    }
}
