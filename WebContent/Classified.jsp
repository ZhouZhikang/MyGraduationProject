
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>统计分析</title>
<link href="/MyGraduationProject/JavaScript/MyCSS/warning.css"
	rel="stylesheet">
<script src="/MyGraduationProject/JavaScript/jquery-2.2.1.min.js"></script>
<script type="text/javascript"
	src="JavaScript/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script src="http://cdn.hcharts.cn/highcharts/modules/exporting.js"></script>
<script type="text/javascript"
	src="JavaScript/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="JavaScript/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript" src="JavaScript/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="JavaScript/responsive-tables.js"></script>
<link href="JavaScript/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="JavaScript/MyCSS/sb-admin.css" rel="stylesheet">
<link href="JavaScript/MyCSS/style.default.css" rel="stylesheet">
<link href="JavaScript/MyCSS/data.css" rel="stylesheet">
<link
	href="JavaScript/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css"
	rel="stylesheet">

<script type="text/javascript">
$(function () {
    $('#container').highcharts({
        chart: {
            zoomType: 'x',
            spacingRight: 20
        },
        title: {
            text: 'USD to EUR exchange rate from 2006 through 2008'
        },
        subtitle: {
            text: document.ontouchstart === undefined ?
                'Click and drag in the plot area to zoom in' :
                'Pinch the chart to zoom in'
        },
        xAxis: {
            type: 'datetime',
            maxZoom: 14 * 24 * 3600000, // fourteen days
            title: {
                text: null
            }
        },
        yAxis: {
            title: {
                text: 'Exchange rate'
            }
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
                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1},
                    stops: [
                        [0, Highcharts.getOptions().colors[0]],
                        [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
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
            name: 'USD to EUR',
            pointInterval: 24 * 3600 * 1000,
            pointStart: Date.UTC(2006, 0, 01),
            data: [
4.018157058815149,
3.8956192161519283,
3.77681829135048,
3.6616403232474966,
3.549974826042714,
3.4417146833144443,
3.3367560452665685,
3.2349982291096637,
3.1363436224797994,
3.04069758980269,
2.9479683815134763,
2.858067046044866,
2.770907344499392,
2.6864056679236086,
2.604480957105409,
2.5250546248168177,
2.448050480428549,
2.373394656822967,
2.301015539536479,
2.230843698062344
            ]
        }]
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
</script>
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
					<h1 class="page-header" style="margin:20px 0 20px;">统计分析</h1>

				</div>
			</div>
		</div>
	</div>
	
	<div style="width: 538px;margin:0px auto;">
					<div style="float: left; width: 100%;">
						<div style="float: left; margin-right: 15px;">
							<label class="searchLabel">时间：</label>
							<div class="input-group date form_datetime col-md-1.5"
								data-link-field="dtp_input1">
								<input id="datetimepicker" class="form-control" size="16"
									type="text" style="border-radius: 0px;" value="" readonly>
							</div>
							<input type="hidden" id="dtp_input1" value="" /><br />
						</div>
						<label class="searchLabel">站点：</label>
						<div class="searchDiv">
							<div class="input-group" >
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
	
	<div class="mydiv">
		<div id="container"
			style="margin: 20px; width: 100%; height: 400px; margin: 0 auto"></div>
	</div>
</body>
</html>
