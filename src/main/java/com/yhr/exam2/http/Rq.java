package com.yhr.exam2.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yhr.exam.exam2.util.Ut;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Rq {

    private HttpServletResponse resp;
    private HttpServletRequest req;
    // 요청의 유효성 판단
    @Getter
    private boolean isInvalid = false;
    @Getter
    private String controllerTypeName;
    @Getter
    private String controllerName;
    @Getter
    private String actionMethodName;

    public Rq(HttpServletRequest req, HttpServletResponse resp) {

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 파일을 UTF-8방식으로 인코딩하여 저장
        resp.setCharacterEncoding("UTF-8");

        // 웹브라우저에게 컨텐츠가 UTF-8으로 인코딩되어있다고 선언
        resp.setContentType("text/html; charset=UTF-8");

        this.req = req;
        this.resp = resp;

        // /2021_jsp_board/usr/article/이거저거/이거저거
        String requestUri = req.getRequestURI();
        String[] requestUriBits = requestUri.split("/");

        int minBitsCount = 5;

        if (requestUriBits.length < minBitsCount) {
            isInvalid = true;
            return;
        }

        int controllerTypeNameIndex = 2;
        int controllerNameIndex = 3;
        int actionMethodNameIndex = 4;

        this.controllerTypeName = requestUriBits[controllerTypeNameIndex];
        this.controllerName = requestUriBits[controllerNameIndex];
        this.actionMethodName = requestUriBits[actionMethodNameIndex];

    }
    
    

    public void print(String str) {

        try {
            resp.getWriter().append(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void println(String str) {
        print(str + "\n");
    }

    public void jsp(String jspPath) {
        RequestDispatcher reqeustDispatcher = req.getRequestDispatcher("/WEB-INF/" + jspPath + ".jsp");
        try {
            reqeustDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public String getParam(String paramName, String defaultValue) {

        String paramValue = req.getParameter(paramName);

        if (paramValue == null) {
            return defaultValue;
        }

        return paramValue;
    }

    public void printf(String format, Object... args) {
        print(Ut.f(format, args));
    }

    public void historyBack(String msg) {
        println("<script>");
        printf("alert('%s')\n;", msg );
        println("history.back();");
        println("</script>");
    }

}