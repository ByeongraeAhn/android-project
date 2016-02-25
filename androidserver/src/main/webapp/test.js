var ip = 'localhost:8080/androidserver';

//init();
login();

// 접속확인
function init() {
	$.ajax('http://' + ip + '/join.do', {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n');
		}
	});
}

function login() {
	var out_data = "{\"id\":\"xanbrx88\",\"pwd\":\"1234\"}";
	$.ajax('http://' + ip + '/login.do?out_data=' + out_data, {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n');
		}
	});
}













