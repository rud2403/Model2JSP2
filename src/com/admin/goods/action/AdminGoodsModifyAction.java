package com.admin.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminGoodsModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("M : AdminGoodsModifyAction_execute() 호출");
		
		// 전달된 수정할 정보를 저장(DTO)
		
		// DAO 객체 -> modifyGoods(DTO);
		
		// 페이지 이동(./AdminGoodsList.ag)
		
		return null;
	}

}
