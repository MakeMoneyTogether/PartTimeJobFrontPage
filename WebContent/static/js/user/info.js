function getItem(){
	uri = window.location.href;
	uris = uri.split('/');
	jid = uris[uris.length -1];
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