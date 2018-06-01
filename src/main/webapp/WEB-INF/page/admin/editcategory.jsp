<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>
<div align="center">
	<br>
	<div class="container">
		<div class="row">
			<div class=col-md-2>ID</div>
			<div class=col-md-4>Name</div>

		</div>
	</div>

	<div class="container">
		<c:forEach items="${categories}" var="category">
			<form class="form-horizontal" action="do?command=EditCategory"
				method=post>
				<div class="row">
					<div class=col-md-2>
						<input id="ID" class="form-control input-md" name="ID"
							value="${category.ID}" />
					</div>
					<div class=col-md-4>
						<input id="name" class="form-control input-md" name="Name"
							value="${category.name}" />
					</div>
					<div class=col-md-1>
						<button id="Update" value="Update" name="Update"
							class="btn btn-success">Update</button>
					</div>

					<div class=col-md-1>
						<button id="Delete" value="Delete" name="Delete"
							class="btn btn-danger">Delete</button>
					</div>
				</div>
			</form>
			<br>
		</c:forEach>
	</div>
</div>
<%@ include file="/include/end-html.jsp"%>