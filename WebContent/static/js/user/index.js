function onCheckBtn(){
	$('.checkBtn').click(function(){
		if($(this).is('.checkBtnActive')){
			$(this).removeClass('checkBtnActive');
		}else{
			$(this).addClass('checkBtnActive');
		}
	});
}

var loading = false;
function loadm(){
	if(loading) return;
	loading = true;
	setTimeout(function() {
	$("#jz-infos").append('<a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg"><div class="weui-media-box__hd"><div class="i-circle">类型</div></div><div class="weui-media-box__bd i-jz"><span class="weui-media-box__title i-jz-title">标题一</span><br><span class="i-jz-desc">江宁 5月1日开始（共10天）</span><br><span class="i-jz-money">100元/天</span><span class="i-jz-date">4分钟前</span></div></a>');
	loading = false;
	}, 1000);  
}
$(document.body).infinite().on("infinite",loadm);

$("#plocal").click(function(){
	$('#slocal').toggle();
	$('#stype').hide();
	$('#stime').hide();
});

$("#ptype").click(function(){
	$('#slocal').hide();
	$('#stype').toggle();
	$('#stime').hide();
});
$("#ptime").click(function(){
	$('#slocal').hide();
	$('#stype').hide();
	$('#stime').toggle();
});


function getDistrict(){
	var ccode = $('#ncity').attr('value');
	$.get('util/city/districts/'+ccode,function(data){
		data = JSON.parse(data);
		var districts = $('#districts');
		districts.html('');
		for(i=0;i<data.length;i++){
			districts.append('<span class="weui-btn weui-btn_mini weui-btn_defualt checkBtn" value="'+data[i]['dcode']+'">'+data[i]['dname']+'</span>\n')
		}
		districts.append('<br> <button class="weui-btn weui-btn_mini commitBtn">筛选</button> <br> <div class="weui-panel__hd" style="padding:0;"></div>');
		onCheckBtn();
	});
}
function getLabels(){
	$.get('util/labels',function(data){
		data = JSON.parse(data);
		var labels = $('#labels');
		labels.html('');
		for(i=0;i<data.length;i++){
			labels.append('<span class="weui-btn weui-btn_mini weui-btn_defualt checkBtn" value="'+data[i].lcode+'">'+data[i].lname+'</span>\n')
		}
		labels.append('<br> <button class="weui-btn weui-btn_mini commitBtn">筛选</button> <br> <div class="weui-panel__hd" style="padding:0;"></div>');
		onCheckBtn();
	});
}