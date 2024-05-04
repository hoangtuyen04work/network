<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
</head>
<body>
	<div class="wrapper">
        <div class="logo">
            <img src="https://www.freepnglogos.com/uploads/twitter-logo-png/twitter-bird-symbols-png-logo-0.png" alt="">
        </div>
        <div class="text-center mt-4 name">
            Twitter
        </div>
        
		<form action='signin' id="formLogin" method="post">
            <div class="form-field d-flex align-items-center">
                <span class="far fa-user"></span>
                <input type="text" name="userId" id="userId" placeholder="Username">
            </div>
            <div class="form-field d-flex align-items-center">
                <span class="fas fa-key"></span>
                <input type="password" name="passWord" id="passWord" placeholder="Password">
            </div>
            <input type="hidden" value="signin" name="action" />
            <button class="btn mt-3">Login</button>
        </form>
        <div class="text-center fs-6">
        <li class="nav-item"><a class="nav-link" href='<c:url value="/signup?action=signup"/>'>Sign up</a>
        </div>
    </div>
</body>
</html>