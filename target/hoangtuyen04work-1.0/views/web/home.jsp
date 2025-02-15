<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>

<body>
	<nav class="navbar navbar-light bg-white">
		<a href="#" class="navbar-brand">Bootsbook</a>
		<form class="form-inline">
			<div class="input-group">
				<input type="text" class="form-control" aria-label="Recipient's username"
					aria-describedby="button-addon2">
				<div class="input-group-append">
					<button class="btn btn-outline-primary" type="button" id="button-addon2">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
		</form>
	</nav>


	<div class="container-fluid gedf-wrapper">
		<div class="row">
			<div class="col-md-3">
				<div class="card">
					<div class="card-body">
						<div class="h5">@LeeCross</div>
						<div class="h7 text-muted">Fullname : Miracles Lee Cross</div>

					</div>
					<ul class="list-group list-group-flush">
						<div class="home-button">
							<a href="home.html"> <i class="fa fa-home"></i> <span>Home</span>
							</a>
						</div>
						<div class="profile-button">
							<a href="profile.html"> <i class="fa fa-user"></i> <span>Profile</span>
							</a>
						</div>
						<div class="more-settings-button">
							<a href="settings.html"> <i class="fa fa-cog"></i> <span>More
									Settings</span>
							</a>
						</div>
					</ul>
				</div>
			</div>
			<div class="col-md-6 gedf-main">

				<!--- \\\\\\\Post-->
				<div class="card gedf-card">
					<div class="card-header">
						<ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
							<li class="nav-item"><a class="nav-link active" id="posts-tab" data-toggle="tab"
									href="#posts" role="tab" aria-controls="posts" aria-selected="true">Make a
									publication</a></li>

						</ul>
					</div>
					<div class="card-body">
						<div class="tab-content" id="myTabContent">
							<div class="tab-pane fade show active" id="posts" role="tabpanel"
								aria-labelledby="posts-tab">
								<div class="form-group">
									<label class="sr-only" for="message">post</label>
									<textarea class="form-control" id="message" rows="3"
										placeholder="What are you thinking?"></textarea>

								</div>

							</div>
							<div class="tab-pane fade" id="images" role="tabpanel" aria-labelledby="images-tab">
								<div class="form-group">
									<div class="custom-file">
										<input type="file" class="custom-file-input" id="customFile">
										<label class="custom-file-label" for="customFile">Upload
											image</label>
									</div>
								</div>
								<div class="py-4"></div>
							</div>
						</div>
						<div class="btn-toolbar justify-content-between">
							<div class="btn-group">
								<button type="submit" class="btn btn-primary">share</button>
								<script>
									document.addEventListener("DOMContentLoaded", function () {
										document.getElementById("button-addon2").addEventListener("click", function () {
											// Lấy nội dung từ textarea
											var message = document.getElementById("message").value;

											// Tạo đối tượng XMLHttpRequest
											var xhr = new XMLHttpRequest();
											
											// Thay đổi URL gửi yêu cầu POST
											xhr.open("POST", "/home?action=addpost", true);

											// Chuyển dữ liệu vào body của yêu cầu POST
											xhr.send(JSON.stringify({ "message": message }));
											


											// Xử lý sự kiện khi nhận được phản hồi từ máy chủ
											xhr.onreadystatechange = function () {
												if (xhr.readyState === 4 && xhr.status === 200) {
													// Xử lý phản hồi từ máy chủ (nếu cần)
													console.log(xhr.responseText);
												}
											};

											// Chuyển đổi dữ liệu thành định dạng JSON
											var data = JSON.stringify({
												"message": message
											});

											// Gửi yêu cầu
											xhr.send(data);
										});
									});
								</script>
								
							</div>
							<div class="btn-group">
								<button id="btnGroupDrop1" type="button" class="btn btn-link dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									<i class="fa fa-globe"></i>
								</button>
								<div class="dropdown-menu dropdown-menu-right" aria-labelledby="btnGroupDrop1">
									<a class="dropdown-item" href="#"><i class="fa fa-globe"></i>
										Public</a> <a class="dropdown-item" href="#"><i class="fa fa-users"></i>
										Friends</a> <a class="dropdown-item" href="#"><i class="fa fa-user"></i> Just
										me</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Post /////-->



				<c:forEach var="post" items="${POSTS}">
					<!--- \\\\\\\Post-->
					<div class="card gedf-card">
						<div class="card-header">
							<div class="d-flex justify-content-between align-items-center">
								<div class="d-flex justify-content-between align-items-center">
									<div class="mr-2">
										<img class="rounded-circle" width="45" src="https://picsum.photos/50/50" alt="">
									</div>
									<div class="ml-2">
										<div class="h5 m-0">${post.idUser}</div>
									</div>
								</div>
								<div>
									<div class="dropdown">
										<button class="btn btn-link dropdown-toggle" type="button" id="gedf-drop1"
											data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
											<i class="fa fa-ellipsis-h"></i>
										</button>
										<div class="dropdown-menu dropdown-menu-right" aria-labelledby="gedf-drop1">
											a
											<div class="h6 dropdown-header">Configuration</div>
											<a class="dropdown-item" href="#">Save</a> <a class="dropdown-item"
												href="#">Hide</a> <a class="dropdown-item" href="#">Report</a>
										</div>
									</div>
								</div>
							</div>

						</div>
						<div class="card-body">
							<div class="text-muted h7 mb-2">
								<i class="fa fa-clock-o"></i> 10 min ago
							</div>
							<a class="card-link" href="#">
								<h5 class="card-title">${post.content}</h5>
							</a>

						</div>
						<div class="card-footer">
							<a href="#" class="card-link"><i class="fa fa-gittip"></i>
								Like</a> <a href="#" class="card-link"><i class="fa fa-comment"></i>
								Comment</a> <a href="#" class="card-link"><i class="fa fa-mail-forward"></i> Share</a>
						</div>
					</div>
					<!-- Post /////-->

				</c:forEach>



			</div>
			<div class="col-md-3">
				<div class="card gedf-card">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="card-link">Card link</a> <a href="#" class="card-link">Another link</a>
					</div>
				</div>
				<div class="card gedf-card">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="card-link">Card link</a> <a href="#" class="card-link">Another link</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>