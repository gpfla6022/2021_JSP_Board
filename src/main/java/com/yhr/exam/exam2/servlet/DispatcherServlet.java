package com.yhr.exam.exam2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yhr.mysqliutil.MysqlUtil;
import com.yhr.mysqliutil.SecSql;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 들어오는 파라미터를 UTF-8로 해석
		req.setCharacterEncoding("UTF-8");

		// 서블릿이 HTML 파일을 만들 때 UTF-8로 쓰기
		resp.setCharacterEncoding("UTF-8");

		// HTML이 UTF-8형식이라는 것을 브라우저에게 알린다.
		resp.setContentType("text/html; charset=UTF-8");
		
		String requestUri = req.getRequestURI();
		String[] requestUriBits = requestUri.split("/");

		int minBitsCount = 5;

		if (requestUriBits.length < minBitsCount) {
			resp.getWriter().append("올바른 요청이 아닙니다.");
			return;
		}

		int controllerTypeNameIndex = 2;
        int controllerNameIndex = 3;
        int actionMethodNameIndex = 4;

        String controllerTypeName = requestUriBits[controllerTypeNameIndex];
        String controllerName = requestUriBits[controllerNameIndex];
        String actionMethodName = requestUriBits[actionMethodNameIndex];

        resp.getWriter().append("controllerTypeName : " + controllerTypeName);
        resp.getWriter().append("<br>");
        resp.getWriter().append("controllerName : " + controllerName);
        resp.getWriter().append("<br>");
        resp.getWriter().append("actionMethodName : " + actionMethodName);

		// DB연결
		MysqlUtil.setDBInfo("localhost", "joy", "ful", "jsp_yhr_board");
		
		// 개발모드를 켬
		MysqlUtil.setDevMode(true);

		// DB연결 종료
		MysqlUtil.closeConnection();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
