<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

	<br>
		<div class="container mt-3">
			<form action="/announcement/insert" method="post">
				<div class="mb-3 mt-3">
					<label for="companyName">회사명:</label>
					<input type="text" class="form-control" id="companyName" placeholder="Enter companyName" name="companyName">
				</div>
				<div class="mb-3 mt-3">
					<label for="announcementName">공고명:</label>
					<input type="text" class="form-control" id="announcementName" placeholder="Enter announcementName" name="announcementName">
				</div>
				<div class="mb-3 mt-3">
					<label for="job">직무:</label>
					<input type="text" class="form-control" id="job" placeholder="Enter job" name="job">
				</div>
				<div class="mb-3">
					<label for="startDate">시작일:</label>
					<input type="date" class="form-control" id="startDate" name="startDate">
				</div>
				<div class="mb-3">
					<label for="endDate">종료일:</label>
					<input type="date" class="form-control" id="endDate" name="endDate">
				</div>
				<button id="btn-insertAnnouncement" class="btn btn-secondary">등록</button>
			</form>
		</div>
<%@ include file="../layout/footer.jsp" %>