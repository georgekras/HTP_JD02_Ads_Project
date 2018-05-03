<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">

<title>Каталог автомобилей</title>

</head>

<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo01"
				aria-controls="navbarTogglerDemo01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
				<a class="navbar-brand" href="do?action=main_action">Каталог
					автомобилей</a>
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">



				</ul>
				<div align="right">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0" align="right">

						<c:if test="${user==null }">
							<li class="nav-item active"><a class="nav-link"
								href="do?action=login_action">Войти</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="do?action=signup_action">Зарегистрироваться</a></li>
						</c:if>

						<c:if test="${user!=null }">
							<li class="nav-item active"><a class="nav-link"
								href="do?action=profile_action">Профиль</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="do?action=logout_action">Выйти</a></li>
						</c:if>

					</ul>
				</div>
			</div>
		</nav>
	</header>
	<div class="container">