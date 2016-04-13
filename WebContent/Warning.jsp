<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>防汛预警</title>
<link href="JavaScript/MyCSS/warning.css" rel="stylesheet">
<link href="JavaScript/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="JavaScript/MyCSS/sb-admin.css" rel="stylesheet">
<link href="JavaScript/MyCSS/style.default.css" rel="stylesheet">
<link href="JavaScript/MyCSS/data.css" rel="stylesheet">
<link
	href="JavaScript/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css"
	rel="stylesheet">
<script src="JavaScript/jquery-2.2.1.min.js"></script>
<script type="text/javascript"
	src="JavaScript/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
<script type="text/javascript"
	src="JavaScript/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="JavaScript/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="JavaScript/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="JavaScript/responsive-tables.js"></script>
<script type="text/javascript" src="JavaScript/myJS.js"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=bfh3Gt7WRh0e9fC8dsujDnDKYVYX7ZvN"></script>
</head>
<body>
	<ul class="breadcrumbs">
		<li><a href="Welcome.html"><i
				class="glyphicon glyphicon-home"></i></a> <span
			class="glyphicon glyphicon-menu-right"></span></li>
		<li>防汛预警</li>
	</ul>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header" style="margin: 20px 0 20px;">防汛预警</h1>

				</div>
			</div>
		</div>
	</div>

	<div style="width: 630px; margin: 0px auto;">
		<div style="float: left; width: 100%;">

			<div id="timepicker3" style="float: left; margin-right: 15px;">
				<label class="searchLabel">选择预测月份：</label>
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

	<div id="nodata"
		style="background-color: #EEEEEE; margin: 80px 50px; height: 80px; text-align: center; display: none">
		<h1 style="line-height: 80px">无数据</h1>
	</div>
	<div id="loding_img"
		style="margin-top: 200px; float: left; text-align: center; width: 100%; display: none;">
		<img src="../MyGraduationProject/Images/loader6.gif" />
	</div>

	<div class="myChartdiv" style="display: none; margin-top: 80px;">
		<div id="container"
			style="margin: 80px; width: 100%; height: 400px; margin: 0 auto"></div>
	</div>
	<script type="text/javascript">
		var title;
		var yText;
		var isExist = 0;
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
		$('#datetimepicker2').datetimepicker({
			language : 'zh-CN',
			format : "yyyy-mm",
			autoclose : true,
			todayBtn : true,
			startView : 3,
			minView : 3,
		});

		$('#searchBtn')
				.click(
						function() {
							monthDay = $('#datetimepicker2').val();
							time2 = $('#datetimepicker2').val();
							var year = parseInt(time2.substr(0, 4));
							var month = parseInt(time2.substr(5, 2));
							time2 = year-1+"-"+(month+1)+"-1";
							if (month ==1) {
								month = 12;
							} else {
								month--;
							}
							year--;
							time1 = year + "-" + month + "-1";
							/* time1 = $('#datetimepicker').val();
							time2 = $('#datetimepicker2').val(); */

							var station = $('#o').val();
							var params = {
								endTime : time2,
								startTime : time1,
								station : station,
							};
							if ($('#datetimepicker2').val() == "") {
								alert("请选择月份");
							} else if ($('#o').val() == "") {
								alert("请选择站点");
							} else {
								for (var i = 0; i < datalist.length; i++) {
									if ($('#o').val() == datalist[i]) {
										isExist = 1;
									}
								}
								if (isExist == 0) {
									alert("站点不存在!");
								} else {
									$('#mynodata').hide();
									$('.myChartdiv').hide();
									$('#nodata').hide();
									$('#loding_img').show();
									$('.myStationInfoDiv').hide();
									$
											.ajax({
												type : "POST",
												dataType : "json",
												url : "getData.action",
												data : params,
												success : function(data) {
													if (data['flag'] == '1') {
														title = station
																+ "河流水位统计数据";
														yText = "水位（m）";
													} else if (data['flag'] == '0') {
														title = station
																+ "水库水位统计数据";
														yText = "水位（m）";
													} else if (data['flag'] == '2') {
														title = station
																+ "降水量统计数据";
														yText = "降水量";
													}
													if (data['flag'] != '3') {
														result = data['list'];
														var timeMonth = parseInt(result[0][0].substr(5,2));
														if(timeMonth<12){
															timeMonth++;
														}
														else{
															timeMonth=1;
														}
														var startMonth = new Array(); 
														var currentMonth;
														var currentDay;
														if (result.length != 0) {
															var datalist = new Array();
															var timelist = new Array();
															var maxLevel = result[0][1];
															var minLevel = result[0][1];
															for (var i = 0; i < result.length; i++) {
																if (result[i][1] > maxLevel) {
																	maxLevel = result[i][1];
																}
																if (result[i][1] < minLevel) {
																	minLevel = result[i][1];
																}
																datalist.push(result[i][1]);
																currentMonth=parseInt(result[i][0].substr(5,2));
																currentDay=parseInt(result[i][0].substr(14,2));
																if(currentMonth==12){
																	if(currentMonth>timeMonth){
																		startMonth.push(result[i][1]);
																	}
																}
																else if(currentMonth<timeMonth){
																	startMonth.push(result[i][1]);
																}
															}
																year++;
																var datalist2 = new Array();
																var result2;
																time1=year+"-"+month+"-1";
																time2=monthDay+"-1";
																params = {
																		endTime : time2,
																		startTime : time1,
																		station : station,
																	};
																$.ajax({
																	type:"POST",
																	dataType:"json",
																	url:"getData.action",
																	data:params,
																	success:function(data){
																		result2=data['list'];
																		for(var i=0;i<result2.length;i++){
																			datalist2.push(result2[i][1]);
																			var time = result2[i][0].substr(0,10)+ " "+ result2[i][0].substr(11,5);
																			timelist.push(time);
																		}
																		var testtxt=1;
																		str = datalist.join(",");
																		str2 = datalist2.join(",");
																		str3 = startMonth.join(",");
																		params={
																		 		data1:str,
																				data2:str2, 
																				data3:str3,
																				testtxt:testtxt,
																		};
																		$.ajax({
																			type:"POST",
																			dataType:"json",
																			url:"warningCalculate.action",
																			data:params,
																			success:function(data){
																				$('#loding_img').hide();
																				$('.myChartdiv').show();
																				var gmlist = new Array();
																				gmlist=data['gm'];
																				
																				
																				$(function() {
																					$('#container')
																							.highcharts(
																									{
																										chart : {
																											zoomType : 'x',
																											spacingRight : 20
																										},
																										credits : {
																											enabled : false
																										},
																										title : {
																											text : title
																										},
																										subtitle : {
																											text : null
																										/* document.ontouchstart === undefined ?
																																				'Click and drag in the plot area to zoom in' :
																																				'Pinch the chart to zoom in' */
																										},
																										xAxis : {
																											categories : timelist,
																											type : title,
																											title : {
																												text : null
																											}
																										},
																										yAxis : {
																											title : {
																												text : yText,
																											},
																										/* plotLines: [{   //一条延伸到整个绘图区的线，标志着轴中一个特定值。
																										    color: '#FB3D01',
																										    dashStyle: 'Dash', //Dash,Dot,Solid,默认Solid
																										    width: 1.5,
																										    value: 5,  //y轴显示位置
																										    zIndex: 5
																										}] */
																										},
																										tooltip : {
																											shared : true
																										},
																										legend : {
																											enabled : false
																										},
																										plotOptions : {
																											area : {
																												fillColor : {
																													linearGradient : {
																														x1 : 0,
																														y1 : 0,
																														x2 : 0,
																														y2 : 1
																													},
																													stops : [
																															[
																																	0,
																																	Highcharts
																																			.getOptions().colors[0] ],
																															[
																																	1,
																																	Highcharts
																																			.Color(
																																					Highcharts
																																							.getOptions().colors[0])
																																			.setOpacity(
																																					0)
																																			.get(
																																					'rgba') ] ]
																												},
																												lineWidth : 1,
																												marker : {
																													enabled : false
																												},
																												shadow : false,
																												states : {
																													hover : {
																														lineWidth : 1
																													}
																												},
																												threshold : null
																											}
																										},

																										series : [ /* {
																											type : 'line',
																											name : yText,
																											data : datalist
																										}, */
																											{
																												type : 'line',
																												name : yText,
																												data : datalist2
																											},
																											{
																												type : 'line',
																												name : "模型拟合结果",
																												data : gmlist
																											},
																										]
																									});
																				});
																				
																				
																			}
																		});
																		
																		
																		
																	}
																});
																
														} else {
															$('#nodata').show();
														}
													} else {
														$('#nodata').show();
													}
												}

											});
								}
							}
						});

		Highcharts.createElement('link', {
			href : 'http://fonts.googleapis.com/css?family=Dosis:400,600',
			rel : 'stylesheet',
			type : 'text/css'
		}, null, document.getElementsByTagName('head')[0]);

		Highcharts.theme = {
			colors : [ "#7cb5ec", "#f7a35c", "#90ee7e", "#7798BF", "#aaeeee",
					"#ff0066", "#eeaaee", "#55BF3B", "#DF5353", "#7798BF",
					"#aaeeee" ],
			chart : {
				backgroundColor : null,
				style : {
					fontFamily : "Dosis, sans-serif"
				}
			},
			title : {
				style : {
					fontSize : '16px',
					fontWeight : 'bold',
					textTransform : 'uppercase'
				}
			},
			tooltip : {
				borderWidth : 0,
				backgroundColor : 'rgba(219,219,216,0.8)',
				shadow : false
			},
			legend : {
				itemStyle : {
					fontWeight : 'bold',
					fontSize : '13px'
				}
			},
			xAxis : {
				gridLineWidth : 1,
				labels : {
					style : {
						fontSize : '12px'
					}
				}
			},
			yAxis : {
				minorTickInterval : 'auto',
				title : {
					style : {
						textTransform : 'uppercase'
					}
				},
				labels : {
					style : {
						fontSize : '12px'
					}
				}
			},
			plotOptions : {
				candlestick : {
					lineColor : '#404048'
				}
			},

			// General
			background2 : '#F0F0EA'

		};

		// Apply the theme
		Highcharts.setOptions(Highcharts.theme);
		$("#searchType  option[value='1'] ").attr("selected", true);
		$("#season  option[value='1'] ").attr("selected", true);
		/* console.log($(".uniformselect option:selected").text());  */
		function onChange() {
			if ($("#searchType").val() == 1) {
				$('#timepicker1').show();
				$('#timepicker2').hide();
				$('#timepicker3').hide();
			}
			if ($("#searchType").val() == 2) {
				$('#timepicker1').show();
				$('#timepicker2').show();
				$('#timepicker3').hide();
			}
			if ($("#searchType").val() == 3) {
				$('#timepicker1').hide();
				$('#timepicker2').hide();
				$('#timepicker3').show();
			}
		};
	</script>
</body>
</html>
