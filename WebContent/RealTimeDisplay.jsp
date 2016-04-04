<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
body, html, #allmap {
	width: 100%;
	height: 100%;
	overflow: hidden;
	margin: 0;
	font-family: "微软雅黑";
}

#l-map {
	height: 100%;
	width: 78%;
	float: left;
	border-right: 2px solid #bcbcbc;
}

#r-result {
	height: 100%;
	width: 20%;
	float: left;
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=bfh3Gt7WRh0e9fC8dsujDnDKYVYX7ZvN"></script>
	<script src="/MyGraduationProject/JavaScript/jquery-2.2.1.min.js"></script>
<script src="/MyGraduationProject/JavaScript/Chart.js"></script>

<title>添加多个标注点</title>
</head>
<body>
	<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(120.160, 30.267);
	map.enableScrollWheelZoom(); //启用滚轮放大缩小，默认禁用
	map.enableContinuousZoom(); //启用地图惯性拖拽，默认禁用
	map.centerAndZoom(point, 12);
	var top_left_control = new BMap.ScaleControl({
		anchor : BMAP_ANCHOR_TOP_LEFT
	});// 左上角，添加比例尺
	var top_left_navigation = new BMap.NavigationControl(); //左上角，添加默认缩放平移控件
	// 添加定位控件
	var geolocationControl = new BMap.GeolocationControl();
	geolocationControl.addEventListener("locationSuccess", function(e) {
		// 定位成功事件
		var address = '';
		address += e.addressComponent.province;
		address += e.addressComponent.city;
		address += e.addressComponent.district;
		address += e.addressComponent.street;
		address += e.addressComponent.streetNumber;
		alert("当前定位地址为：" + address);
	});
	geolocationControl.addEventListener("locationError", function(e) {
		// 定位失败事件
		alert(e.message);
	});
	map.addControl(geolocationControl);
	map.addControl(top_left_control);
	map.addControl(top_left_navigation);
	// 随机向地图添加25个标注
	var datalist;
	var k=0;
	var convertor = new BMap.Convertor();
	function translateOne(pointArr, stnm) {
	    convertor.translate(pointArr, 1, 5, function(data) {
	        if (data.status === 0) {
	            var marker = new BMap.Marker(data.points[0]);
	            var label = new BMap.Label(stnm, {
	            offset: new BMap.Size(20, -10)
	            });
	            marker.setLabel(label);
	            marker.setTitle(stnm);
	            marker.addEventListener("click", attribute);
	            map.addOverlay(marker);
	        }
	    });
	}
	$.ajax({
			type : "POST",
			dataType : "json",
			url : "getStation.action",
			success : function(data) {
				datalist = data['stations'];
				for (var i = 0; i < datalist.length; i++) {
					var point = new BMap.Point(datalist[i]['lgtd'],datalist[i]['lttd']);
					var stnm = datalist[i]['stnm'];
					var pointArr = [];
				    pointArr.push(point);
					translateOne(pointArr,stnm);
				}
			}
	});
	//点击事件生成图表
	function attribute(e) {
		var p = e.target;
		var canvas = document.createElement('canvas');
		canvas.id = "CursorLayer";
		canvas.width = 600;
		canvas.height = 350;
		var ctx = canvas.getContext("2d");
		ctx.fillRect(20,20,150,100);
		//窗口设置
		var optsSmall={
				width : 80, // 信息窗口宽度
				height : 120, // 信息窗口高度
				title : "正在加载中……", // 信息窗口标题
				enableMessage : true//设置允许信息窗发送短息
		}
		var img = document.createElement("img");
		img.src="../MyGraduationProject/Images/loader11.gif";
		var loadDiv = document.createElement("div");
		loadDiv.style="width: 25px; height: 25px;margin:0 auto;padding-top:30px";
		loadDiv.appendChild(img);
		var infoWindowSmall = new BMap.InfoWindow(loadDiv, optsSmall); // 创建信息窗口对象 
		var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
		map.openInfoWindow(infoWindowSmall, point); //开启信息窗口
		var isColseFlag=0;
		infoWindowSmall.addEventListener("clickclose",function(){
		    isColseFlag=1;
		  });
		var opts = {
			width : 600, // 信息窗口宽度
			height : 381, // 信息窗口高度
			title : p.getTitle(), // 信息窗口标题
			enableMessage : true//设置允许信息窗发送短息
		};
		//图表数据
		var params = {"station" : p.getTitle()};
		var labelDate = [];
		var DBdata = [];
		
	
	$.ajax({
					type : "POST",
					dataType : "json",
					url : "getRealTimeData",
					data : params,
					success : function(data) {
						if (isColseFlag == 0) {
							if (data['typeflag'] == '3') {
								opts['title'] = opts['title'] + "无任何数据";
							} else if (data['typeflag'] == '1') {
								opts['title'] = opts['title'] + "河流水位信息（米）";
							} else if (data['typeflag'] == '0') {
								opts['title'] = opts['title'] + "水库水位信息（米）";
							} else if (data['typeflag'] == '2') {
								opts['title'] = opts['title'] + "降水量信息（mm）";
							}
							if (data['typeflag'] != '3') {
								for (var i = data['realTimeDataList'].length - 1; i >= 0; i--) {
									console.log(i + "   "
											+ data['realTimeDataList'][i]);
									labelDate
											.push(data['realTimeDataList'][i][0]);
									DBdata.push(data['realTimeDataList'][i][1]);
								}
							}
								var lineChartData = {
									labels : labelDate,
									datasets : [ {
										label : "My First dataset",
										fillColor : "rgba(151,187,205,0.2)",
										strokeColor : "rgba(151,187,205,1)",
										pointColor : "rgba(151,187,205,1)",
										pointStrokeColor : "#fff",
										pointHighlightFill : "#fff",
										pointHighlightStroke : "rgba(220,220,220,1)",
										data : DBdata
									} ]

								}
								window.myLine = new Chart(ctx)
										.Line(lineChartData);
								var point = new BMap.Point(p.getPosition().lng,
										p.getPosition().lat);
								var infoWindow = new BMap.InfoWindow(canvas,
										opts); // 创建信息窗口对象 
								map.openInfoWindow(infoWindow, point); //开启信息窗口
							}
					}
				});
	}
</script>

