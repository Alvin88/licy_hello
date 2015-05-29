<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta content="IE=11.0000" http-equiv="X-UA-Compatible">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<meta name="GENERATOR" content="MShtml 11.00.9600.17496">
<title>系统登录</title> 
<link rel="stylesheet"	href="css/login.css" type="text/css"></link>
<script src="jslib/jquery-easyui-1.4.2/jquery.min.js" type="text/javascript"></script>
<script src="jslib/jquery-easyui-1.4.2/jquery.easyui.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	//得到焦点
	$("#password").focus(function(){
		$("#left_hand").animate({
			left: "150",
			top: " -38"
		},{step: function(){
			if(parseInt($("#left_hand").css("left"))>140){
				$("#left_hand").attr("class","left_hand");
			}
		}}, 2000);
		$("#right_hand").animate({
			right: "-64",
			top: "-38px"
		},{step: function(){
			if(parseInt($("#right_hand").css("right"))> -70){
				$("#right_hand").attr("class","right_hand");
			}
		}}, 2000);
	});
	//失去焦点
	$("#password").blur(function(){
		$("#left_hand").attr("class","initial_left_hand");
		$("#left_hand").attr("style","left:100px;top:-12px;");
		$("#right_hand").attr("class","initial_right_hand");
		$("#right_hand").attr("style","right:-112px;top:-12px");
	});
	
	
	
	$("a[id='userLogin']").click(function(){
		 var username = $("#username").val();
		 var userpassword = $("#password").val();
		 if ($.trim(username) == "" || $.trim(userpassword) == "") {
			 $("#errorMessage").text("用户名或密码不能为空，请输入用户名和密码");
             return false;
         }
         else {
        	 $("#user_login_loginForm").submit();
         }
	});
	
});
</script>
 
</head> 
<body>
<div class="top_div"></div>
<div style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;">
<div style="width: 165px; height: 96px; position: absolute;">
<div class="tou"></div>
<div class="initial_left_hand" id="left_hand"></div>
<div class="initial_right_hand" id="right_hand"></div>
</div>
  <form id="user_login_loginForm" action="${pageContext.request.contextPath}/userAction!login.action" method="post">
	<p style="padding: 30px 0px 10px; position: relative;">
	   <span class="u_logo"></span>
	   <input id="username" name="name" class="ipt" type="text" placeholder="请输入用户名或邮箱" value="" /> 
	</p>
	<p style="position: relative;">
	<span class="p_logo"></span>         
	<input class="ipt" id="password" name="pwd" type="password" placeholder="请输入密码" value="" />   
	</p>
	<div style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
		<p style="margin: 0px 35px 20px 45px;">
			<span style="float: left;">
			<a style="color: rgb(204, 204, 204);" 
				href="#">忘记密码?</a>
			</span> 
			<span style="float: right;">
			<a style="color: rgb(204, 204, 204); margin-right: 10px;" 
				href="#">注册</a>  
			<a id="userLogin" style="cursor: hand;background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" 
			 	href="#">登录</a> 
			 </span>         
		</p>
	</div>
	</form>
</div>

<div style="text-align:center;">
	<p>支撑联系:<a href="#" target="_blank">偶成工作室</a></p>
	<p ><span id="errorMessage" style="color:red;">${error}&nbsp;</span></span></p>
</div>
</body>
</html>
