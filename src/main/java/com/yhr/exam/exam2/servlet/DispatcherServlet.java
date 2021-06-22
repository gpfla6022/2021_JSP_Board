package com.yhr.exam.exam2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yhr.exam.exam2.http.controller.Controller;
import com.yhr.exam.exam2.http.controller.UsrArticleController;
import com.yhr.exam2.http.Rq;
import com.yhr.mysqliutil.MysqlUtil;
import com.yhr.mysqliutil.SecSql;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Rq rq = new Rq(req, resp);

		if (rq.isInvaild()) {
			rq.print("올바른 요청이 아닙니다.");
		}
		
		rq.println("controllerTypeName : " + rq.getControllerTypeName());
		rq.println("<br>");
		rq.println("controllerName : " + rq.getControllerName());
		rq.println("<br>");
		rq.println("actionMethodName : " + rq.getActionMethodName());
		
		Controller controller = null;
		
		switch(rq.getControllerTypeName()) {
		case "usr":
			switch(rq.getControllerName()) {
			case "article":
				controller = new UsrArticleController();
			}
			break;
		}
		
		if(controller != null) {
			
			// DB연결
			MysqlUtil.setDBInfo("localhost", "joy", "ful", "jsp_yhr_board");

			// 개발모드를 켬
			MysqlUtil.setDevMode(true);
			
			controller.performAction(rq);
			
			// DB연결 종료
			MysqlUtil.closeConnection();
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
