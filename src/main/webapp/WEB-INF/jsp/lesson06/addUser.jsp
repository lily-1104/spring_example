<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- AJAX를 사용하려면 반드시 jquery 원본 필요, 부트스트랩 slim 버전 지우기  -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container"> 	<!-- container는 가운데 정렬 -->
	
		<h1>회원가입</h1>
		
		<%-- <form method="post" action="/lesson06/ex01/add-user">	--%>
			
			<div class="form-group">	<!-- form-group : 모양 없음, 항목들을 그룹으로 묶음 -->
				<label for="name">이름</label>
				<input type="text" id="name" name="name" class="form-control col-3">	
										<!-- name은 꼭 있어야함, Request Parameter의 명이 name에 들어감 -->
			</div>
			
			<div class="form-group">
				<label for="yyyymmdd">생년월일</label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-3">	
			</div>
			
			<div class="form-group">
				<label for="email">이메일</label>
				<input type="text" id="email" name="email" class="form-control col-3">	
			</div>
			
			<div class="form-group">
				<label for="introduce">자기소개</label>
				<textarea id="introduce" name="introduce" class="form-control col-5"></textarea>
			</div>
			
			<!--  <input type="submit" class="btn btn-info" value="회원가입">	-->
			<%-- ★★★ AJAX 통신일 때는 반드시 button 타입으로 설정한다 --%>
			<input type="button" id="joinBtn" class="btn btn-success" value="추가">
			
		<%-- </form>	--%>
		
	</div>
	
	
	<script>
	
		$(document).ready(function() {
			
				
			/*
			// 1) jquery submit 기능 이용하기 (form 태그 사용)
			$("form").on("submit", function(e) {	// e 꼭 쓰기!!
				
				 e.preventDefault();	// 폼태그 동작 막음
				
				// alert("폼태그 동작");
				
				// validation check
				let name = $("#name").val().trim();
				if (name == "") {
					alert("이름을 입력하세요");
					return false;	// submit 안함 (그냥 return 하면 submit 수행됨)
				}
				
				let yyyymmdd = $("#yyyymmdd").val().trim();
				if (yyyymmdd.length < 1) {
					alert("생년월일을 입력하세요");
					return false;	// submit 안함
				}
				
				let email = $('input[name=email]').val().trim();	// 위에꺼랑 같음, 이렇게 써도 됨
				if (!email) {	// !email = 값이 안채워져있다
					alert("이메일을 입력하세요")
					return false;	// submit 안함
				}
				
				// 여기까지 도달하면 submit 수행 
				
				
			});
			*/
			
			
			// 2) jquery의 AJAX 통신 이용하기
			$('#joinBtn').on('click', function() {
				
				// alert("버튼 클릭");
				
				// validation check
				let name = $("#name").val().trim();
				if (name == "") {
					alert("이름을 입력하세요");
					return;	// submit 안함 (그냥 return 하면 submit 수행됨)
				}
				
				let yyyymmdd = $("#yyyymmdd").val().trim();
				if (yyyymmdd.length < 1) {
					alert("생년월일을 입력하세요");
					return;	// submit 안함
				}
				
				let email = $('input[name=email]').val().trim();	// 위에꺼랑 같음, 이렇게 써도 됨
				if (!email) {	// !email = 값이 안채워져있다
					alert("이메일을 입력하세요")
					return;	// submit 안함
				}
				
				let introduce = $('#introduce').val();
				
				console.log(name);
				console.log(yyyymmdd);
				console.log(email);
				console.log(introduce);
				
				
				// AJAX : 서버 요청
				$.ajax({
					
					// request
					type:"POST"		// 생략하면 get으로 보내짐 (type은 반드시 소문자, POST는 대소문자 상관 X)
					, url: "/lesson06/ex01/add-user"	// 맨 앞에 / 꼭 쓰기!
					, data:{"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce}	  // JSON으로 보내서 String이기 때문에 항상 따옴표로 묶여있어야 함
								// 뒤의 name은 위의 let name의 name
					
					// response
					// call back 함수
					, success:function(data) {	// data: response의 결과 응답
						
						// 서버 처리 후 에러가 없을 때 수행됨
						// alert(data);	// 값이 있는지 확인
						if (data == "성공") {
							
							location.href = "/lesson06/ex01/get-latest-user";
						}
					}
					, complete:function(data) {
						
						// 성공이던 실패던 무조건 불려짐 => 안씀! (있다는 것만 알아두기)
						alert(data);
					}
					
					, error:function(request, status, error) {
						
						// 에러일 때 수행됨 (400, 500 에러 전부 포함)
						alert(request);
						alert(status);
						alert(error);
					}
					
				});
				
			});
		});
	
	</script>

</body>
</html>