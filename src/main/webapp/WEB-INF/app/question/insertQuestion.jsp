<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
	<!-- 답변의 입력은 따로 적도록 하겠음. 최대 글자수를 먼저 입력받고 하게 -->
	<br>
		<div class="container mt-3">
			<form action="/announcement/insert" method="post">
				<input type="hidden" id="announcementId" value="${announcement.id }">
				<div class="mb-3 mt-3">
					<label for="question">문항:</label>
					<input type="text" class="form-control" id="question" placeholder="Enter question" name="question">
				</div>
				<div class="mb-3 mt-3">
					<label for="maxLength">최대 글자수:</label>
					<input type="text" class="form-control" id="maxLength" placeholder="Enter maxLength" name="maxLength">
				</div>
				<button id="btn-insertQuestion" class="btn btn-secondary">등록</button>
			</form>
		</div>
<%@ include file="../layout/footer.jsp" %>