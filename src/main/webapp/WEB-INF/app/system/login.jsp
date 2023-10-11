<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

	<br>
		<div class="container mt-3">
			<form action="/user/login" method="post">
				<div class="mb-3 mt-3">
					<label for="userId">아이디:</label>
					<input type="text" class="form-control" id="userId" placeholder="Enter userId" name="userId">
				</div>
				<div class="mb-3">
					<label for="pw">비밀번호:</label>
					<input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
				</div>
				<button id="btn-login" class="btn btn-secondary">로그인</button>
			</form>
		</div>
<%@ include file="../layout/footer.jsp" %>