<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
	<br>
		<div class="container mt-3">
		
			<form action="/announcement/insert" method="post">
				<div class="mb-3 mt-3">
					<label for="question">문항:</label>
				</div>
				<div class="mb-3 mt-3">
					<label for="maxLength">최대 글자수:</label>
				</div>
				<button id="btn-insertQuestion" class="btn btn-secondary">등록</button>
			</form>
		</div>
<%@ include file="../layout/footer.jsp" %>