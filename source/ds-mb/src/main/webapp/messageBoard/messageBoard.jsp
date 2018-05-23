<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<form action="${context}/messageBoard/post.jsp" method="post" class="form-horizontal">
		<div class="form-group">
			<button class="btn btn-info">發新文章</button>
		</div>
	</form>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>文章名稱</th>
				<th>作者</th>
				<th>發表日期</th>
			</tr>
			<c:forEach var="article" items="${articleBeans}">
				<tr>
					<th><a href="${context}/messageBoard/article.controller?id=${article.id}">${article.title}</a></th>
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
				<li class="${page == currentPage ? 'active' : ''}"><a href="${context}/messageBoard.controller?page=${page}">${page}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>