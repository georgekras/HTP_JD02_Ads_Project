<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>
<body>
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<a class="navbar-brand" href="main_action">Bonjo</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarColor01">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="main_action">Home</a></li>
					<c:if test="${user!=null && user.roles_ID==1}">
						<li class="nav-item active"><a class="nav-link"
							href="edit_users_action">Edit users</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="create_category_action">Create Category</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="edit_category_action">Edit Category</a></li>
					</c:if>
					<c:if test="${user!=null && user.roles_ID==2}">
						<li class="nav-item active"><a class="nav-link"
							href="create_ad_action">Create Ad</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="my_ads_action">My ads</a></li>
					</c:if>
				</ul>
				<ul class="navbar-nav navbar-right">
					<c:choose>
						<c:when test="${user==null}">
							<li class="nav-item active"><a class="nav-link"
								href="login_action">Login</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="signup_action">Sign Up</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item active"><a class="nav-link"
								href="profile_action">Profile</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="logout_action">Logout</a></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
		</nav>