<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
	<br>
		<div class="container mt-3">
			<form action="/announcement/insert" method="post">
				<input type="hidden" id="announcementId" value="${announcement.id }">
				<c:forEach var="question" items="${announcement.questionList }">
					<input type="hidden" id="questionId" value="${question.id }">
					<div class="mb-3 mt-3">
						<label for="question">문항:</label>
						<div class="mb-3 mt-3">
							<div>${question.question }</div>
						</div>
					</div>
					<div class="mb-3 mt-3">
						<label for="question">답변:</label>
						<div class="mb-3 mt-3">
							<textarea rows="" cols="">
								${question.answer }
							</textarea>
						</div>
					</div>
					<div class="mb-3 mt-3">
						<label for="maxLength">최대 글자수:</label>
						<p>
					</div>
				</c:forEach>
				<button id="btn-insertQuestion" class="btn btn-secondary">등록</button>
			</form>
		</div>
<%@ include file="../layout/footer.jsp" %>