<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>
<div align="center">
	<br>
	<div class="container">
		<div class="page-header">
			<h2>Create AD</h2>
		</div>
		<br>
		<form class="form-horizontal" action="create_ad_action" method="post">
			<fieldset>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="Title">Title</label>
					<div class="col-md-4">
						<input id="Title" name="ad_title" type="text" placeholder=""
							class="form-control input-md" required="" value="test">
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="category_ID">Category</label>
					<div class="col-md-4">
						<select id="name" name="ad_category_id" class="form-control">
							<c:forEach items="${categories_list}" var="category">
								<option value="${category.ID}" role=${category.ID
									}
									${category.ID==ad.category_ID?"selected":""}>
									${category.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="SmallDesc">Small
						Description</label>
					<div class="col-md-4">
						<input id="SmallDesc" name="ad_smalldesc" type="text"
							placeholder="" class="form-control input-md" required=""
							value="test">
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="Description">Description</label>
					<div class="col-md-4">
						<textarea id="Description" name="ad_description" type="text"
							maxlength="100" placeholder="" class="form-control input-md"
							required="">test</textarea>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="Price">Price</label>
					<div class="col-md-2">
						<input id="Price" name="ad_price" type="text" placeholder=""
							class="form-control input-md" value="333">
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4">
						<button id="singlebutton" name="singlebutton"
							class="btn btn-outline-primary">Submit</button>
					</div>
				</div>

			</fieldset>
		</form>

		<c:if test="${msg!=null}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${msg}"></c:out>
			</div>
		</c:if>
	</div>
</div>
<%@ include file="/include/end-html.jsp"%>