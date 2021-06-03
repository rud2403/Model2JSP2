<%@page import="com.admin.goods.db.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1>WebContent/goods/goods_list.jsp</h1>
  
  <%
    // request.setAttribute("goodsList", gdao.getGoodsList());
    List goodsList = (List) request.getAttribute("goodsList");
  %>
  
  
  <table border="1">
    <tr>
      <td>
       <a href="./GoodsList.go">전체</a>
      </td>
      <td>
       <a href="./GoodsList.go?item=best">베스트상품</a>
      </td>
      <td>
       <a href="./GoodsList.go">외투</a>
      </td>
      <td>
       <a href="">정장/신사복</a>
      </td>
      <td>
       <a href="">티셔츠</a>
      </td>
      <td>
       <a href="">와이셔츠</a>
      </td>
      <td>
       <a href="">바지</a>
      </td>
      <td>
       <a href="">신발</a>
      </td>
    </tr>
    
    <%
      // 전체 상품 개수
      int size = goodsList.size();
      // 열의 개수
      int col =8;
      // 행의 개수 
      int row = (size/col)+((size%col>0)? 1:0);
      // 상품 출력개수 
      int num = 0;
      
      // 행
      for(int a=0;a<row;a++){
    	  %>
    	   <tr>
    	  <%
    	  // 열
    	  for(int b=0;b<col;b++){
    		  //System.out.print(" 상품1 ");
    		  GoodsDTO dto = (GoodsDTO) goodsList.get(num);
    		  %>
    		     <td>
    		         <img src="./upload/<%=dto.getImage().split(",")[0]%>"
	             	 width="120" height="120"
	          		 ><br>
	         	  	<%=dto.getName() %><br>
	           		<%=dto.getPrice() %>원  <br>
    		     </td>
    		  <%   		  
    		  num++;
    		  if(size <= num) break;
    	  }  
    	  //System.out.println();
    	  %>
    	   </tr>
    	  <%
      }
    
    
    %>
    
    
    <%-- <tr>
      <% for(int i=0;i<goodsList.size();i++){
    	  GoodsDTO dto = (GoodsDTO) goodsList.get(i);
    	  %>
       <td>
	           <img src="./upload/<%=dto.getImage().split(",")[0]%>"
	              width="120" height="120"
	           ><br>
	           <%=dto.getName() %><br>
	           <%=dto.getPrice() %>원  <br>
       </td>
      <%} %>   
    
    </tr> --%>
  
  </table>
  
  
  
  

</body>
</html>