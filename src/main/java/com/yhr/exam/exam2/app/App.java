package com.yhr.exam.exam2.app;

import com.yhr.exam2.container.Container;
import com.yhr.mysqliutil.MysqlUtil;

public class App {
	public static boolean isDevMode() {
		return true;
	}
	
	public static void init() {
		MysqlUtil.setDBInfo("localhost", "joy", "ful", "jsp_yhr_board");
		MysqlUtil.setDevMode(isDevMode());
		
		Container.init();
	}
}
