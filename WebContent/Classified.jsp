<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>统计分析</title>
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
		<li>统计分析</li>
	</ul>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header" style="margin: 20px 0 20px;">统计分析</h1>

				</div>
			</div>
		</div>
	</div>

	<div style="width: 800px; margin: 0px auto;">
		<div style="float: left; width: 100%;">
			<label class="searchLabel">统计类型：</label>
			<div style="float: left; line-height: 34px; margin-right: 15px;">
				<select id="searchType" name="select" onchange="onChange()">
					<option value="1">按年</option>
					<option value="2">按季度</option>
					<option value="3">按月</option>
				</select>
			</div>
			<div id="timepicker1" style="float: left; margin-right: 15px;">
				<label class="searchLabel">选择年份：</label>
				<div class="input-group date form_datetime col-md-1.5"
					data-link-field="dtp_input1">
					<input id="datetimepicker" class="form-control" size="16"
						type="text" style="border-radius: 0px;" value="" readonly>
				</div>
				<input type="hidden" id="dtp_input1" value="" /><br />
			</div>

			<div id="timepicker2"
				style="display: none; float: left; line-height: 34px; margin-right: 15px;">
				<label class="searchLabel">季度：</label> <select name="select"
					id="season">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
			</div>

			<div id="timepicker3"
				style="float: left; margin-right: 15px; display: none;">
				<label class="searchLabel">选择月份：</label>
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
	<div class="clearfix myStationInfoDiv">
		<div class="myStationInfo">
			<table class="table table-bordered">
				<colgroup>
                        <col class="con0" />
                        <col class="con1" />
                    </colgroup>
				<tbody>
					<tr>
						<td>站点编号</td>
						<td id="stcd"></td>
					</tr>
					<tr>
						<td>站点名称</td>
						<td id="stnm"></td>
					</tr>
					<tr>
						<td>站点地址</td>
						<td id="stlc"></td>
					</tr>
					<tr>
						<td>所属部门</td>
						<td id="admauth"></td>
					</tr>
					<tr>
						<td>最高值</td>
						<td id="max"></td>
					</tr>
					<tr>
						<td>最低值</td>
						<td id="min"></td>
					</tr>
				</tbody>
			</table>

		</div>
		<div class="myMapInfo">
			<div id="allmap" class="mapContent"></div>
		</div>
	</div>
	<div class="myChartdiv" style="display: none;">
		<div id="container"
			style="margin: 20px; width: 100%; height: 400px; margin: 0 auto"></div>
	</div>
	<script type="text/javascript">
		var title;
		var yText;
		var datalist;
		var isExist=0;
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
		$('#datetimepicker').datetimepicker({
			language : 'zh-CN',
			format : "yyyy",
			startView : 4,
			minView : 4,
			autoclose : true,
			todayBtn : true,
		});
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
							if ($("#searchType").val() == 1) {
								yearName = $('#datetimepicker').val();
								time1 = $('#datetimepicker').val() + "-1-1";
								time2 = $('#datetimepicker').val();
								var year = parseInt(time2.substr(0, 4));
								year++;
								var month = parseInt(time2.substr(5, 2));
								if (month + 1 > 12) {
									year++;
									month = 1;
								} else {
									month++;
								}
								time2 = year + "-1-1";
							} else if ($("#searchType").val() == 2) {
								var season = $("#season").val()
								var yearName = $('#datetimepicker').val();
								var year = parseInt(yearName);
								var statMonth;
								if ($("#season").val() == 1) {
									statMonth = 1;
								} else if ($("#season").val() == 2) {
									statMonth = 4;
								} else if ($("#season").val() == 3) {
									statMonth = 7;
								} else if ($("#season").val() == 4) {
									statMonth = 10;
									year++;
								}
								month = statMonth + 3;
								time1 = $('#datetimepicker').val() + "-"
										+ statMonth + "-1";
								time2 = $('#datetimepicker').val() + "-"
										+ month + "-1";
								if ($("#season").val() == 4) {
									time2 = year + "-" + "-1-1";
								}
							} else if ($("#searchType").val() == 3) {
								yearName = $('#datetimepicker2').val();
								time1 = $('#datetimepicker2').val() + "-1";
								time2 = $('#datetimepicker2').val();
								var year = parseInt(time2.substr(0, 4));
								var month = parseInt(time2.substr(5, 2));
								if (month + 1 > 12) {
									month = 1;
									year++;
								} else {
									month++;
								}
								time2 = year + "-" + month + "-1";
							}
							console.log(time1);
							console.log(time2);
							/* time1 = $('#datetimepicker').val();
							time2 = $('#datetimepicker2').val(); */

							var station = $('#o').val();
							var params = {
								endTime : time2,
								startTime : time1,
								station : station,
							};
							if ($("#searchType").val() == 1
									&& $('#datetimepicker').val() == "") {
								alert("请选择年份");
							} else if ($("#searchType").val() == 2
									&& $('#datetimepicker').val() == "") {
								alert("请选择年份");
							} else if ($("#searchType").val() == 3
									&& $('#datetimepicker2').val() == "") {
								alert("请选择月份");
							} else if($('#o').val()==""){
								alert("请选择站点");
							} else {
								for(var i=0;i<datalist.length;i++){
									if($('#o').val()==datalist[i]){
										isExist=1;
									}
								}
							if(isExist==0){
								alert("站点不存在!");
							}
							else
							{
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
												$('#loding_img').hide();
												$
														.ajax({
															type : "POST",
															dataType : "json",
															url : "getStation.action",
															success : function(
																	data) {
																var station;
																var x = 116.32715863448607;
																var y = 39.990912172420714;
																var point = new BMap.Point(
																		x, y);
																var bm = new BMap.Map(
																		"allmap");
																datalist = data['stations'];
																bm
																		.centerAndZoom(
																				point,
																				15);
																bm
																		.enableScrollWheelZoom(true);
																for (var i = 0; i < datalist.length; i++) {
																	if (datalist[i]['stnm'] == $(
																			'#o')
																			.val()) {
																		station = datalist[i];
																		point = new BMap.Point(
																				datalist[i]['lgtd'],
																				datalist[i]['lttd']);
																	}
																}
																translateCallback = function(
																		data) {
																	if (data.status === 0) {
																		var marker = new BMap.Marker(
																				data.points[0]);
																		bm
																				.addOverlay(marker);
																		bm
																				.centerAndZoom(
																						data.points[0],
																						15);
																	}
																};
																var convertor = new BMap.Convertor();
																var pointArr = [];
																pointArr
																		.push(point);
																convertor
																		.translate(
																				pointArr,
																				1,
																				5,
																				translateCallback);
																$('#stcd')
																		.html(
																				station['stcd']);
																$('#stnm')
																		.html(
																				station['stnm']);
																$('#stlc')
																		.html(
																				station['stlc']);
																$('#admauth')
																		.html(
																				station['admauth']);
																$('.myStationInfoDiv').show();
															}
														});
												if (data['flag'] == '1') {
													title = station
															+ "河流水位统计数据";
													yText = "水位（m）";
												} else if (data['flag'] == '0') {
													title = station + "水库水位统计数据";
													yText = "水位（m）";
												} else if (data['flag'] == '2') {
													title = station + "降水量统计数据";
													yText = "降水量";
												}
												if (data['flag'] != '3') {
													result = data['list'];
													if (result.length != 0) {
														$('.myChartdiv').show();

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
															datalist
																	.push(result[i][1]);
															/* console
																	.log(result[i][1]); */
															var time = result[i][0]
																	.substr(0,
																			10)
																	+ " "
																	+ result[i][0]
																			.substr(
																					11,
																					5);
															timelist.push(time);
														}
														$('#max').html(maxLevel);
														$('#min').html(minLevel);
														$(function() {
														    $('#container')
														        .highcharts({
														            chart: {
														                zoomType: 'x',
														                spacingRight: 20
														            },
														            credits: {
														                enabled: false
														            },
														            title: {
														                text: title
														            },
														            subtitle: {
														                text: null
														            },
														            xAxis: {
														                categories: timelist,
														                type: title,
														                title: {
														                    text: null
														                }
														            },
														            yAxis: {
														                title: {
														                    text: yText,
														                },
														            },
														            tooltip: {
														                shared: true
														            },
														            legend: {
														                enabled: false
														            },
														            plotOptions: {
														                area: {
														                    fillColor: {
														                        linearGradient: {
														                            x1: 0,
														                            y1: 0,
														                            x2: 0,
														                            y2: 1
														                        },
														                        stops: [
														                            [
														                                0,
														                                Highcharts.getOptions().colors[0]
														                            ],
														                            [
														                                1,
														                                Highcharts.Color(
														                                    Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')
														                            ]
														                        ]
														                    },
														                    lineWidth: 1,
														                    marker: {
														                        enabled: false
														                    },
														                    shadow: false,
														                    states: {
														                        hover: {
														                            lineWidth: 1
														                        }
														                    },
														                    threshold: null
														                }
														            },

														            series: [{
														                type: 'area',
														                name: yText,
														                data: datalist
														            }]
														        });
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
