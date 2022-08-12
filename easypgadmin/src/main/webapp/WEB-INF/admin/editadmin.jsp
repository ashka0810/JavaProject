<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../head.jsp"%>
</head>
<body>
	<noscript>
		<iframe src="https://www.googletagmanager.com/ns.html?id=GTM-NKDMSK6"
			height="0" width="0" style="display: none; visibility: hidden"></iframe>
	</noscript>
	<div class="wrapper">
		<%@include file="../sidebar.jsp"%>
		<div class="main-panel">
			<%@include file="../header.jsp"%>
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header card-header-icon"
									data-background-color="rose">
									<i class="material-icons">perm_identity</i>
								</div>
								<div class="card-content">
									<h4 class="card-title">
										Profile <small class="category"></small>
									</h4>
									<form:form class="form" method="post"
										modelAttribute="viewdetails" enctype="multipart/form-data">
										<form:input type="hidden" path="adminId" name="adminId" />
										<div class="card-content">
											<div class="row" style="margin-left: 340px">
												<div class="col-md-2 col-md-offset-1">
													<div class="fileinput fileinput-new text-center"
														data-provides="fileinput"
														style="margin-top: -10px; margin-left: 0%"></div>
												</div>
											</div>

											<div class="input-group">
												<span class="input-group-addon"> <i
													class="material-icons">face</i>
												</span>
												<form:input type="text" class="form-control"
													placeholder="First Name..." path="fname" name="fname"
													disabled="disabled" />
											</div>
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="material-icons">person</i>
												</span>
												<form:input type="text" class="form-control"
													placeholder="Last Name..." path="lname" name="lname"
													disabled="disabled" />
											</div>

											<div class="input-group">
												<span class="input-group-addon"> <i
													class="material-icons">email</i>
												</span>
												<form:input type="text" class="form-control"
													placeholder="Email..." path="email" name="email"
													disabled="disabled" />
											</div>
										</div>
										<div class="footer text-center">
											<input class="btn btn-primary btn-round" type="submit"
												value="Back" formaction="/easypgadmin/admin/adminList" />

										</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
					<%@include file="../footer.jsp"%>
				</div>
			</div>
</body>
<%@include file="../corejsfiles.jsp"%>
</html>