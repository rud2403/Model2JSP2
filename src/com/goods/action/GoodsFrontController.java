package com.goods.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 사용하지 않는 패키지 제거  ctrl + shift + o

public class GoodsFrontController extends HttpServlet{

	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("C : GoodsFrontController_doProcess() 호출");
		
		/******************* 1.페이지 주소 파싱 ********************************/
//		// 가상주소 전체 가져오기
//		String requestURI = request.getRequestURI();
//		// 프로젝트명 가져오기
//		String contextPath = request.getContextPath();
//		// 필요한 가상주소 생성
//		String command1 = requestURI.substring(contextPath.length());
		
		// context주소를 제외한 요청주소 얻기
		String command = request.getPathInfo();
		
		System.out.println("command : " + command);
		System.out.println("C : 1.페이지 주소 파싱 완료 ");
		/******************* 1.페이지 주소 파싱 ********************************/
		
		/******************* 2.페이지 주소 매핑(연결) ****************************/
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/GoodsList.go")){
			System.out.println("C : /GoodsList.go 호출");
			// DB정보를 화면이동 없이 출력
			// GoodsListAction() 객체 생성
			action = new GoodsListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("C : 2.페이지 주소 매핑  완료");
		
		/******************* 2.페이지 주소 매핑(연결) ****************************/
		
		
		/******************* 3.페이지 주소 이동 ********************************/
		if(forward != null){ // 페이지 이동정보가 있다.
			if(forward.isRedirect()){ //true
				response.sendRedirect(forward.getPath());	
				System.out.println("C : sendRedirect() 방식, "+forward.getPath()+" 페이지 이동");
			}else{ //false
				RequestDispatcher dis =
						request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
				System.out.println("C : forward() 방식, "+forward.getPath()+" 페이지 이동");
			}
			System.out.println("C : 3.페이지 주소 이동 완료");
		}
		System.out.println("C : 3.페이지 주소 이동 X(컨트롤러 이동X)");
		/******************* 3.페이지 주소 이동 ********************************/
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("C : GoodsFrontController_doGet() 호출");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("C : GoodsFrontController_doPost() 호출");
		doProcess(request, response);
	}
	

}
