package com.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.goods.db.GoodsDTO;
import com.goods.db.GoodsDAO;

public class GoodsDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("M : GoodsDetailAction");
		
		// 상품상세페이지
		
		// 전달된 파라미터값 저장 (num)
		// 전달된 파라미터 값 저장 (num)
		int num = Integer.parseInt(request.getParameter("num"));
		
		// DAO 객체 생성 - getGoods(num);
		GoodsDAO gdao = new GoodsDAO();
		
		GoodsDTO gdto = gdao.getGoods(num);
		
		// DB에서 가져온 정보를 저장 ( request 영역 )
		request.setAttribute("goods", gdto);
		
		// 페이지 이동 (./goods/goods_detail.jsp)
		ActionForward forward = new ActionForward();
		forward.setPath("./goods/goods_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
