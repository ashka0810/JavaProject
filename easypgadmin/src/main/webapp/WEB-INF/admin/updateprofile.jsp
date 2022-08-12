<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
										Add Admin<small class="category"></small>
									</h4>
									<form class="form" method="post" action="#">
										<div class="card-content">

											<div class="row">
												<div class="input-group">
													<span class="input-group-addon"> <i
														class="material-icons">face</i>
													</span> <input type="text" class="form-control"
														placeholder="Username...">
												</div>

												<div class="input-group">
													<span class="input-group-addon"> <i
														class="material-icons">email</i>
													</span> <input type="text" class="form-control"
														placeholder="Email...">
												</div>

												<div class="input-group">
													<span class="input-group-addon"> <i
														class="material-icons">lock_outline</i>
													</span> <input type="password" placeholder="Password..."
														class="form-control" />
												</div>

												<div class="input-group">
													<span class="input-group-addon"> <i
														class="material-icons">lock_outline</i>
													</span> <input type="password" placeholder="Confirm Password..."
														class="form-control" />
												</div>

												<div class="checkbox">
													<label> <input type="checkbox"
														name="optionsCheckboxes" checked> I agree to the <a
														href="#something">terms and conditions</a>.
													</label>
												</div>
											</div>
											<div class="footer text-center">
												<a href="#pablo" class="btn btn-primary btn-round">Get
													Started</a>
											</div>
									</form>
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