package com.yhr.exam.exam2.dto;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yhr.exam.exam2.util.Ut;

import lombok.Getter;
import lombok.ToString;

@ToString
public class ResultData {

    @Getter
    private String msg;
    @Getter
    private String resultCode;
    @Getter
    private Map<String, Object> body;

    private ResultData() {

    }

    public boolean isSuccess() {
        return resultCode.startsWith("S-1");
    }

    public boolean isFail() {
        return !isSuccess();
    }

    public static ResultData from(String resultCode, String msg, Object... bodyArgs) {

        ResultData rd = new ResultData();

        rd.resultCode = resultCode;
        rd.msg = msg;
        rd.body = Ut.mapOf(bodyArgs);

        return rd;
    }

}