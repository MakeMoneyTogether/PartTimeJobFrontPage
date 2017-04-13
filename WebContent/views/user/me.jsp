<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>兼职</title>
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<link rel="stylesheet" href="static/css/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.min.css">
<link rel="stylesheet" href="static/css/font-awesome.min.css">
<link rel="stylesheet" href="static/css/jz.css">
<link rel="stylesheet" href="static/css/col.css">
</head>
<body ontouchstart>
	<div class="weui-flex">
		<div class="placeholder"><a onclick="history.go(-1);"><i class="fa fa-chevron-left" style="color:#010101;margin-top: 90%;"></i></a></div>
		<div class="weui-flex__item placeholder">
			<span id="jz-title">个人中心</span>
		</div>
		<div class="placeholder"><a href="user"><i style="color:#010101;margin-top: 60%;" class="fa fa-home"></i></a></div>
	</div>
	<div class="weui-form-preview">
		<div class="weui-form-preview__hd div_left">
			<div class="col-20 div_left">
				<img style="width:100%;" alt="统一头像" src="static/images/1.jpg">
			</div>
			<div class="col-50 div_left">
				<span style="margin-left:5%;float:left;" id="uname">姓名啊</span><br>
				<span style="margin-left:5%;float:left;" id="ugpa">5.0</span>
			</div>
			<div class="col-30 div_right">
				<a style="">编辑简历></a>
			</div>
		</div>
		<div style="clear:both"></div>
	</div>
<div style="display:none;">
</div>	
<script src="static/js/jquery-2.1.4.js"></script>
<script src="static/js/fastclick.js"></script>
<script src="static/js/jquery-weui.min.js"></script>
<script src="static/js/jquery.cookie.js"></script>
<script src="static/js/user/me.js"></script>
<script type="text/javascript">
</script>
<script>
</script>
</body>
</html>