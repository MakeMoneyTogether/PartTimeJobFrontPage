function register(){
	loginId= $('#loginId').val();
	$.ajax({
		type:'POST',
		url: 'util/judgeId',
		dataType:'json',
		data:{loginId:loginId},
		success: function(data){
			console.log(data);
			if(data == 0){
			}else{
				$.alert('用户名已存在');
			}
		}
	});
}
function get_code(){
	if($('#code_btn').html() == '已发送'){
		return;
	}
	var phone = $('#phone').val();
	if(!phone.match(/^(1\d{10})$/)){
		$.alert('手机号不正确');
		return;
	}
	$('#code_btn').html('已发送');
	$.ajax({
		type:'POST',
		url: 'util/sendCode',
		dataType:'json',
		data:{phone:phone},
		success: function(data){
			console.log(data);
			if(data.length < 6){
				$.alert('验证码发送失败，请重试');
				$('#code_btn').html('获取');
			}else{
				$('#code_bak').html(data);
			}
		}
	});
}