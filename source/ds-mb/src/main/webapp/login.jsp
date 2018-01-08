<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh_TW">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	<link href="./lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!--[if lt IE 9]>
			<script src="./lib/bootstrap/js/html5shiv.js"></script>
			<script src="./lib/bootstrap/js/respond.min.js"></script>
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
					<a href="./messageBoard.controller" class="list-group-item">最新文章</a>
					<a href="#" class="list-group-item">投票區</a>
				</div>
			</div>
			<div class="col-sm-10">
                    <form action="./login.controller" method="post" class="form-horizontal">
                        <div class="form-group">
                            <label for="account" class="col-sm-2 control-label">帳號</label>${errors.errorMessage}
                            <div class="col-sm-5">
                                <input type="text" class="form-control"name="account" id="account" placeholder="請輸入你的帳號" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                             <label for="password" class="col-sm-2 control-label">密碼</label>
                             <div class="col-sm-5">
                                 <input type="password" class="form-control" name="password" id="password" placeholder="請輸入你的密碼" required="required">
                             </div>
                         </div>
                         <div class="col-sm-2 col-sm-push-2 form-group">
                             <button class="btn btn-info">登入</button>
                         </div>
                    </form>
			</div>
		</div>
	</div>

	<script src="./lib/bootstrap/js/jquery1.11.1.js"></script>
	<script src="./lib/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>