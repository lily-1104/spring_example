<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- JSTL	 => jstl core 구글링--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(2)</title>
</head>
<body>

	<h1>1. 조건문 (c:choose, c:when,  c:otherwise)</h1>
	
	<c:set var="weight" value="65" />
	
	<c:choose>
		<c:when test="${weight < 60 }">	<%-- 정확한 조건이 있을 때 when 사용 --%>
			치킨 먹자
		</c:when>
		
		<c:when test="${weight < 70 }">
			샐러드 먹자
		</c:when>
		
		<c:otherwise>	<%-- 자바로치면 else 라서 test 조건 안붙음 --%>
			굶자
		</c:otherwise>
	</c:choose>
	
	
	
	<h1>2. 반복문 (c:forEach)</h1>
	
	<c:forEach begin="0" end="5" step="1" var="i">	<%-- begin : 시작값 / end : 끝 값 / step : 증가--%>
		${i }
	</c:forEach>
	
	<br>
	
	<%-- 16부터 20까지--%>
	<c:forEach begin="16" end="20" step="1" var="j" varStatus="status">	<%-- varStatus : 반복문이 도는 현황을 알려주는 객체 --%>
		var:${j } current:${status.current } first:${status.first }
		last:${status.last }	<%-- 가장 마지막에 돈 반복문만 true 뜸 --%>
		count:${status.count }
		index:${status.index }
		<br>
	</c:forEach>
	
	
	
	<%-- 서버에서 가져온 List<String> 출력 --%>
	<c:forEach items="${fruits }" var="fruit" varStatus="status">
		${fruit } ::::: ${status.count } ${status.index }	<%-- :::::는 그냥 구분 짓기 용 (의미 X) --%>
	</c:forEach>
	
	
	
	<%-- 서버에서 가져온 List<Map> 출력 --%>
	<c:forEach items="${users }" var="user" varStatus="status">
		<h3>${status.count }번째 사람 정보</h3>		<%-- count 하면 1부터 조회됨 --%>
		이름 : ${user.name } <br>
		나이 : ${user.age } <br>
		취미 : ${user.hobby }
	</c:forEach>
	
	
	
	<table border="1">
		
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>취미</th>
			</tr>		
		</thead>
		
		<tbody>
			<c:forEach items="${users }" var="user" varStatus="status">		<%-- forEach로 묶으면 안에 <tr>이 반복됨 --%>
			<tr>
				<td>${status.count }</td>
				<td>${user.name }</td>
				<td>${user.age }</td>
				<td>${user.hobby }</td>
			</tr>
			</c:forEach>
		</tbody>
	
	</table>
	
	
</body>
</html>