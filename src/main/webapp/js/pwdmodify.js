$(document).ready(function () {
	$("input[name='oldpassword']").blur(function () {
		var oldpassword = $(this).val();
		if(oldpassword==""){
			$(this).next("font").html("密码不能为空");
		}else {
			$(this).next("font").html("");
		}
		$.ajax({
			"url":"../user/user.do",
			"method":"POST",
			"data":"oldpassword="+oldpassword,
			"async":false,
			"dataType":"text",
			"success":function(result){
				if(result == "true"){
					$("input[name='oldpassword']").next("font").html("");
				}else{
					$("input[name='oldpassword']").next("font").html("旧密码不正确");
				}
			},
			"error":function(result){
				//请求出错
				alert("服务器繁忙")
			}
		});
	});
	$("input[name='newpassword']").blur(function () {
		var oldpassword = $(this).val();
		if(oldpassword==""){
			$(this).next("font").html("请输人新密码");
		}else {
			$(this).next("font").html("");
		}
	})
	$("input[name='rnewpassword']").blur(function () {
		var oldpassword = $(this).val();
		var newpassword = $("input[name='newpassword']").val();
		if(oldpassword==""){
			$(this).next("font").html("请输人二次密码");
		}else {
			$(this).next("font").html("");
		}
		if(oldpassword!=newpassword){
			$(this).next("font").html("两次密码不一致");
		}else {
			$(this).next("font").html("");
		}
	})
	function checkForm() {
		var flag = true;
		$("input[name='oldpassword']").blur();
		$("input[name='newpassword']").blur();
		$("input[name='rnewpassword']").blur();
		$("#userForm font").each(function (index, item) {
			if ($(item).html() != "") {
				flag = false;
			}
		})
		var newpassword = $("input[name='newpassword']").val();
		if (flag) {
			$.ajax({
				url: "../user/modify",
				method: "POST",
				data: "newpassword=" + newpassword,
				dataType: "text",
				success: function (result) {
					if (result.result != "true") {
						alert("密码修改成功")
					} else if (result.result == "false") {//旧密码输入不正确
						alert("密码修改失败")
					}
				},
				error: function (result) {
					//请求出错
					alert("服务器繁忙")
				}
			});
			return flag;
		}
	}
})

