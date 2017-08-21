package com.example.demo.Controller;

import com.example.demo.Controller.common.JsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gaochangqing on 2017/7/27.
 */
public class BaseAction{

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected JsonResult result = new JsonResult();

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public JsonResult getResult() {
        return result;
    }

    public void setResult(JsonResult result) {
        this.result = result;
    }
}
