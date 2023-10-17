<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- JSTL	 => jstl core 구글링--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(1)</title>
</head>
<body>
	
	<h1>1. 변수 정의하기 (c:set)</h1>
	
	<c:set var="number1" value="100" />
	<c:set var="number2" >250</c:set>
		<%-- 위 두개 다 사용 가능! value로 정의 or <> 안에 값 넣기 --%>
	
	number1: ${number1 } <br>
	number2: ${number2 } <br>
	number1 + number2: ${number1 + number2 }	<%-- 산술이라서 숫자 아니면 에러남 --%>
	
	
	
	<h1>2. 변수 출력하기 (c:out) - escape 처리</h1>
	
	number1 : <c:out value="${number1 }" /> <br>
	<c:out value="Hello world" /> <br>
	
	<%-- 글자 그대로 나온다 => escape 처리 --%>
	<c:out value="<script>alert('얼럿 창 띄우기');</script>" /> <br>
	<c:out value="<script>alert('얼럿 창 띄우기');</script>" escapeXml="true" /> <br>
	
	<%-- 코드가 실행된다 => 얼럿창이 뜸 --%>
	<%-- <c:out value="<script>alert('얼럿 창 띄우기');</script>" escapeXml="false" /> 	--%>
	
	
	
	<h1>3. 조건문 (c:if)</h1>
	
	<c:if test="${number1 > 50 }">	 <%-- 조건이 참이면 아래 문장이 출력됨 --%>
		number1은 50보다 크다 <br>	 
	</c:if>
	
	<c:if test="${number1 == 100 }">
		number1은 100과 같다 <br>
	</c:if>
	
	<c:if test="${number1 eq 100 }">	<%-- eq는 같다는 뜻 --%>
		number1은 100과 같다 <br>
	</c:if>
	
	<c:if test="${number1 != 222 }">
		number1은 222가 아니다 <br>
	</c:if>
	
	<c:if test="${number1 ne 222 }">	<%-- ne는 같지 않다는 뜻 --%>
		number1은 222가 아니다 <br>
	</c:if>
	
	<c:if test="${empty number1 }">		<%-- 거짓이라서 아래 문장 출력 안됨 --%>
		number1은 비어있지 않다 <br>	
	</c:if>
	
	<c:if test="${!empty number1 }">	
		number1은 비어있지 않다 <br>	
	</c:if>
	
	<c:if test="${not empty number1 }">	
		number1은 비어있지 않다 <br>	
	</c:if>
	
	
</body>
</html>