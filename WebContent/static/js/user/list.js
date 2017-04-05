var loading = false;
function loadm(){
	if(loading) return;
	loading = true;
	setTimeout(function() {
		city = $('#city_bak').html();
		data = {dises:'all',labels:'all',dates:'all',city:city};
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
