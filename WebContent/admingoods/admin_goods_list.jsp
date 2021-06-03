<%@page import="com.admin.goods.db.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>WebContent/admingoods/admin_goods_list.jsp</h1>
  
  <h2> 등록 상품 목록 </h2>
  
  <h3><a href="./GoodsAdd.ag">상품 등록하기</a></h3>
  
 <%
    // 전달된 정보(공유된속성)
    // request.setAttribute("goodsList", goodsList);
    
    List goodsList = (List)request.getAttribute("goodsList");
  
    request.setAttribute("goodsList", goodsList);
    
  %> 
  

  <table border="1">
     <tr>
       <td>번호</td>
       <td>카테고리</td>
       <td>사진</td>
       <td>상품명</td>
       <td>가격</td>
       <td>수량</td>
       <td>등록일자</td>
       <td>수정/삭제</td>
     </tr>
     

     
     <c:forEach var="i" items="${ goodsList }">
	     <tr>
	       <td>${ i.num}</td>
	       <td>${ i.category}</td>
	       <td>
	         <img src="./upload/${i.image.split(',')[0] }"
	             width="100" height="100" >
	       </td>
	       <td>${ i.name}</td>
	       <td>${ i.price}</td>
	       <td>${ i.amount}</td>
	       <td>${ i.date}</td>
	       <td>
	       
	       <a href="./AdminGoodsModify.ag?num=${ i.num}">수정</a>/<a href="./AdminGoodsDelete.ag?num=${ i.num}">삭제</a>
	       
	       </td>
	     </tr>
     </c:forEach>

  </table>
  

</body>
</html>