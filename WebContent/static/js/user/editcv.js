function update(){
	loginId = $.cookie('loginId');
	pwd = $.cookie('password');
	$.ajax({
		type:'POST',
		url: 'uurl/editcv',
		dataType:'json',
		data:{loginId:loginId,password:pwd},
		success: function(data){
			$.alert('简历更新成功',function(){
				window.location.href="user/me";
			});
			
		}
	});
}