<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JSTL core</h1>
	
	<h3>변수 만들기</h3>
	<%-- int number1 = 100; --%>
	<c:set var="number1" value="100" />
	<c:set var="number2">200</c:set>
	
	<h4>숫자 1 : ${number1 }</h4>
	<h4>숫자 2 : ${number2 }</h4>
	
	<h3>변수 출력하기</h3>
	<h4>숫자 1 : <c:out value="100"></c:out></h4>
	<h4>숫자 2 : <c:out value="${number2 }"></c:out></h4>
	
	<h3>조건문</h3>
	<c:if test="true">
		<h4>참이다</h4>
	
	
	</c:if>
	
	<c:if test="false">
		<h4>거짓이다</h4>
	
	</c:if>
	
	<%-- if(number1 > 50 { --%>
	<c:if test="${number1 > 50 }">
		<h4>50보다 크다</h4>
	</c:if>
	
	<%-- if(number1 == 100 --%>
	<c:if test="${number1 eq 100 }">
		<h4>100과 같다</h4>
	
	</c:if>
	
	<%-- if(number1 ==null) --%>
	<%-- null, 변수가 없다, 리스트가 비어있다, 맵이 비어있다 --%>
	<c:if test="${empty number3 }">
		<h4>number3가 비어있다</h4>
	</c:if>
	
	<c:if test="${not empty number2 }">
		<h4>number2는 값이 있다</h4>
	</c:if>

</body>
</html>