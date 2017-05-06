function jump(k){
	switch(k){
		case 1:
			window.location.href='mer/issue.html';
			break;
		case 2:
			window.location.href='mer/list.html';
			break;
		case 3:
			window.location.href='mer/index.html';
			break;
		case 4:
			window.location.href='mer/edit.html';
			break;
		case 5:
			window.location.href='mer/money.html';
			break;
		case 6:
			$('#repass').popup();
			break;
		case 7:
			window.location.href='mer/login.html';
	}
}