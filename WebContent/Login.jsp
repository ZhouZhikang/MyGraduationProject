
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>登录</title>

    <!-- Bootstrap core CSS -->
    <link href="JavaScript/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="JavaScript/MyCSS/signin.css" rel="stylesheet">
	
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
  </head>

  <body>

    <div class="container">
		<h1 class="form-signin-heading-h1">城市防汛预警系统</h1>
      <s:form  action="login" class="form-signin" theme="simple">
        <h2 class="form-signin-heading">请登录</h2>
        	<div class="userName_div">
          		<s:textfield id="loginName" class="form-control" name="userName" placeholder="账号"/>
          	<div class="nullName">请输入账号</div>
        </div>
        <div class="userName_div">
        		<s:password id="loginPwd" class="form-control" name="userPassword" placeholder="密码"/>
        	<div class="nullPwd">请输入密码</div>
        	<div class="errorPwd">密码错误</div>
        </div>
        <%--<div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me">记住我
          </label>
        </div>--%>
        <s:submit value="登录" class="btn btn-lg btn btn-success btn-block"></s:submit>
      </s:form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script  src="JavaScript/jquery-2.2.1.min.js"></script>
    <script type="text/javascript">
    $('#loginName').blur(function(){
    	if($('#loginName').val()==""){    		
    		$('.nullName').show();
    	}
    	else{
    		$('.nullName').hide();
    	}
    });
    $('#loginPwd').blur(function(){
   	if($('#loginPwd').val()==""){    		
   	$('.nullPwd').show();
   	}
   	else{
   		$('.nullPwd').hide();
   	}
   });
    </script>
  </body>
</html>

