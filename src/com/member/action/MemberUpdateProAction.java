package com.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("M : MemberUpdateProAction_execute() 호출! ");
		
        // 세션 제어 
        
        // 한글처리
        // 전달된 정보를 저장(DTO)
        
        // DAO생성 -> updateMember(DTO);
        // 수정 결과에 따른 페이지 이동 (0 : 비밀번호 오류, 1 : 수정완료 ,-1: 아이디없음)
        // => 자바스크립트 사용 이동
        
        
        
        
        
		return null;
	}

}
