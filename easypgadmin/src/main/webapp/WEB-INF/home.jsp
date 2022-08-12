<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">


<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>

<%@include file="head.jsp"%>
</head>
<body>
	<noscript>
		<iframe src="https://www.googletagmanager.com/ns.html?id=GTM-NKDMSK6"
			height="0" width="0" style="display: none; visibility: hidden"></iframe>
	</noscript>

	<div class="wrapper">

		<div class="sidebar" data-active-color="rose"
			data-background-color="black"
			data-image="/easypgadmin/resources/demos.creative-tim.com/bs3/material-dashboard-pro/assets/img/sidebar-1.jpg">
			<div class="logo">
				<a class="simple-text logo-mini"> PG </a> <a
					class="simple-text logo-normal"> Easy-PG </a>
			</div>
			<div class="sidebar-wrapper">
				<div class="user">
					<div class="info">
						<a data-toggle="collapse" href="#collapseExample"
							class="collapsed"> <span> Hello, Meshwa Patel <b
								class="caret"></b>
						</span>
						</a>
						<div class="clearfix"></div>
						<div class="collapse" id="collapseExample">
							<ul class="nav">

								<li><a href="/easypgadmin/admin/editAdmin/${admin.adminId}">
										<span class="sidebar-mini"> EP </span> <span
										class="sidebar-normal"> Edit Profile </span>
								</a></li>
								<li><a href="/easypgadmin/admin/adminList"> <span
										class="sidebar-mini"> AL</span> <span class="sidebar-normal">
											Admin List </span>
								</a></li>

								<li><a href="/easypgadmin/admin/login"> <span
										class="sidebar-mini"> LO </span> <span class="sidebar-normal">
											Logout </span>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
				<ul class="nav">

					<li><a href="/easypgadmin/user/userList"> <i
							class="material-icons">settings_applications</i>
							<p>Manage Users</p>
					</a></li>

					<li><a data-toggle="collapse" href="#componentsExamples">
							<i class="material-icons">location_on</i>
							<p>
								Manage Location <b class="caret"></b>
							</p>
					</a>

						<div class="collapse" id="componentsExamples">
							<ul class="nav">
								<li><a href="/easypgadmin/area/areaList"> <span
										class="sidebar-mini"> A </span> <span class="sidebar-normal">
											Area </span>
								</a></li>
								<li><a href="/easypgadmin/city/cityList"> <span
										class="sidebar-mini"> C </span> <span class="sidebar-normal">
											City </span>
								</a></li>
								<li><a href="/easypgadmin/city/stateList"> <span
										class="sidebar-mini"> S </span> <span class="sidebar-normal">
											State </span>
								</a></li>
							</ul>
						</div></li>


					<li><a data-toggle="collapse" href="#tablesExamples"> <i
							class="material-icons">house</i>
							<p>
								Manage Property <b class="caret"></b>
							</p>
					</a>

						<div class="collapse" id="tablesExamples">
							<ul class="nav">
								<li><a href="/easypgadmin/property/propertyList"> <span
										class="sidebar-mini"> L </span> <span class="sidebar-normal">
											Listed Properties </span>
								</a></li>



							</ul>
						</div></li>


				</ul>
			</div>
		</div>
		<div class="main-panel">
			<%@include file="header.jsp"%>
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-content">
									<h3 align="center">Welcome</h3>
									<br />
								</div>
							</div>
						</div>
					</div>
				</div>




			</div>
		</div>
		<%@include file="footer.jsp"%>
	</div>
	</div>
</body>

<%@include file="corejsfiles.jsp"%>
</html>
