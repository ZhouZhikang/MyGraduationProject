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
<title>数据录入</title>
</head>
<body>
	<ul class="breadcrumbs">
		<li><a href="Welcome.html"><i
				class="glyphicon glyphicon-home"></i></a> <span
			class="glyphicon glyphicon-menu-right"></span></li>
		<li>数据录入</li>
	</ul>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header" style="margin: 20px 0 20px;">数据录入</h1>

				</div>
			</div>
		</div>
	</div>

	<div class="col-sm-6" style="width: 100%;">
		<div class="tabbable" style="width: 800px; margin: 0 auto;">
			<ul class="nav nav-tabs" id="myTab">
				<li class="active"><a data-toggle="tab" href="#home"> 手工录入
				</a></li>

				<li><a data-toggle="tab" href="#profile"> 表格导入 </a></li>

			</ul>

			<div class="tab-content">
				<div id="home" class="clearfix tab-pane in active">

					<label class="searchLabel">站点：</label>
					<div class="searchDiv">
						<div class="input-group">
							<input type="text" id="o" onkeyup="autoComplete.start(event)"
								class="form-control" style="border-radius: 0px;"
								placeholder="搜索站点...">
							<div class="auto_hidden" id="auto">
								<!--自动完成 DIV-->
							</div>
							<span class="input-group-btn">
								<button class="btn btn-default" id="searchBtn"
									style="padding-bottom: 7px; padding-top: 7px; border-radius: 0px;"
									type="button">搜索</button>
							</span>
						</div>
					</div>

				</div>

				<div id="profile" class="tab-pane">
					<p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla
						single-origin coffee squid.</p>
				</div>


			</div>
		</div>
	</div>
	<script>
		/* $('.nav li').click(function() {
			$(this).addClass('active').siblings('li').removeClass('active');
		}) */
	</script>
</body>
</html>