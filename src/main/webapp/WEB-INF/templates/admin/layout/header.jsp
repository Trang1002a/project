<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Blank Page</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
	<link rel="stylesheet" href="<c:url value="/static/css/style.css" />" />
<link rel="stylesheet"
	href="<c:url value="/static/css/bootstrap.min.css" />">
<link rel="stylesheet" href="<c:url value="/static/css/font-awesome.min.css" />">
<link rel="stylesheet"
	href="<c:url value="/static/css/AdminLTE.css" />">
<link rel="stylesheet"
	href="<c:url value="/static/css/_all-skins.min.css" />">
<link rel="stylesheet"
	href="<c:url value="/static/css/jquery-ui.css" />">
<script src="<c:url value="/static/js/angular.min.js"/>"></script>
<script src="<c:url value="/static/js/app.js"/>"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<!-- Site wrapper -->
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="${pageContext.request.contextPath}/admin/" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>A</b>LT</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Admin</b>LTE</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> <span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a>

				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown messages-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-envelope-o"></i> <span class="label label-success">4</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 4 messages</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<li>
											<!-- start message --> <a href="#">
												<div class="pull-left">
													<img src="../../dist/img/user2-160x160.jpg"
														class="img-circle" alt="User Image">
												</div>
												<h4>
													Support Team <small><i class="fa fa-clock-o"></i> 5
														mins</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a>
										</li>
										<!-- end message -->
									</ul>
								</li>
								<li class="footer"><a href="#">See All Messages</a></li>
							</ul></li>
						<!-- Notifications: style can be found in dropdown.less -->
						<li class="dropdown notifications-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-bell-o"></i> <span class="label label-warning">10</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 10 notifications</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<li><a href="#"> <i class="fa fa-users text-aqua"></i>
												5 new members joined today
										</a></li>
									</ul>
								</li>
								<li class="footer"><a href="#">View all</a></li>
							</ul></li>
						<!-- Tasks: style can be found in dropdown.less -->
						<li class="dropdown tasks-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-flag-o"></i> <span class="label label-danger">9</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 9 tasks</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<li>
											<!-- Task item --> <a href="#">
												<h3>
													Design some buttons <small class="pull-right">20%</small>
												</h3>
												<div class="progress xs">
													<div class="progress-bar progress-bar-aqua"
														style="width: 20%" role="progressbar" aria-valuenow="20"
														aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">20% Complete</span>
													</div>
												</div>
										</a>
										</li>
										<!-- end task item -->
									</ul>
								</li>
								<li class="footer"><a href="#">View all tasks</a></li>
							</ul></li>
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="../../dist/img/user2-160x160.jpg" class="user-image"
								alt="User Image"> <span class="hidden-xs">Alexander
									Pierce</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="../../dist/img/user2-160x160.jpg" class="img-circle"
									alt="User Image">

									<p>
										Alexander Pierce - Web Developer <small>Member since
											Nov. 2012</small>
									</p></li>
								<!-- Menu Body -->
								<li class="user-body">
									<div class="row">
										<div class="col-xs-4 text-center">
											<a href="#">Followers</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#">Sales</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#">Friends</a>
										</div>
									</div> <!-- /.row -->
								</li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<div class="pull-right">
										<a href="#" class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul></li>

					</ul>
				</div>
			</nav>
		</header>

		<!-- =============================================== -->

		<!-- Left side column. contains the sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="../../dist/img/user2-160x160.jpg" class="img-circle"
							alt="User Image">
					</div>
					<div class="pull-left info">
						<p>Alexander Pierce</p>
						<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>
				<!-- search form -->
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
							placeholder="Search..."> <span class="input-group-btn">
							<button type="submit" name="search" id="search-btn"
								class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu" data-widget="tree">
					<li class="treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>Quản lý phim</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="${pageContext.request.contextPath}/admin/movies/insert"><i
									class="fa fa-circle-o"></i> Thêm mới</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/movies/index"><i
									class="fa fa-circle-o"></i> Danh sách</a></li>
						</ul></li>

					<li class="treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>Định dạng</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="${pageContext.request.contextPath}/admin/format/insert"><i
									class="fa fa-circle-o"></i> Thêm mới</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/format/index"><i
									class="fa fa-circle-o"></i> Danh sách</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>Thể loại phim</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="${pageContext.request.contextPath}/admin/type/insert"><i
									class="fa fa-circle-o"></i> Thêm mới</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/type/index"><i
									class="fa fa-circle-o"></i> Danh sách</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>Quốc gia</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="${pageContext.request.contextPath}/admin/country/insert"><i
									class="fa fa-circle-o"></i> Thêm mới</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/country/index"><i
									class="fa fa-circle-o"></i> Danh sách</a></li>
						</ul></li>

					<li class="treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>Quản lý lịch chiếu</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="${pageContext.request.contextPath}/admin/showtimes/insert"><i
									class="fa fa-circle-o"></i> Tạo mới</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/showtimes/index"><i
									class="fa fa-circle-o"></i> Danh sách</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/showtimes/searchShowtimes.html"><i
									class="fa fa-circle-o"></i> Tìm kiếm</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>Quản lý vé xem</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="${pageContext.request.contextPath}/admin/ticket/index"><i
									class="fa fa-circle-o"></i> Danh sách</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>Chi nhánh</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="${pageContext.request.contextPath}/admin/branch/insert"><i
									class="fa fa-circle-o"></i> Thêm mới</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/branch/index"><i
									class="fa fa-circle-o"></i> Danh sách</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>Giờ chiếu</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="${pageContext.request.contextPath}/admin/hours/insert"><i
									class="fa fa-circle-o"></i> Thêm mới</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/hours/index"><i
									class="fa fa-circle-o"></i> Danh sách</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>Phòng chiếu</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="${pageContext.request.contextPath}/admin/room/insert"><i
									class="fa fa-circle-o"></i> Thêm mới</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/room/index"><i
									class="fa fa-circle-o"></i> Danh sách</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>Người dùng</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="${pageContext.request.contextPath}/admin/user/insert"><i
									class="fa fa-circle-o"></i> Thêm mới</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/user/index"><i
									class="fa fa-circle-o"></i> Danh sách</a></li>
						</ul></li>

					<li><a href=""> <i class="fa fa-th"></i> <span>Widgets</span>
							<span class="pull-right-container"> <small
								class="label pull-right bg-green">Hot</small>
						</span>
					</a></li>

				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- =============================================== -->

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Blank page <small>it all starts here</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li><a href="#">Examples</a></li>
					<li class="active">Blank page</li>
				</ol>
			</section>