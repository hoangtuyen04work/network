<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />
	<title>Dashboard - Ace Admin</title>

	<meta name="description" content="overview &amp; stats" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

	<!-- bootstrap & fontawesome -->
	<link rel="stylesheet" href="template/admin/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="template/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

	<!-- page specific plugin styles -->

	<!-- text fonts -->
	<link rel="stylesheet" href="template/admin/assets/fonts/fonts.googleapis.com.css" />

	<!-- ace styles -->
	<link rel="stylesheet" href="template/admin/assets/css/ace.min.css" class="ace-main-stylesheet"
		id="main-ace-style" />

	<!--[if lte IE 9]>
			<link rel="stylesheet" href="template/admin/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->

	<!--[if lte IE 9]>
		  <link rel="stylesheet" href="template/admin/assets/css/ace-ie.min.css" />
		<![endif]-->

	<!-- inline styles related to this page -->

	<!-- ace settings handler -->
	<script src="template/admin/assets/js/ace-extra.min.js"></script>

	<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

	<!--[if lte IE 8]>
		<script src="template/admin/assets/js/html5shiv.min.js"></script>
		<script src="template/admin/assets/js/respond.min.js"></script>
		<![endif]-->
</head>


<body>
	<div class="container">
		<dec:body />
	</div>
	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script src="template/admin/assets/js/jquery.2.1.1.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="template/admin/assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->

	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery ||
			document.write("<script src='template/admin/assets/js/jquery.min.js'>" +
				"<" + "/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='template/admin/assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
			.write("<script src='template/admin/assets/js/jquery.mobile.custom.min.js'>" +
				"<" + "/script>");
	</script>
	<script src="template/admin/assets/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="template/admin/assets/js/excanvas.min.js"></script>
		<![endif]-->
	<script src="template/admin/assets/js/jquery-ui.custom.min.js"></script>
	<script src="template/admin/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="template/admin/assets/js/jquery.easypiechart.min.js"></script>
	<script src="template/admin/assets/js/jquery.sparkline.min.js"></script>
	<script src="template/admin/assets/js/jquery.flot.min.js"></script>
	<script src="template/admin/assets/js/jquery.flot.pie.min.js"></script>
	<script src="template/admin/assets/js/jquery.flot.resize.min.js"></script>

	<!-- ace scripts -->
	<script src="template/admin/assets/js/ace-elements.min.js"></script>
	<script src="template/admin/assets/js/ace.min.js"></script>
</body>

</html>