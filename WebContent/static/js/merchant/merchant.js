function jump(k){
	switch(k){
		case 1:
			window.location.href='mer/issue';
			break;
		case 2:
			window.location.href='mer/list';
			break;
		case 3:
			window.location.href='mer/index';
			break;
		case 4:
			window.location.href='mer/edit';
			break;
		case 5:
			window.location.href='mer/money';
			break;
		case 6:
			$('#repass').popup();
			break;
		case 7:
			window.location.href='mer/login';
	}
}