<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh_TW">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Index</title>
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
				<c:choose>
					<c:when test = "${not empty loginedAccount}">
						<li><a href="#">${loginedAccount}</a></li>
						<li><a href="./logout.controller">登出</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="./login.jsp">登入</a></li>
						<li><a href="./register.jsp">註冊</a></li>
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
					<a href="./messageBoard.jsp" class="list-group-item">最新文章</a>
					<a href="#" class="list-group-item">投票區</a>
				</div>
			</div>
			<div class="col-sm-10 main-content">
				<h1>用 CSS3 畫理髮廳動態廣告跑馬燈</h1>
				<img src="img/light.png" alt="" class="img-responsive img-border">
				<p>Amos 好久沒有用 CSS3 畫些好玩的 CSS3 小範例了，距離上次用 CSS3 繪製精美的膠囊 也已經快滿一年了(哇！也偷懶太久了吧)，趁著一個假日，跟好友 Fran 大師借了張他許久前畫的圖來試著畫看看，當初 Fran 大師曾經問過我是否有辦法製作圓型的漸層，當時看到這圖片時還想不到怎麼做出那顆金屬球體，現在想到了做法就來刻看看囉．</p>
				<p>首先我們來看看整體的 html div 標籤使用了幾個，在這個例子中為了一些小細節的處理，原本只規劃了使用2~3個 div 去處理，但最後為了眾多的細節而不得不把 div 添加到了四個之多，以下是這次使用到的 html 標籤結構，分成理髮廳廣告燈的主體以及上下金屬球＋跑馬燈圓柱體。</p>
				<h2>CSS3 理髮廳跑馬燈的11個細節</h2>
				<p>在撰寫這個範例的過程中，有些小細節是慢慢刻出來的，對於畫面中的光影折射合理性，在過程中慢慢地去修正與添加不同位置的陰影與色彩，另一方面也考量到 CSS 原始碼的簡潔度(我還不習慣用 sass 刻 code )，整體大概花費了我4個小時去處理完成這個作品，其實到現在都還是覺得尚有細節可以去修正，但是也都只是錦上添花罷了，就先公開分享給大家看看囉～</p>
				<h2>理髮廳跑馬燈的金屬球光線左右不是對稱的</h2>
				<p>在這邊 Amos 先預設光線是從右上角往左下角打，所以光線的話，應該是右邊亮的部位比較多，而左邊亮的部位比較少，所以在設定這個部分的時候，把左右兩邊的明暗設定為不同，而這部分的色彩應用方式原本是想採用 CSS3 的 radial-gradient
					來製作，但是後面不論怎麼修改都不符合 Amos 所要的視覺效果，所以後面 Amos 改用了另外一種寫法，先讓 Amos 賣個關子一下，各位可以試著思考看看是否有其他 CSS3 屬性可以達到類似的效果的，老實說這做法連 Amos 自己都覺得很偏門XD，而且這是我撰寫
					CSS3 上覺得最困難呈現的地方了．</p>
			</div>
		</div>
	</div>

	<script src="./lib/bootstrap/js/jquery1.11.1.js"></script>
	<script src="./lib/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>