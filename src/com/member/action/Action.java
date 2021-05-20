package com.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	// 상수, 추상메소드
	// abstract 없어도 인터페이스에서 기본적으로 추상메소드
	// => 동일한 동작을 수행하는 객체는 반드시 해당 메소드(추상메소드)를 구현해야한다.
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
