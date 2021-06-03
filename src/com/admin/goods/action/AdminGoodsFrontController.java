package com.admin.goods.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet('')
public class AdminGoodsFrontController extends HttpServlet{

	// GET/POST방식 상관없이 한번에 주소 처리
	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminGoods_doProcess() 호출");
		
		/******************* 1.페이지 주소 파싱 시작 ********************************/
		// 가상주소 전체 가져오기
		String requestURI = request.getRequestURI();
		// 프로젝트명 가져오기
		String contextPath = request.getContextPath();
		// 필요한 가상주소 생성
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("command : "+command);
		System.out.println("C : 1.페이지 주소 파싱 완료 ");
		/******************* 1.페이지 주소 파싱 끝 ********************************/
		
		/******************* 2.페이지 주소 매핑(연결) 시작 ****************************/
		
		Action action = null;
		ActionForward forward = null;
		
		
		if(command.equals("/GoodsAdd.ag")){
			System.out.println("C : /GoodsAdd.ag  호출");
			// 정보를 입력받는 페이지 -> view페이지 이동
			
			forward = new ActionForward();
			forward.setPath("./admingoods/admin_goods_write.jsp");
			forward.setRedirect(false);
			
		}else if(command.equals("/GoodsAddAction.ag")){
			System.out.println("C : /GoodsAddAction.ag  호출");			
			// GoodsAddAction() 객체 생성
			action = new GoodsAddAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(command.equals("/AdminGoodsList.ag")){
			System.out.println("C : /AdminGoodsList.ag 호출");
			// DB정보를 사용해서 화면에 출력
			// AdminGoodsListAction() 객체
			action = new AdminGoodsListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(command.equals("/AdminGoodsModify.ag")){
			System.out.println("C : /AdminGoodsModify.ag 호출");
			// DB 정보를 꺼내서 화면에 출력
			// AdminGoodsModifyFormAction();
			
			action = new AdminGoodsModifyFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/AdminGoodsModifyAction.ag")){
			System.out.println("C : /AdminGoodsModifyAction.ag 호출");
			// DB정보를 처리 페이지(list 이동) 이동
			// AdminGoodsModifyAction() 객체 생성
			
			action = new AdminGoodsModifyAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(command.equals("/AdminGoodsDelete.ag")){
			System.out.println("C : /AdminGoodsDelete.ag 호출");
			// 상품정보를 바로 DB에서 삭제 -> 상품리스트 이동
			// AdminGoodsDeleteAction() 객체 생성
			action = new AdminGoodsDeleteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		System.out.println("C : 2.페이지 주소 매핑 완료");
		
		/******************* 2.페이지 주소 매핑(연결) 끝 ****************************/
		
		
		
		/******************* 3.페이지 주소 이동 시작 ********************************/
		
		if(forward != null){ // 페이지 이동정보가 있다.
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
				System.out.println("C : sendRedirect() 방식, " + forward.getPath() + "페이지 이동");
			}else{ // false
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());		
				dis.forward(request, response);
				System.out.println("C : forward() 방식, " + forward.getPath() + "페이지 이동");
			}
			System.out.println("C : 3.페이지 주소이동 완료");
			
		}
		System.out.println("C : 3.페이지 주소 이동X(컨트롤러 이동X)");
		
		/******************* 3.페이지 주소 이동 끝 ********************************/

	}
	
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminGoods_doGet() 호출");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminGoods_doPost() 호출");
		doProcess(request, response);
	}
	

}
