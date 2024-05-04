<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%><!DOCTYPE html>

<html>
<head>
=
<title>Sign up</title>
</head>

<body>
	<!-- Body of Form starts -->
	<div class="container">
		<form action="signup" method="post" autocomplete="on">
			<!--userId-->
			<div class="box">
				<label for="userId" class="fl fontLabel"> User Id: </label>
				<div class="new iconBox">
					<i class="fa fa-user" aria-hidden="true"></i>
				</div>
				<div class="fr">
					<input type="text" name="userId" placeholder="User Id"
						class="textBox" autofocus="on" required>
				</div>
				<div class="clr"></div>
			</div>
			<!--userId-->


			<!--user name-->
			<div class="box">
				<label for="userName" class="fl fontLabel"> User Name: </label>
				<div class="fl iconBox">
					<i class="fa fa-user" aria-hidden="true"></i>
				</div>
				<div class="fr">
					<input type="text" required name="userName" placeholder="User Name"
						class="textBox">
				</div>
				<div class="clr"></div>
			</div>
			<!--user name-->


			<!---Phone No.------>
			<div class="box">
				<label for="phoneNumber" class="fl fontLabel"> Phone number:
				</label>
				<div class="fl iconBox">
					<i class="fa fa-phone-square" aria-hidden="true"></i>
				</div>
				<div class="fr">
					<input type="text" required name="phoneNumber" maxlength="10"
						placeholder="Phone number" class="textBox">
				</div>
				<div class="clr"></div>
			</div>
			<!---Phone No.---->


			<!---Email ID---->
			<!-- div class="box">
				<label for="email" class="fl fontLabel"> Email ID: </label>
				<div class="fl iconBox">
					<i class="fa fa-envelope" aria-hidden="true"></i>
				</div>
				<div class="fr">
					<input type="email" required name="email" placeholder="Email Id"
						class="textBox">
				</div>
				<div class="clr"></div>
			</div-->
			<!--Email ID----->


			<!---Password------>
			<div class="box">
				<label for="passWord" class="fl fontLabel"> Password </label>
				<div class="fl iconBox">
					<i class="fa fa-key" aria-hidden="true"></i>
				</div>
				<div class="fr">
					<input type="Password" required name="passWord"
						placeholder="Password" class="textBox">
				</div>
				<div class="clr"></div>
			</div>
			<!---Password---->




			<!---Submit Button------>

			<!-- div class="box" style="background: #2d3e3f">
				<input type="Submit" name="Submit" class="submit" value="SUBMIT">
			</div-->
			<input type="hidden" value="signup" name="action" />
            <button class="btn mt-3">Sign up</button>
			<!---Submit Button----->
		</form>
	</div>
</body>


</html>