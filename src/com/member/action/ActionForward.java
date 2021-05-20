package com.member.action;

public class ActionForward {
	// 페이지를 이동할 때 이동정보를 저장하는 객체
	
	// 이동할 주소
	private String path;
	// 이동하는 방식
	private boolean isRedirect;
	// true - sendRedirect방식
	// false - forward방식 이동
	
	
	// set/get메소드 alt sft s + r
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
	
}
