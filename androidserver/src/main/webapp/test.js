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
	var responsePost = "{\"id\":\"xanbrx88\",\"pwd\":\"1234\"}";
	$.ajax('http://' + ip + '/login.do?responsePost=' + responsePost, {
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













