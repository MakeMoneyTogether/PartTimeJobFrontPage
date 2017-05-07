function init(){
	phone = $.cookie('phone');
	$.ajax({
		type: "POST",
		url: 'merurl/json/me',
		dataType: "json",
		data:{phone:phone},
		success:function(data){
			$('#moneyable').html(data.moneyable);
			$('#moneyice').html(data.moneyice);
		}
	});
}
function cash(){
	$.prompt({
		title: '提现',
		text: '请输入提现金额',
		input: '100.0',
		empty: false, // 是否允许为空
		onOK: function (input) {
			//点击确认
		},
		onCancel: function () {
			//点击取消
		}
	});
}
$(function(){
	for(i=0;i<10;i++){
		$('#out_moneys').append('<div class="weui-cell"><div class="weui-cell__hd"><i class="fa fa-euro"></i></div><div class="weui-cell__bd"><p style="margin-left:10%;">提现 200.0</p></div><div class="weui-cell__ft"><i class="weui-icon-waiting"></i></div></div>');
	}
	for(i=0;i<5;i++){
		$('#out_moneys').append('<div class="weui-cell"><div class="weui-cell__hd"><i class="fa fa-euro"></i></div><div class="weui-cell__bd"><p style="margin-left:10%;">提现 200.0</p></div><div class="weui-cell__ft"><i class="weui-icon-success"></i></div></div>');
	}
});