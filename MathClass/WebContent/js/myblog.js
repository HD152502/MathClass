
$(document).ready(function () {
	  $('#LoginForm').submit(function (event) {
		  //submit이 자동으로 되는 기능을 막기
		  event.preventDefault();
		  
		  //id, pwd가져오기
		//  document.getElementById("id").value
		var id = $('#id').val();
		var pwd = $('#pwd').val();
		console.log(id,pwd);
		
		//서버로 post 전송(ajax)
		$.post("http://httpbin.org/post",
				{"id" : id, "pwd" : pwd},
				function(data) {
					//alert(data.form.id + '님 로그인되었습니다.');
					var myModal = $('#myModal');
					myModal.modal();
					myModal.find('.modal-body').text(data.form.id + '님 로그인되었습니다.');
				});
	  });
 });

$(document).ready(function () {
	  $('#registerForm').submit(function (event) {
		  //submit이 자동으로 되는 기능을 막기
		  event.preventDefault();
		  
		  //id, pwd가져오기
		//  document.getElementById("id").value
		var id = $('#name').val();
		var pwd = $('#regpwd').val();
		console.log(id,pwd);
		
		//서버로 post 전송(ajax)
		$.post("http://httpbin.org/post",
				{"id" : id, "pwd" : pwd},
				function(data) {
					//alert(data.form.id + '님 로그인되었습니다.');
					var Modal = $('#checkModal');
					Modal.modal();
					  Modal.find('.modal-body').text(data.form.id+'님 회원가입되었습니다.');
					  
					  var regModal=$('#regModal');
					  regModal.modal('hide');
				});
	  });
});
function register() {
	var Modal = $('#regModal');
	Modal.modal();
}