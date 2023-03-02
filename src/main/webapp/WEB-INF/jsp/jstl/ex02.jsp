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
	<h1>JSTL Core</h1>
	
	<h2>if else</h2>
	<%--  --%>
	
	<c:set var="weight" value="73" />
	
	<c:choose>
		<c:when test="${weight <= 70 }">
			<h4>치킨</h4>
		</c:when>
		
		<c:when test="${weight <=80 }">
			<h4>샐러드</h4>
		</c:when>
		
		<c:otherwise>
			<h4>굶어</h4>
		</c:otherwise>
	
	</c:choose>
	
	<h2>반복문</h2>
	
	<c:forEach var="i" begin="0" end="4" step="1">
		${i }
	
	
	</c:forEach>
	
	<c:forEach var="fruit" items="${fruitList }">
		<h4>${fruit } :::: ${status }</h4>
	
	</c:forEach>
	
</body>
</html>