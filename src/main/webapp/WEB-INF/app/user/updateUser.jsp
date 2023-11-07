<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

	<br>
		<div class="container mt-3">
			<form>
				<div class="mb-3 mt-3">
					<label for="name">이름:</label>
					<input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="${principal.name}">
				</div>
				<div class="mb-3 mt-3">
					<label for="userId">아이디:</label>
					<input type="text" class="form-control" id="userId" placeholder="Enter userId" name="userId" value="${principal.userId}">
				</div>
				<div class="mb-3">
					<label for="pw">비밀번호:</label>
					<input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw" value="${principal.pw}">
				</div>
				<div class="mb-3">
					<label for="email">이메일:</label>
					<input type="email" class="form-control" id="email" placeholder="Enter email" name="email"  value="${principal.email}">
				</div>
			</form>
			<button id="btn-updateUser" class="btn btn-secondary">수정</button> <!-- 이거 form 태그 바깥으로 꺼내줘야 ajax로 리디렉트 제대로 됨. 이유는 솔직히 잘모름 @RequestBody 그런거랑 관련된거같은데 -->
		</div>
		<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>