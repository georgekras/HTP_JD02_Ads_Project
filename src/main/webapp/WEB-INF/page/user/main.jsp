<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<c:out value="${msg}"></c:out>
<div class="row">
	<div class="col-md-12"></div>

	<c:forEach items="${brands}" var="brand">

		<div class="col-md-2" align="center">
			<br> <img
				src="http://carsicons.com/wp-content/uploads/ktz/audi_logo_hd_desktop_background-316nj4eenp1igmt3emznk0.jpg"
				height="120" align="middle" alt="альтернативный текст"> <a
				href="#">${brand.brand}</a>
		</div>

	</c:forEach>

</div>

<%@ include file="../include/end-html.jsp"%>