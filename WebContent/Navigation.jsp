<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Navigation</title>

    <!-- Bootstrap core CSS -->
    <link href="JavaScript/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="JavaScript/MyCSS/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>
<div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <%--<li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>--%>
            <li><a href="Welcome.jsp" target="mainFrame"><span class="glyphicon glyphicon-home"></span>主页</a></li>
            <li><a href="DataEntry.jsp" target="mainFrame"><span class="glyphicon glyphicon-pencil"></span>数据录入</a></li>
            <li><a href="WaterData.jsp" target="mainFrame"><span class="glyphicon glyphicon-signal"></span>数据分析</a></li>
           <!--  <li><a href="RainData.jsp" target="mainFrame"><span class="glyphicon glyphicon-tint"></span>雨量数据分析</a></li> -->
            <li><a href="RealTimeDisplay.jsp" target="mainFrame"><span class="glyphicon glyphicon-map-marker"></span>实时展示</a></li>
            <li><a href="Classified.jsp" target="mainFrame"><span class="glyphicon glyphicon-list-alt"></span>分类统计</a></li>
            <li><a href="Warning.jsp" target="mainFrame"><span class="glyphicon glyphicon-warning-sign"></span>防汛预警</a></li>
          </ul>
        </div>   
      </div>
    </div>
</body>
 <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
        $(function () {
            $('div.sidebar li').click(function(){
            	$(this).addClass('active').siblings('li').removeClass('active');
            })
        });
    </script>
</html>