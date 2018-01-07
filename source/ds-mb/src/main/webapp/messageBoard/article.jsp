<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh_TW">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Article</title>
	<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!--[if lt IE 9]>
			<script src="../lib/bootstrap/js/html5shiv.js"></script>
			<script src="../lib/bootstrap/js/respond.min.js"></script>
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
			<div class="navbar-brand"><a href="../index.jsp">Dennis Web Test</a></div>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test = "${not empty loginedAccount}">
						<li><a href="#">${loginedAccount}</a></li>
						<li><a href="../logout.controller">登出</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="../login.jsp">登入</a></li>
						<li><a href="../register.jsp">註冊</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>


	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-push-8">
				<div class="input-group">
						<input type="text" class="form-control" placeholder="請輸入關鍵字">
						<span class="input-group-btn">
							<button class="btn btn-info" type="button">搜尋</button>
						</span>
				</div>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-sm-2">
				<div class="list-group">
					<a href="../messageBoard" class="list-group-item">最新文章</a>
					<a href="#" class="list-group-item">投票區</a>
				</div>
			</div>
			<div class="col-sm-10">
				<form action="../post.jsp" method="post" class="form-horizontal">
					<div class="form-group">
                        <button class="btn btn-info">發新文章</button>
               		</div>
                </form>
                <div class="page-header">
                	<h1>${articleBean.title}</h1>
                </div>
               		<table class="table table-hover">
               			<tbody>
               				<tr>
               					<th>作者: ${articleBean.account}</th>
               					<th>發表時間: ${articleBean.date}</th>
               				</tr>
               				<tr>
               					<th>${articleBean.content}</th>
               				</tr>
               			</tbody>
               		</table>
			</div>
		</div>
	</div>

	<script src="../lib/bootstrap/js/jquery1.11.1.js"></script>
	<script src="../lib/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>