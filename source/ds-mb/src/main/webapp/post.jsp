<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh_TW">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Message Board</title>
	<link href="./lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!--[if lt IE 9]>
			<script src="../assets/js/html5shiv.js"></script>
			<script src="../assets/js/respond.min.js"></script>
		<![endif]-->
	<style>
		.main-content h1 {
			margin-top: 0;
		}

		.breadcrumb {
			background-color: transparent;
		}
	</style>
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
			<div class="navbar-brand"><a href="./index.jsp">Dennis Web Test</a></div>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="./login.jsp">登入</a></li>
				<li><a href="./register.jsp">註冊</a></li>
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
					<a href="./messageBoard.jsp" class="list-group-item">最新文章</a>
					<a href="#" class="list-group-item">投票區</a>
				</div>
			</div>
			<div class="col-sm-10">
                    <form action="./messageBoard/post.controller" method="post" class="form-horizontal">
                        <div class="form-group">
                            <label for="title" class="col-sm-2 control-label">標題</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control"name="title" id="title" placeholder="請輸入文章標題" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                             <label for="content" class="col-sm-2 control-label">文章內容</label>
                             <div class="col-sm-5">
                                 <textarea name="content" class="form-control" rows="10" required="required"></textarea>
                             </div>
                         </div>
                         <div class="col-sm-2 col-sm-push-2 form-group">
                             <button class="btn btn-info">確認</button>
                         </div>
                    </form>
			</div>
		</div>
	</div>

	<script src="./lib/bootstrap/js/jquery1.11.1.js"></script>
	<script src="./lib/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>