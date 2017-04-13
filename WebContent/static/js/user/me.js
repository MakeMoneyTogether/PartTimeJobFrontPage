uid_bak = $('#uid_bak');
function jump(p,e){
	if(p < 4){
		$('.jz__div_active').removeClass('jz__div_active');
		$(e).addClass('jz__div_active');
		loading_tag();
		flushJZ(p);
	}
	switch (p){
		case 0:
			console.log("已报名");
			break;
		case 1:
			console.log("已录用");
			break;
		case 2:
			console.log("已到岗");
			break;
		case 3:
			console.log("已结算");
			break;
		case 4:
			console.log("钱包");
			break;
		case 5:
			console.log("修改密码");
			break;
		case 6:
			console.log("邀请好友");
			break;
	}
}
function loading_tag(){
	$('#jz-infos').html('<div class="weui-loadmore"> <i class="weui-loading"></i> <span class="weui-loadmore__tips">正在加载</span> </div>');
}
function genItem(one){
	var item = '<a href="user/info/'+one.jid+'" class="weui-media-box weui-media-box_appmsg"><div class="weui-media-box__hd"><div class="i-circle">'+
				one.jlabel+'</div></div><div class="weui-media-box__bd i-jz"><span class="weui-media-box__title i-jz-title">'+
				one.jname+'</span><br><span class="i-jz-desc">'+one.jlocal+' '+one.jstdate+'开始</span><br><span class="i-jz-money">'+
				one.jmoney+'元/'+one.jtime+'</span></div></a>';
	return item;
}

function flushJZ(sid){
	uid = uid_bak.html();
	$.ajax({
		type: "GET",
		url: 'jzurl/pages/sitem/'+uid+'/'+sid,
		dataType: "json",
		success:function(data){
			$('#jz-infos').html('');
			for(i=0;i<data.length;i++){
				domhtml = genItem(data[i]);
				$('#jz-infos').append(domhtml);
			}
		}
	});
}
$(function(){
	loginId = $.cookie('loginId');
	if(loginId !=null && loginId.length > 6){
		pwd = $.cookie('password');
		$.ajax({
			type:'POST',
			url: 'jzurl/pages/me',
			dataType:'json',
			data:{loginId:loginId,password:pwd},
			success: function(data){
				$('#uname').html(data.name);
				$('#ugpa').html(data.grade);
				$('#money').html(data.balance);
				$('#s0').html(data.s4);
				$('#s1').html(data.s1);
				$('#s2').html(data.s2);
				$('#s3').html(data.s4);
			}
		});
	}else{
		window.location.href='user/login';
	}
});