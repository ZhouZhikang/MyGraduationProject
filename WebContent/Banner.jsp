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

    <title>Banner</title>
    <script src="JavaScript/jquery-2.2.1.min.js"></script>
    <link href="JavaScript/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="JavaScript/MyCSS/dashboard.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" style="background-color:#0063C9;">
      <div class="container-fluid" >
        <div class="navbar-header">
          <a class="navbar-brand" style="color: #FFFFFF" href="Welcome.jsp" target="mainFrame"><img style="float:left;width: 40px;height: 24px;margin:-3px 10px 0px 10px;" src="../MyGraduationProject/Images/hz.png" />基于大数据的城市防汛预警系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a id="usr" style="color: #FFFFFF" href="#"></a></li>
          </ul>
          <%--<form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>--%>
        </div>
      </div>
    </nav>
</body>
<script type="text/javascript">
	var username;
     window.onload=function(){
    	 username=getCookie('username');
    	 console.log(username);
    	 $('#usr').html("欢迎，"+username);
    }; 
    function getCookie(c_name)
    {
    if (document.cookie.length>0)
      {
      c_start=document.cookie.indexOf(c_name + "=")
      if (c_start!=-1)
        { 
        c_start=c_start + c_name.length+1 
        c_end=document.cookie.indexOf(";",c_start)
        if (c_end==-1) c_end=document.cookie.length
        return unescape(document.cookie.substring(c_start,c_end))
        } 
      }
    return ""
    }
    </script>
</html>