package com.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 개발에서 사용되는 중요 개념 => 도메인

// 컨트롤러 -> 서블릿
public class MemberFrontController extends HttpServlet{

	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController_doProcess() 호출! \n");
		
		// 주소를 비교해서 주소에 따른 페이지 처리 
		
		/*******************1.페이지 주소 파싱 시작 ********************************/
		 // 가상주소 가져오기
		 String requestURI = request.getRequestURI();
		 System.out.println("11111111111 requestURI : " + requestURI);
		 // 프로젝트명(context명)
		 String contextPath = request.getContextPath();
		 System.out.println("11111111111 contextPath : " + contextPath);
		 // 프로젝트명을 제외한 가상주소
		 // 프로젝트명 길이만큼 길이를 잘라서 출력하겠다.
		 String command = requestURI.substring(contextPath.length());
		 System.out.println("111111111111 command : " + command);
		 
		 // String requestURL = request.getRequestURL()+"";
		 // System.out.println(requestURL);		
		/*******************1.페이지 주소 파싱 끝 ********************************/
		
		 
		/*******************2.페이지 주소 매핑(연결) 시작 (어디로 갈지만 결정) ********************************/
		 // DB 사용 여부에 따라서 페이지 구성
		 ActionForward forward = null;
		 
		 // http://localhost:8088/Model2JSP2/MemberJoin.me
		 if(command.equals("/MemberJoin.me")){
			 // 회원가입 페이지 -> view 페이지
			 // 1. response 이동 (주소 페이지 전부 변경)
			 // response.sendRedirect("주소");
			 
			 // 2. forward 이동 (주소는 그대로 페이지만 변경)
			 // RequestDispatcher dis = request.getRequestDispatcher("주소");
			 // dis.forward(request, response);
			 
			 System.out.println("222222222222222 /MemberJoin.me 주소 호출");
			 
			 forward = new ActionForward();
			 forward.setPath("./member/insertForm.jsp");
			 forward.setRedirect(false);
		 }
		/*******************2.페이지 주소 매핑(연결) 끝 ********************************/
		
		/*******************3.페이지 주소 이동 시작 ********************************/
		 if(forward != null){
			 // forward객체가 있다. => 페이지 이동 정보가 있다.
			 if(forward.isRedirect()){ // true
				 System.out.println("333333333333 sendRedirect() 이동 \n");
				 response.sendRedirect(forward.getPath());
			 }else{ // false
				 System.out.println("3333333333333 forward() 이동 \n");
				 RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				 dis.forward(request, response);
			 }
		 }
		 
		/*******************3.페이지 주소 이동 끝 ********************************/
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	   System.out.println("MemberFrontController_doGet() 호출!");
	   doProcess(request, response);	   
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController_doPost() 호출!");
		doProcess(request, response);		
	}
	

}
