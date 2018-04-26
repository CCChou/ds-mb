<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
	<form action="${context}/messageBoard/post.controller" method="post" class="form-horizontal">
		<div class="form-group">
			<label for="title" class="col-sm-2 control-label">標題</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" name="title" id="title"
					placeholder="請輸入文章標題" required="required">
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
</body>
</html>