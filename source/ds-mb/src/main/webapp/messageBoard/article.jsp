<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
	<form action="${context}/post.jsp" method="post" class="form-horizontal">
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
</body>
</html>