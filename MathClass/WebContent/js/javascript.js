function menu_over(e) {
	e.setAttribute("class", "nav-item active");
}
function menu_out(e) {
	e.setAttribute("class", "nav-item");
}

$(document).ready(function () {
	  $('#logInForm').submit(function (event) {
		  event.preventDefault();
		var id = $('#logInId').val();
		var pwd = $('#logInPwd').val();
		var result;
		console.log(id,pwd);
		$.post("/WebClass/bloglogin",
				{"id" : id, "pwd" : pwd, "result" : result},
				function(data) {
					console.log(data);
					if(data.result){
						location.href='jsp/login.jsp';	
					}
					else{
						var myModal = $('#myModal');
						myModal.find('.modal-title').text('Login Error');
						myModal.find('.modal-body').text('Invalid username or password');
						myModal.modal();
					}
				});
	  });
});
$(document).ready(
		function() {
			$('#regForm').submit(
					function(event) {
						// submit이 자동으로 되는 기능을 막기
						event.preventDefault();

						// id, pwd가져오기
						// document.getElementById("id").value
						var id = $('#regId').val();
						var pwd = $('#regPwd').val();
						var name = $('#name').val();
						console.log(id, pwd);

						// 서버로 post 전송(ajax)
						$.post("http://httpbin.org/post", {
							"id" : id,
							"pwd" : pwd,
							"name" : name
						}, function(data) {
							var myModal = $('#exampleModal');
							var checkModal = $('#check2Modal');
							checkModal.modal();
							checkModal.find('.modal-body').text(
									data.form.name + "님 회원가입되었습니다.");

							myModal.modal('hide');
						});
					});
		});