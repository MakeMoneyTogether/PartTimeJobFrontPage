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
</head>
<body ontouchstart>
	<div class="weui-flex">
		<div class="placeholder"><a onclick="history.go(-1);"><i class="fa fa-chevron-left" style="color:#010101;margin-top: 90%;"></i></a></div>
		<div class="weui-flex__item placeholder">
			<span id="jz-title">登录</span>
		</div>
		<div class="placeholder"><a href="user"><i style="color:#010101;margin-top: 60%;" class="fa fa-home"></i></a></div>
	</div>
	<div class="weui-form-preview">
		<div class="weui-cells weui-cells_form">
			<div class="weui-cell">
				<div class="weui-cell__hd"><label class="weui-label">用户名</label></div>
				<div class="weui-cell__bd">
					<input id="loginId" class="weui-input" type="text" placeholder="请输入登录名">
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__hd"><label class="weui-label">密码</label></div>
				<div class="weui-cell__bd">
					<input id="password" class="weui-input" type="password" placeholder="请输入密码">
				</div>
			</div>
		<!-- 
			<div class="weui-cell">
				<div class="weui-cell__hd"><label class="weui-label">确认密码</label></div>
				<div class="weui-cell__bd">
					<input class="weui-input" type="password" placeholder="请输入密码">
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__hd"><label class="weui-label">邀请码</label></div>
				<div class="weui-cell__bd">
					<input class="weui-input" type="text" placeholder="选填">
				</div>
			</div>
		 -->

		</div>
	</div>
		<a onclick="login();" class="weui-btn weui-btn_primary commitBtn">登录</a>
	 	<a href="user/register" class="weui-btn weui-btn_default" style="width:80%;">注册</a>
<div style="display:none;">
</div>	
<script src="static/js/jquery-2.1.4.js"></script>
<script src="static/js/fastclick.js"></script>
<script src="static/js/jquery-weui.min.js"></script>
<script src="static/js/jquery.cookie.js"></script>
<script type="text/javascript">
</script>
<script>
	function login(){
		loginId = $('#loginId').val();
		pwd = $('#password').val();
		
		$.ajax({
			type:'POST',
			url: 'jzurl/pages/login',
			dataType:'json',
			data:{loginId:loginId,password:pwd},
			success: function(data){
				if(data == 2){
					$.alert('密码错误！！');
				}
				if(data == 1){
					$.alert('请检查用户名不存在！！');
				}
				if(data == 0){
					$.cookie('loginId',loginId,{expires:30,path:'/'});
					$.cookie('password',pwd,{expires:30,path:'/'});
					window.location.href='user/me';
				}
			}
		});
	}
</script>
</body>
</html>