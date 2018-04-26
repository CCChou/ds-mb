<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh_TW">

<c:set var="context" value="${pageContext.request.contextPath}"/>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Index</title>
	<link href="${context}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!--[if lt IE 9]>
			<script src="${context}/lib/bootstrap/js/html5shiv.js"></script>
			<script src="${context}/lib/bootstrap/js/respond.min.js"></script>
		<![endif]-->
</head>

<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<!-- 漢堡要設定這個才會出現  target 要與下方 collapse 部分搭配 才吃的到 JS 效果-->
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="sr-only">導覽列開關</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="navbar-brand"><a href="${context}/index.jsp">Dennis Web Test</a></div>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test = "${not empty loginedAccount}">
						<li><a href="#">${loginedAccount}</a></li>
						<li><a href="${context}/logout.controller">登出</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${context}/login.jsp">登入</a></li>
						<li><a href="${context}/register.jsp">註冊</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>


	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-push-8">
				<form action="${context}/search.controller" method="get" class="form-horizontal">
					<div class="input-group">
						<input type="text" class="form-control" name="condition" placeholder="請輸入關鍵字">
						<span class="input-group-btn">
							<input type="submit" class="btn btn-info" value="搜尋"/>
						</span>
					</div>
				</form>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-sm-2">
				<div class="list-group">
					<a href="${context}/messageBoard/messageBoard.controller" class="list-group-item">最新文章</a>
					<a href="#" class="list-group-item">投票區</a>
				</div>
			</div>
			<div class="col-sm-10">
				<sitemesh:write property="body"/>
			</div>
		</div>
	</div>

	<script src="${context}/lib/bootstrap/js/jquery1.11.1.js"></script>
	<script src="${context}/lib/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>