<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

	<br>
		<div class="container mt-3">
			<form action="/announcement/insert" method="post">
				<div class="mb-3 mt-3">
					<label for="name">이름:</label>
					<input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
				</div>
				<div class="mb-3 mt-3">
					<label for="userId">아이디:</label>
					<input type="text" class="form-control" id="userId" placeholder="Enter userId" name="userId">
				</div>
				<div class="mb-3">
					<label for="pwd">비밀번호:</label>
					<input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
				</div>
				<div class="mb-3">
					<label for="email">이메일:</label>
					<input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
				</div>
				<button id="btn-login" class="btn btn-secondary"><spring:message code="user.login.form.login_btn"/></button>
			</form>
		</div>
<%@ include file="../layout/footer.jsp" %><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

	<br>
		<div class="container mt-3">
			<form action="/user/insertUser" method="post">
				<div class="mb-3 mt-3">
					<label for="name">이름:</label>
					<input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
				</div>
				<div class="mb-3 mt-3">
					<label for="userId">아이디:</label>
					<input type="text" class="form-control" id="userId" placeholder="Enter userId" name="userId">
				</div>
				<div class="mb-3">
					<label for="pwd">비밀번호:</label>
					<input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
				</div>
				<div class="mb-3">
					<label for="email">이메일:</label>
					<input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
				</div>
				<button id="btn-login" class="btn btn-secondary"><spring:message code="user.login.form.login_btn"/></button>
			</form>
		</div>
<%@ include file="../layout/footer.jsp" %>