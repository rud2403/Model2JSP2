<%@page import="com.member.db.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1>WebContent/member/updateForm.jsp</h1>
  
  <%
  	MemberDTO mdto = (MemberDTO)request.getAttribute("mdto");
  %>
  
  <h2> 회원수정(Model2) </h2>
  <!-- 아이디,비밀번호, 이름,나이, 성별(라디오버튼),이메일 -->
  
  
  <fieldset>
    <legend> 아이티윌 회원가입 페이지 </legend>
    <form action="./MemberUpdateProAction.me" method="post">
      아이디 : <input type="text" name="id" value="${mdto.id }"><br>
      비밀번호 : <input type="password" name="pass" placeholder="비밀번호를 입력하시오."><br>
      이름 : <input type="text" name="name" value="${mdto.name }"><br>
      나이 : <input type="number" name="age" value="${mdto.age }"><br>
      성별 : <input type="radio" name="gender" value="남"
      <c:if test="${mdto.gender eq '남' }">
       checked="checked"
   	  </c:if>> 남
   	  
      <input type="radio" name="gender" value="여"
      <c:if test="${mdto.gender eq '여' }">
       checked="checked" 
   	  </c:if>> 여<br>
   	  
      이메일 : <input type="email" name="email" value="${mdto.email }"><br>
      <hr>
     <input type="submit" value="회원수정">           
    
    </form>  
  </fieldset>
  
  

</body>
</html>