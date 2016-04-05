<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<title>数据查询</title>
</head>
<body>
	<ul class="breadcrumbs">
		<li><a href="Welcome.html"><i
				class="glyphicon glyphicon-home"></i></a> <span
			class="glyphicon glyphicon-menu-right"></span></li>
		<li>数据查询</li>
	</ul>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">

					<h1 class="page-header" style="margin: 20px 0 20px;">数据查询</h1>

					<div style="width: 790px; margin: 0px auto;">
						<div style="float: left; width: 100%;">
							<div style="float: left; margin-right: 15px;">
								<label class="searchLabel">起始时间：</label>
								<div class="input-group date form_datetime col-md-1.5"
									data-link-field="dtp_input1">
									<input id="datetimepicker" class="form-control" size="16"
										type="text" style="border-radius: 0px;" value="" readonly>
								</div>
								<input type="hidden" id="dtp_input1" value="" /><br />
							</div>
							<div style="float: left; margin-right: 15px;">
								<label class="searchLabel">截止时间：</label>
								<div class="input-group date form_datetime col-md-1.5"
									data-link-field="dtp_input1">
									<input id="datetimepicker2" class="form-control" size="16"
										type="text" style="border-radius: 0px;" value="" readonly>
								</div>
								<input type="hidden" id="dtp_input1" value="" /><br />
							</div>
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
					</div>

					<div id="loding_img"
						style="margin-top: 200px; float: left; text-align: center; width: 100%; display: none;">
						<img src="../MyGraduationProject/Images/loader5.gif" />
					</div>
					<div id="tableWater"
						style="float: left; width: 100%; display: none">
						<h4 class="widgettitle">数据</h4>
						<table id="dyntable" class="table table-bordered responsive"
							width="100%">
							<colgroup>
								<col class="con0" style="align: center; width: 10%" />
								<col class="con1" />
								<col class="con0" />
								<col class="con1" />
								<col class="con0" />
								<col class="con1" />
							</colgroup>
							<thead>
								<tr>
									<th class="head1">编号</th>
									<th class="head0">站点名</th>
									<th class="head1">监测时间</th>
									<th id="dataName" class="head0">数据</th>
								</tr>
							</thead>
							<tbody id="tb" style="width: 100%;">
							</tbody>
						</table>
					</div>


					<script type="text/javascript">
						var datalist;
						$.ajax({
							type : "POST",
							dataType : "json",
							url : "getStation.action",
							async : false,
							success : function(data) {
								datalist = data['stationNameList'];
							}
						});
						var autoComplete = new AutoComplete('o', 'auto',
								datalist);
						$('#datetimepicker').datetimepicker({
							language : 'zh-CN',
							format : "yyyy-mm-dd hh:ii",
							autoclose : true,
							todayBtn : true,
							startDate : "1994-03-2 16:05",
							minuteStep : 10
						});
						$('#datetimepicker2').datetimepicker({
							language : 'zh-CN',
							format : "yyyy-mm-dd hh:ii",
							autoclose : true,
							todayBtn : true,
							startDate : "1994-03-2 16:05",
							minuteStep : 10
						});
						$('#searchBtn')
								.click(
										function() {
											$('#tableWater').hide();
											var time2 = $('#datetimepicker2')
													.val();
											var time1 = $('#datetimepicker')
													.val();
											var station = $('#o').val();
											var result;
											var params = {
												endTime : time2,
												startTime : time1,
												station : station,
											};
											if (time1 == '') {
												alert("请选择起始时间");
											} else if (time2 == '') {
												alert("请选择截止时间");
											} else if (time1 > time2) {
												alert("截止时间应该大于起始时间");
											} else if (station == '') {
												alert("请选择站点");
											} else {
												$('#loding_img').show();
												$('#dyntable').dataTable()
														.fnClearTable();
												$
														.ajax({
															type : "POST",
															dataType : "json",
															url : "getData.action",
															data : params,
															success : function(
																	data) {
																if (data['flag'] == '1') {
																	$(
																			'.widgettitle')
																			.html(
																					"河流水位数据");
																	$(
																			'#dataName')
																			.html(
																					"河流水位（米）");
																} else if (data['flag'] == '0') {
																	$(
																			'.widgettitle')
																			.html(
																					"水库水位数据");
																	$(
																			'#dataName')
																			.html(
																					"水库水位（米）");
																} else if (data['flag'] == '2') {
																	$(
																			'.widgettitle')
																			.html(
																					"雨量数据");
																	$(
																			'#dataName')
																			.html(
																					"降水量（mm）");
																}
																if (data['flag'] != '3') {
																	result = data['list'];
																	console
																			.log(result);
																	var tb = document
																			.getElementById("tb");
																	for (var i = 0; i < result.length; i++) {
																		var row = tb
																				.insertRow(tb.rows.length);
																		var c1 = row
																				.insertCell(0);
																		c1.innerHTML = i + 1;
																		var c2 = row
																				.insertCell(1);
																		c2.innerHTML = station;
																		var c3 = row
																				.insertCell(2);
																		c3.innerHTML = result[i][0];
																		var c4 = row
																				.insertCell(3);
																		c4.innerHTML = result[i][1];
																	}
																	$(
																			'#loding_img')
																			.hide();
																	$(
																			'#tableWater')
																			.show();
																	$(
																			'#dyntable')
																			.dataTable()
																			.fnDestroy();
																	$(
																			'#dyntable')
																			.dataTable(
																					{
																						"sPaginationType" : "full_numbers",
																						"bDestroy" : true,
																						"bRetrieve" : true,
																						"aaSortingFixed" : [ [
																								0,
																								'asc' ] ],
																					});
																}
															}
														});

											}

										});
						$('.nav-pills li')
								.click(
										function() {
											$(this).addClass('active')
													.siblings('li')
													.removeClass('active');
											if ($(this).children('a').html() == "水位数据") {
												$('#tableWater').show();
												$('#tableRain').hide();
											} else {
												$('#tableWater').hide();
												$('#tableRain').show();
											}
										})
					</script>





				</div>
			</div>
		</div>
	</div>
</body>
</html>