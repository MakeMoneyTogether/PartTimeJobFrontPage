var dises_bak = $('#dises_bak')
var labels_bak = $('#labels_bak')
var dates_bak = $('#dates_bak')
var loading = false;

function onCheckBtn(){
	$('.checkBtn').unbind();
	$('.checkBtn').click(function(){
		if($(this).is('.checkBtnActive')){
			$(this).removeClass('checkBtnActive');
		}else{
			$(this).addClass('checkBtnActive');
		}
	});
	$('.commitBtn').unbind();
	$('.commitBtn').click(freshList);
}

function genItem(one){
	var item = '<a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg"><div class="weui-media-box__hd"><div class="i-circle">'+
				one.jlabel+'</div></div><div class="weui-media-box__bd i-jz"><span class="weui-media-box__title i-jz-title">'+
				one.jname+'</span><br><span class="i-jz-desc">'+one.jlocal+' '+one.jstdate+'开始</span><br><span class="i-jz-money">'+
				one.jmoney+'元/'+one.jtime+'</span></div></a>';
	return item;
}
function loadm(){
	if(loading) return;
	loading = true;
	setTimeout(function() {
		dises = dises_bak.html();
		labels = labels_bak.html();
		dates = dates_bak.html();
		city = $('#ncity')
		data = {dises:dises,labels:labels,dates:dates,city:city};
		$.ajax({
			type: "POST",
			url: "jzurl/pages/0/3",
			dataType: "json",
			data: data,
			success:function(data){
				for(i=0;i<data.length;i++){
					domhtml = genItem(data[i]);
					$('#jz-infos').append(domhtml);
				}
			}
		});
		loading = false;
	}, 1000);  
}
$(document.body).infinite().on("infinite",loadm);


function onLoad(){
	dises = dises_bak.html();
	labels = labels_bak.html();
	dates = dates_bak.html();
	city = $('#ncity').html();
	data = {dises:dises,labels:labels,dates:dates,city:city};
	$('#jz-infos').html('');
	$.ajax({
		type: "POST",
		url: "jzurl/pages/0/6",
		dataType: "json",
		data: data,
		success:function(data){
			for(i=0;i<data.length;i++){
				domhtml = genItem(data[i]);
				$('#jz-infos').append(domhtml);
			}
		}
	});
}

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
		districts.append('<span class="weui-btn weui-btn_mini weui-btn_defualt checkBtn" value="all">全部</span><br>\n')
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
		labels.append('<span class="weui-btn weui-btn_mini weui-btn_defualt checkBtn" value="all">全部</span><br>\n')
		for(i=0;i<data.length;i++){
			labels.append('<span class="weui-btn weui-btn_mini weui-btn_defualt checkBtn" value="'+data[i].lcode+'">'+data[i].lname+'</span>\n')
		}
		labels.append('<br> <button class="weui-btn weui-btn_mini commitBtn">筛选</button> <br> <div class="weui-panel__hd" style="padding:0;"></div>');
		onCheckBtn();
	});
}
function freshList(){
	dises = $('#districts');
	labels = $('#labels');
	dates = $('#stime');
	stdate = $('#jzstdate');
	disbtns = dises.find('.checkBtnActive');
	labelbtns = labels.find('.checkBtnActive');
	datesbtns = dates.find('.checkBtnActive');
	dises = 'all';
	labels = 'all';
	dates = 'all';
	flag = true;
	if(disbtns.length >0 && $(disbtns[0]).attr('value') != 'all'){
		for(i=0;i<disbtns.length;i++){
			if(flag){
				dises = $(disbtns[i]).html();
				flag = false;
			}else{
				dises += ','+$(disbtns[i]).html();
			}
		}
	}
	flag = true;
	if(labelbtns.length >0 && $(labelbtns[0]).attr('value') != 'all'){
		for(i=0;i<labelbtns.length;i++){
			if(flag){
				labels = $(labelbtns[i]).html();
				flag = false;
			}else{
				labels += ','+$(labelbtns[i]).html();
			}
		}
	}
	if(datesbtns.length == 0){
		var time = stdate.val();
		if(time != ''){
			dates = time;
		}
	}
	dises_bak.html(dises);
	labels_bak.html(labels);
	dates_bak.html(dates);
	$('#slocal').hide();
	$('#stype').hide();
	$('#stime').hide();
	onLoad();
}
function localset(){
	$.getScript('http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js', function(data){
	    console.log(remote_ip_info.city);
	    if(remote_ip_info.city == ''){
	    	$('#ncity').html(remote_ip_info.province);
	    }
	    else{
	    	$('#ncity').html(remote_ip_info.city);
	    }
	});
}
function setLocal(){
	cc = $('#city-picker');
	city = cc.val().split(' ')[1];
	$('#ncity').html(city);
}