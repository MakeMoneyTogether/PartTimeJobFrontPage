function getMeInfo(){
	$.ajax({
		type: "POST",
		url: 'merurl/json/me',
		dataType: "json",
		success:function(data){
			$('#mname').html(data.mname);
			$('#moneyable').html(data.moneyable);
			$('#moneyice').html(data.moneyice);
		}
	});
}