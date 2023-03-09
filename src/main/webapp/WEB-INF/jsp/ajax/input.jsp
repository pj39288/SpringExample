<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.6.3.min.js"
  integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
  crossorigin="anonymous"></script>
 <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--<form method="get" action="/ajax/add"> --%>
	
		<label>이름</label><input type="text" name="name" id="nameInput"> <br>
		<label>생년월일</label><input type="text" name="birthday" id="birthdayInput"> <br>
		<label>이메일</label><input type="text" name="email" id="emailInput"><button type="button" id="duplicateBtn">중복확인</button> <br>
		<label>자기소개</label><input type="text" name="introduce" id="introduceInput"> <br>
		<button type="submit" id="addBtn">추가</button>
	 
	<%-- </form>--%>
	
	<script>
		$(document).ready(function() {
			
			$("#duplicateBtn").on("click", function(){
				
				let email = $("#emailInput").val();
				
				if(email=""){
					alert("이메일을 입력하세요");
					return;
				}
				
				$.ajax({
					type:"get"
					, url:"/ajax/is_duplicate"
					, data:{"email":email}
					, success:function(date) {
						if(data.is_duplicate){
							// 중복 경우
							alert("중복되었습니다");
						} else {
							// 중복아닌경우
							alert("사용가능한 이메일입니다");
						}
						
					}
					, error:function() {
						alert("중복확인 에러");
					}
					
				});
				

			});
			
			
			// $("#addBtn").on("click", function() {
				$("#addForm").on("submit", function() {
				let name = $("#nameInput").val();
				let birthday = $("#birthdayInput").val();
				let email = $("#emailInput").val();
				let introduce = $("#introduceInput").val();

				if(name==""){
					alert("이름을 입력하세요");
					return;
				}
				
				if(birthday=""){
					alert("생년월일을 입력하세요");
					return;
				}
				
				if(email=""){
					alert("이메일을 입력하세요");
					return;
				}
				
				if(introduce=""){
					alert("자기소개를 입력하세요");
					return;
				}
				
				$.ajax({
					type:"get"
					, url:"/ajax/add"
					, data:{"name":name, "birthday":birthday, "email":email, "introduce":introduce}
					, success:function(data){
						// 성공 : {"result":"success"}
						// 실패 : {"result":"fail"}
						if(data.result == "success"){
							// 리스트 페이지로 이동
							location.href="/ajax/user";
							
						} else {
							alert("추가 실패");
						}
						
					}
					, error:function(){
						alert("추가 에러");	
					
					}
					
					
					
					
				});
				
		
			});
	
		});
	
	
	</script>

</body>
</html>