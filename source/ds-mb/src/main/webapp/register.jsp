<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
	<form action="./register.controller" method="post" class="form-horizontal">
		<div class="form-group">
			<label for="account" class="col-sm-2 control-label">帳號</label>${errors.accountError}
			<div class="col-sm-5">
				<input type="text" class="form-control" name="account" id="account" placeholder="請輸入你的帳號" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">密碼</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" name="password" id="password" placeholder="請輸入你的密碼" required="required">
			</div>
		</div>

		<div class="form-group">
			<label for="passwordConfirm" class="col-sm-2 control-label">密碼確認</label>${errors.passwordConfirmError}
			<div class="col-sm-5">
				<input type="password" class="form-control" name="passwordConfirm" id="passwordConfirm" placeholder="請再次輸入你的密碼" required="required">
			</div>
		</div>
		<div class="col-sm-2 col-sm-push-2 form-group">
			<button class="btn btn-info">註冊</button>
		</div>
	</form>
</body>
</html>