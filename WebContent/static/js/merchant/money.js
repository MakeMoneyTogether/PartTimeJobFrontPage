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
	$.ajax({
		type: "POST",
		url: 'merurl/json/schedule',
		dataType: "json",
		data:{phone:phone},
		success:function(data){
			n = data.length;
			for(i = 0;i<n;i++){
				cellpre = '<div onclick="$.alert(\''+data[i].id+'\',\'交易单号\');" class="weui-cell"><div class="weui-cell__hd"><i class="fa fa-euro"></i></div><div class="weui-cell__bd"><p style="margin-left:10%;">提现 '+data[i].money+'</p></div><div class="weui-cell__ft">';
				if(data[i].statu == 0){
					$('#out_moneys').append(cellpre+'待审核<i class="weui-icon-waiting"></i></div></div>');
				}else if(data[i].statu == 1){
					$('#out_moneys').append(cellpre+'被拒绝<i class="weui-icon-warn"></i></div></div>');
				}else{
					$('#out_moneys').append(cellpre+'成功<i class="weui-icon-success"></i></div></div>');
				}
			}
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