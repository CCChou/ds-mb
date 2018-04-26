<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>文章名稱</th>
				<th>作者</th>
				<th>發表日期</th>
			</tr>
			<c:forEach var="article" items="${articleBeans}">
				<tr>
					<th><a href="./messageBoard/article.controller?id=${article.id}">${article.title}</a></th>
					<th>${article.account}</th>
					<th>${article.date}</th>
				</tr>
			</c:forEach>
		</thead>
		<tbody>

		</tbody>
	</table>
	<div class="text-center">
		<ul class="pagination">
			<c:forEach var="page" items="${pages}">
				<!-- present page active -->
				<li><a href="./search.controller?page=${page}&condition=${condition}">${page}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>