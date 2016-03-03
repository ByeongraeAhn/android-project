var ip = 'localhost:8080/androidserver';

//init();
//login();
checkLogin('a212121','aaa');

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

function checkLogin(mname, mpwd) {

    /* var params = {
      ID : id
      ,
      PASS : pass
      ,
      AUTOLOGIN : 'N'
    };
    $.ajax({
      type : 'GET',
      url : "http://172.16.1.50:8080/myweb/cb.jsp",
      data : params,
      contentType : "Content-Type: application/javascript",
      dataType : "jsonp",
      jsonp : "callback",
      jsonpCallback : "jsonpCallback",
      error : function(xhr, ajaxOptions, thrownError) {
        alert("Error: " + xhr.status + "\n" +
        "Message: " + xhr.statusText + "\n" +
        "Response: " + xhr.responseText + "\n" + thrownError);
      }
    }); */
    
/*     var params = {
    	      mname : mname
    	      ,
    	      mpwd : mpwd
    	    }; */
	  $.ajax('http://' + ip + '/login.do?mname='+mname+'&mpwd='+mpwd, {
	    method: 'GET',
	    /* data : params */
	    dataType: 'json',
	    success: function(result) {
	    	alert('성공함');
	    },
	    error: function(xhr, textStatus, errorThrown) {
	      alert('작업을 완료할 수 없습니다.\n' + 
	          '잠시 후 다시 시도하세요.\n');
	    }
	  });
  }













