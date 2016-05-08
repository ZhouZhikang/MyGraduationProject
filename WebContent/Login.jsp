<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="JavaScript/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="JavaScript/MyCSS/sb-admin.css" rel="stylesheet">
<link href="JavaScript/MyCSS/style.default.css" rel="stylesheet">
<link href="JavaScript/MyCSS/data.css" rel="stylesheet">
<link
	href="JavaScript/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css"
	rel="stylesheet">
<script type="text/javascript" src="JavaScript/jquery-2.2.1.min.js"></script>
<script type="text/javascript"
	src="JavaScript/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="JavaScript/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="JavaScript/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="JavaScript/myJS.js"></script>
<script type="text/javascript" src="JavaScript/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="JavaScript/responsive-tables.js"></script>
<link href="JavaScript/MyCSS/signin.css" rel="stylesheet">
<title>数据录入</title>
</head>
<body>

	<div class="container">
		<h1 class="form-signin-heading-h1">基于大数据的城市防汛预警系统</h1>
		<div class="tabbable" style="width: 400px; margin: 0 auto;">
			<ul class="nav nav-tabs" id="myTab">
				<li id="enter1" class="active"><a data-toggle="tab"
					href="#home"> 登录 </a></li>

				<li id="enter2"><a data-toggle="tab" href="#profile"> 注册 </a></li>

			</ul>

			<div class="tab-content" style="padding-bottom: 50px;">
				<div id="home" class="clearfix tab-pane in active">
					<div class="form-signin">
						<div class="userName_div">
							<input id="loginName" class="form-control" name="userName"
								placeholder="账号" />
							<div class="nullName">请输入账号</div>
							<div class="errorName">账号不存在</div>
						</div>
						<div class="userName_div">
							<input id="loginPwd" class="form-control" type="password"
								name="userPassword" placeholder="密码" />
							<div class="nullPwd">请输入密码</div>
							<div class="errorPwd">密码错误</div>
						</div>
						<button id="login" class="btn btn-lg btn-primary btn-block"
							style="-webkit-border-radius: 0px; -moz-border-radius: 0px; border-radius: 0px; margin-top: 10px;">登录</button>
					</div>
				</div>

				<div id="profile" class="tab-pane">
					<div class="form-signin">
						<div class="userName_div">
							<input id="signUpName" class="form-control" name="userName"
								placeholder="注册账号" />
							<div class="nullSignUpName">请输入账号</div>
							<div class="exsitName">账号已注册</div>
							<div class="availableName">
								<span class="glyphicon glyphicon-ok"></span> 账号可用
							</div>
						</div>
						<div class="userName_div">
							<input id="signUpPwd" class="form-control" type="password"
								name="userPassword" placeholder="密码" />
							<div class="nullSignUpPwd">请输入密码</div>
						</div>
						<div class="userName_div">
							<input id="signUpPwd2" class="form-control" type="password"
								name="userPassword2" placeholder="确认密码" />
							<div class="nullSignUpPwd2">两次密码不一致</div>
						</div>
						<button id="signup" class="btn btn-lg btn-primary btn-block"
							style="-webkit-border-radius: 0px; -moz-border-radius: 0px; border-radius: 0px; margin-top: 10px;">注册</button>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript">
		var signupname = 0;
		var signuppwd = 0;
		$('#signUpName').blur(function() {//注册账号输入框失去焦点的时候即可执行
			if ($('#signUpName').val() == "") {
				$('.nullSignUpName').show();
			} else {
				$('.nullSignUpName').hide();
				params = {
					userName : $('#signUpName').val(),//获取账号
				};
				$.ajax({
					type : "POST",
					dataType : "json",
					url : "checkSame.action",
					data : params,
					success : function(data) {
						console.log(data['status']);
						if (data['status'] == "1") {
							$('.exsitName').show();//显示账号已被注册
						} else {
							$('.availableName').show();//显示账号可以使用
							signupname = 1;
						}
					}
				});
			}
		});
		$('#loginName').blur(function() {
			if ($('#loginName').val() == "") {
				$('.nullName').show();
			} else {
				$('.nullName').hide();
			}
		});
		$('#loginName').focus(function() {
			$('.nullName').hide();
			$('.errorName').hide();
		});
		$('#signUpName').focus(function() {
			$('.nullSignUpName').hide();
			$('.exsitName').hide();
			$('.availableName').hide();
		});
		$('#signUpPwd').focus(function() {
			$('.nullSignUpPwd').hide();
		});
		$('#loginPwd').focus(function() {
			$('.nullPwd').hide();
			$('.errorPwd').hide();
		});
		$('#loginPwd').blur(function() {
			if ($('#loginPwd').val() == "") {
				$('.nullPwd').show();
			} else {
				$('.nullPwd').hide();
			}
		});
		$('#signUpPwd').blur(function() {
			if ($('#signUpPwd').val() == "") {
				$('.nullSignUpPwd').show();
			} else {
				$('.nullSignUpPwd').hide();
			}
		});
		$('#signUpPwd2').blur(function() {
			if ($('#signUpPwd').val() != $('#signUpPwd2').val()) {
				$('.nullSignUpPwd2').show();
			} else {
				$('.nullSignUpPwd2').hide();
				signuppwd = 1;
			}
		});

		$('#signup').click(function() {
			if (signupname == 1 && signuppwd == 1) {
				params = {
					userName : $('#signUpName').val(),//获取账号
					userPassword : $('#signUpPwd2').val(),//获取密码
				};
				$.ajax({
					type : "POST",
					dataType : "json",
					url : "signUp.action",
					data : params,
					success : function(data) {
						url = "Login.jsp";
						location.href = url;//跳转至主页面
					}
				});
			}});

		$('#login').click(function() {
			params = {
				userName : $('#loginName').val(),//获取账号
				userPassword : $('#loginPwd').val(),//获取密码
			};
			if ($('#loginPwd').val() == "") {
				$('.nullPwd').show();
			} else if ($('#loginPwd').val() != "") {
				$('.nullPwd').hide();
				if ($('#loginPwd').val() == "") {
					$('.nullPwd').show();
				} else if ($('#loginPwd').val() != "") {
					$('.nullPwd').hide();
					$.ajax({
						type : "POST",
						dataType : "json",
						url : "login.action",
						data : params,
						success : function(data) {
							$('.errorPwd').hide();
							$('.errorName').hide();
							if (data['status'] == "用户名错误") {
								$('.errorName').show();//显示用户名错误提示
							} else if (data['status'] == "密码错误") {
								$('.errorPwd').show();//显示密码错误提示
							} else if (data['status'] == "验证通过") {
								url = "Homepage.jsp";
								setCookie('username',$('#loginName').val(),1);
								location.href = url;//跳转至主页面
							}
						}
					});
				}
			}
		});
		function setCookie(c_name,value,expiredays)
		{
		var exdate=new Date()
		exdate.setDate(exdate.getDate()+expiredays)
		document.cookie=c_name+ "=" +escape(value)+
		((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
		}
	</script>
</body>
</html>