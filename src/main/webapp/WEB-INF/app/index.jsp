<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./layout/header.jsp" %>
	<div class="container mt-3">
		<c:if test="${!empty announcementList }">
			<div class="card">
				<c:forEach var="announcement" items="${announcementList.content }">
					<div class="card-body">
						<h4 class="card-title">${announcement.companyName }</h4>
						<h4 class="card-title">${announcement.announcementName }</h4>
						<h4 class="card-title">${announcement.job }</h4>
						<p class="card-text">${announcement.startDate } ~ ${announcement.endDate }</p>
						<a href="/announcement/${announcement.id }" class="btn btn-secondary">상세 보기</a>
					</div>
				</c:forEach>
			</div>
			<ul class="pagination justify-content-between">
				<li class="page-item <c:if test="${announcementList.first }">disabled</c:if>"><a class="page-link" href="?page=${announcementList.number - 1 }">이전 페이지</a></li>
				<li class="page-item <c:if test="${announcementList.last }">disabled</c:if>"><a class="page-link" href="?page=${announcementList.number + 1 }">다음 페이지</a></li>
			</ul>
		</c:if>
	</div>
<%@ include file="./layout/footer.jsp" %>