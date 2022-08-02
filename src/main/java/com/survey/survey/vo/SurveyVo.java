package com.survey.survey.vo;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

@Getter
@Setter
public class SurveyVo extends JsonResultVo{
    private String user_name;
    private String user_data;
    private JSONObject json_data;
    private int idx;

    public JSONObject getJson_data(){
        return new JSONObject(this.user_data);
    }
}
