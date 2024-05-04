<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<meta charset="UTF-8">
	<!--name of page-->
	<title>profile</title>
</head>

<body>
	<div class="container emp-profile">
		<form method="post">
			<div class="row">
				<div class="col-md-4">
					<div class="profile-img">
						<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog"
							alt="" />
						<div class="file btn btn-lg btn-primary">
							Change Photo <input type="file" name="file" />
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="profile-head">
						<a>${USER.userName}</a>
						<h6>${USER.userId}</h6>
						<div id="profileStats">
							<p style="display: inline-block; margin-right: 10px;">
								Follower: ${USER.numberFollower}<span id="followerCount"></span>
							</p>
							<p style="display: inline-block; margin-right: 10px;">
								Posts: ${USER.numberPost}<span id="postCount"></span>
							</p>
							<p style="display: inline-block;">
								Following: ${USER.numberFollowing}<span id="followingCount"></span>
							</p>
						</div>

					</div>
				</div>
				<inputtype="submit" class="col-md-2">
					<a class="nav-link btn btn-primary" href='<c:url value="/home"/>'>Home</a>
					<a class="nav-link btn btn-success" href='<c:url value="/editprofile"/>'>Edit Profile</a>
					<a class="nav-link btn btn-danger" href='<c:url value="/signin?action=signout"/>'>Sign out</a>

				</inputtype="submit">

			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="profile-work">
						<p>WORK LINK</p>
						<a href="">Website Link</a><br /> <a href="">Bootsnipp
							Profile</a><br /> <a href="">Bootply Profile</a>
						<p>SKILLS</p>
						<a href="">Web Designer</a><br /> <a href="">Web Developer</a><br />
						<a href="">WordPress</a><br /> <a href="">WooCommerce</a><br />
						<a href="">PHP, .Net</a><br />
					</div>
				</div>
				<div class="col-md-8">
					<div class="tab-content profile-tab" id="myTabContent">
						<div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
							<div class="row">
								<div class="col-md-6">
									<label>User Id</label>
								</div>
								<div class="col-md-6">
									<p>${USER.userId}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Name</label>
								</div>
								<div class="col-md-6">
									<p>${USER.userName}</p>
								</div>
							</div>

							<div class="row">
								<div class="col-md-6">
									<label>Phone</label>
								</div>
								<div class="col-md-6">
									<p>${USER.phoneNumber}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Birth Day</label>
								</div>
								<div class="col-md-6">
									<c:if test="${empty USER.birthDay}">
										<p>Blank</p>
									</c:if>
									<c:if test="${not empty USER.birthDay}">
										<p>${USER.birthDay}</p>
									</c:if>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Description</label>
								</div>
								<div class="col-md-6">
									<c:if test="${empty USER.birthDay}">
										<p>Blank</p>
									</c:if>
									<c:if test="${not empty USER.birthDay}">
										<p>${USER.shortDescription}</p>
									</c:if>
								</div>
							</div>
						</div>
						<div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
							<div class="row">
								<div class="col-md-6">
									<label>Experience</label>
								</div>
								<div class="col-md-6">
									<p>Expert</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Hourly Rate</label>
								</div>
								<div class="col-md-6">
									<p>10$/hr</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Total Projects</label>
								</div>
								<div class="col-md-6">
									<p>230</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>English Level</label>
								</div>
								<div class="col-md-6">
									<p>Expert</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Availability</label>
								</div>
								<div class="col-md-6">
									<p>6 months</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<label>Your Bio</label><br />
									<p>Your detail description</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

</body>

</html>