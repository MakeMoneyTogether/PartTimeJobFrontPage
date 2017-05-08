function jump(k){
	switch(k){
		case 1:
			window.location.href='mer/issue';
			break;
		case 2:
			window.location.href='mer/list';
			break;
		case 3:
			window.location.href='mer/index';
			break;
		case 4:
			window.location.href='mer/edit';
			break;
		case 5:
			window.location.href='mer/money';
			break;
		case 6:
			$('#repass').popup();
			break;
		case 7:
			logout();
	}
}
function merlogin(){
	phone = $('#phone').val();
	pwd = $('#password').val();
	
	$.ajax({
		type:'POST',
		url: 'uurl/pages/login',
		dataType:'json',
		data:{phone:phone,password:pwd},
		success: function(data){
			if(data == 1){
				$.alert('登录名或密码错误！！');
			}
			if(data == 0){
				$.cookie('phone',phone,{expires:30,path:'/'});
				$.cookie('password',pwd,{expires:30,path:'/'});
				window.location.href='mer/index';
			}
		}
	});
}
function mercheck(){
	phone = $.cookie('phone');
	pwd = $.cookie('password');
	
	$.ajax({
		type:'POST',
		url: 'uurl/pages/login',
		dataType:'json',
		data:{phone:phone,password:pwd},
		success: function(data){
			if(data == 1){
				window.location.href='mer/login';
			}
		}
	});
}
function logout(){
	phone = $.cookie('phone');
	$.ajax({
		type:'POST',
		url: 'uurl/pages/logout',
		dataType:'json',
		data:{phone:phone},
		success: function(data){
			$.removeCookie('phone',{path:'/'})
			$.removeCookie('password',{path:'/'})
			window.location.href='mer/login';
		}
	});
	$.removeCookie('phone',{path:'/'})
	$.removeCookie('password',{path:'/'})
	window.location.href='mer/login';
}