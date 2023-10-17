<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</head>
<body>


	<div class="container"> 
	
		<h1>회원가입</h1>
		
		<div class="form-group">
		
			<label for="name">이름</label>
			
			<div class="d-flex">
				<input type="text" id="name" name="name" class="form-control col-3 mr-2">
				<button type="button" class="btn btn-info" id="nameCheckBtn">중복확인</button>
			</div>
			
			<small id="nameStatusArea"></small>
			
		</div>
		
		<input type="button" id="joinBtn" class="btn btn-success" value="추가">
	
	</div>
	
	
	
	<script>
	
		$(document).ready(function() {
			
			
			// 중복 확인 버튼 클릭
			$('#nameCheckBtn').on('click', function() {
				
				// 중복확인 클릭 시 nameCheckBtn 안쪽 태그들을 초기화 => 안내문구를 하나만 띄우기 위해
				$('#nameStatusArea').empty();	// 자식 태그들을 모두 제거
				
				
				// alert("클릭");
				let name = $('#name').val().trim();		// id의 name
				
				// validation
				
				
				// 이름이 비어있는지 확인
				if (name == "") {
					
					$('#nameStatusArea').append('<span class="text-danger">이름이 비어있습니다</span>');		// append : 덧붙인다
					return;	
				}
				
				
				// 이름 중복 확인 => 서버에서 확인 (DB 조회)
				$.ajax({
					
					// request
					type:"get"	// 기본이 get 방식이라서 생략 가능
					, url:"/lesson06/ex01/is-duplication"
					, data:{"name":name}
					
					// response
					, success:function(data) {	// data는 string 이거나 JSON => dictionary
						
						// {"code":200, "is_duplication":true}
						if (data.is_duplication) {
							$('#nameStatusArea').append('<span class="text-danger">중복된 이름입니다</span>');
						}
						
					}
					, error:function(request, status, error) {
						
						alert("중복 확인에 실패했습니다");
					}
					
				});
				
				
			});
			
			
			
			// 가입 버튼 클릭
			$('#joinBtn').on('click', function() {
				
				// alert("가입");
				console.log($('#nameStatusArea').children().length);
				
				// nameStatusArea에 아무 자식 노드(태그) 가 없으면 서브밋을 한다
				if($('#nameStatusArea').children().length == 0) {
					
					alert("가입 가능");
					
				} else {
					
					alert("가입 불가");
					
				}
				
			});
			
		});
	
	</script>
	
	
</body>
</html>