var jid_bak = $('#jid_bak');
var opBtn = $('#opBtn');
function getItem(){
	uri = window.location.href;
	uris = uri.split('/');
	jid = uris[uris.length -1];
	jid_bak.html(jid);
	$.get('jzurl/pages/item/'+jid,function(data){
		item = $.parseJSON(data); 
		$('#jz-title').html(item.jname);
		$('#jz-name').html(item.jname);
		$('#jz-money').html(item.jmoney);
		$('#jz-label').html(item.jlabel);
		$('#jz-date').html(item.jstdate);
		$('#jz-local').html(item.jlocal);
	});
}

function getStatu(){
	var jid = jid_bak.html();
	var phone = $.cookie('phone');
	if(phone !=null && phone.length > 6){
		$.get('jzurl/pages/u2j/'+phone+'/'+jid,function(data){
			genBtn(parseInt(data));
		});
	}
}

function genBtn(code){
	if(code > 0){
		opBtn.addClass('weui-btn_disabled');
	}
	switch(code){
		case 0:
			opBtn.attr('onclick','apply();');
			break;
		case 1:
			opBtn.html('已报名');
			break;
		case 2:
			opBtn.html('已录用');
			break;
		case 3:
			opBtn.html('已到岗');
			break;
		case 4:
			opBtn.html('已结算');
			break;
	}
}

function apply(){
	var jid = jid_bak.html();
	var phone = $.cookie('phone');
	$.get('jzurl/pages/apply/'+phone+'/'+jid,function(data){
		data = JSON.parse(data);
		$('#jz-num').html(data.applied+'/'+data.all+'人');
		if(data.code == 0){
			$.toast('报名成功');
			opBtn.addClass('weui-btn_disabled');
			opBtn.html('已报名');
		}
		if(data.code == 1){
			$.toast('报名失败，人数已满');
		}
		if(data.code == 2){
			$.toast('报名失败，余额不足');
		}
		if(data.code == 3){
			$.toast('报名失败，时段重复');
		}
	});
}