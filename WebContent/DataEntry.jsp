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

			<div class="tab-content" style="padding-bottom: 50px;">
				<div id="home" class="clearfix tab-pane in active">
					<div class="myfloat">
						<p id="stationType" style="display: none;padding-left: 180px;padding-bottom: 5px;"></p>
						<div class="labelDiv">
							<label class="myLabel">站点</label>
						</div>
						<div class="input_div">
							<div class="input-group">
								<input type="text" id="o" onkeyup="autoComplete.start(event)"
									class="form-control no_radius" placeholder="选择录入的站点...">
								<div class="auto_hidden" id="auto">
									<!--自动完成 DIV-->
								</div>
							</div>
						</div>
						<label id="station_error" class="error_message">请选择一个站点</label>
					</div>
					<!-- 					<div id="loding_img"
						style="margin-top: 30px; text-align: center; width: 330px; display: none;">
						<img src="../MyGraduationProject/Images/loader28.gif" />
					</div> -->
					<div class="myfloat" style="display: none;">
						<div class="labelDiv">
							<label class="myLabel">记录时间</label>
						</div>
						<div class="input_div">
							<div class="input-group date form_datetime col-md-1.5"
								data-link-field="dtp_input1">
								<input id="datetimepicker" class="no_radius form-control"
									size="16" type="text" value="" readonly placeholder="输入时间...">
							</div>
							<input type="hidden" id="dtp_input1" value="" /><br />
						</div>
						<label id="time_error" class="error_message">请选择时间</label>
					</div>
					<div class="myfloat" style="display: none;">
						<div class="labelDiv">
							<label id="datatype" class="myLabel">输入数据</label>
						</div>
						<div class="input_div">
							<div class="input-group">
								<input type="text" id="datainput" class="form-control no_radius"
									placeholder="输入数据...">
							</div>
						</div>
						<label id="data_error" class="error_message">请输入数据</label>
					</div>
					<div class="myfloat"
						style="display: none; margin-top: 50px; text-align: center;">
						<p class="stdformbutton">
							<button class="btn btn-primary no_radius">确定录入</button>
						</p>
					</div>
				</div>

				<div id="profile" class="tab-pane">
					<p>虽然很想做EXCEL导入，但并不来得及，coming soon…………</p>
				</div>


			</div>
		</div>
	</div>
	<script>
		var datalist;
		var insertFlag;
		$.ajax({
			type : "POST",
			dataType : "json",
			url : "getStation.action",
			async : false,
			success : function(data) {
				datalist = data['stationNameList'];
			}
		});
		var autoComplete = new AutoComplete('o', 'auto', datalist);
		$('.auto_hidden').click(function() {
			$('#loding_img').show();
			var station = $('#o').val();
			var params = {
				insertStation : station,
			};
			$.ajax({
				type : "POST",
				dataType : "json",
				url : "getInsertType.action",
				data : params,
				success : function(data) {
					insertFlag=data['insertFlag'];
					if (data['insertFlag'] == '1') {
						$('#datatype').html("请输入河流水位数据");
						$('#stationType').html("站点类型为河流").show();
					}
					if (data['insertFlag'] == '0') {
						$('#datatype').html("请输入水库水位数据");
						$('stationType').html("站点类型为水库").show();
					}
					if (data['insertFlag'] == '2') {
						$('#datatype').html("请输入降水量数据");
						$('#stationType').html("站点类型为气象").show();
					}
					if (data['insertFlag'] == '3') {

					}
					$('.myfloat').show();
				}
			});
		});
		$('#datetimepicker').datetimepicker({
			language : 'zh-CN',
			format : "yyyy-mm-dd hh:ii",
			autoclose : true,
			todayBtn : true,
			startDate : "1994-03-2 16:05",
			minuteStep : 10
		});
		$('.stdformbutton').click(function() {
			$('#station_error').hide();
			$('#time_error').hide();
			$('#data_error').hide();
			if ($('#o').val() == "") {
				$('#station_error').show();
			}
			else if ($('#datetimepicker').val() == "") {
				$('#time_error').show();
			}
			else if ($('#datainput').val() == "") {
				$('#data_error').show();
			}
			else{
				var insertStation = $('#o').val();
				var time=$('#datetimepicker').val();
				var data= $('#datainput').val();
				params={
						insertFlag:insertFlag,
						insertStation:insertStation,
						time:time,
						data:data,
				};
				$.ajax({
					type : "POST",
					dataType : "json",
					url : "insertData.action",
					data : params,
					success : function(data) {
						alert("插入成功");
					}
				});
			};
		});
	</script>
</body>
</html>