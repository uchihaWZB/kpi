package com.example.demo.Controller.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaochangqing on 2017/7/27.
 */
public class JsonResult implements Serializable {

    /** 返回字符串，标识是否成功 */
    private String						result;

    /** 用来存放待返回的数据 */
    private Map<String, Object>	 data = new HashMap<String, Object>();

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
