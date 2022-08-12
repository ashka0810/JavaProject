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
								<form:form class="form" method="post" modelAttribute="user"
									enctype="multipart/form-data">
									<div class="card-content">
										<div class="card-header card-header-icon"
											data-background-color="rose">
											<i class="material-icons">perm_identity</i>
										</div>
										<div class="card-content">
											<h4 class="card-title">
												<c:choose>
													<c:when test="${edit}">
												Edit User Details
											</c:when>
													<c:otherwise>
												Add New User
											</c:otherwise>
												</c:choose>
												<small class="category"></small>
											</h4>
											<div class="row">
												<div class="col-md-6">
													<div class="form-group label-floating">
														<label class="control-label">Email Address</label>
														<form:input type="text" class="form-control" path="email"
															name="email" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<div class="form-group label-floating">
														<label class="control-label">First Name</label>
														<form:input type="text" class="form-control" path="fname"
															name="fname" />
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group label-floating">
														<label class="control-label">Last Name</label>
														<form:input type="text" class="form-control" path="lname"
															name="lname" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<div class="form-group label-floating">
														<label class="control-label">Date Of Birth
															(YYYY-MM-DD)</label>
														<form:input type="text" class="form-control" path="dob"
															name="dob" />
													</div>
												</div>
												<div class="col-md-6">
													<label> Gender </label>
												</div>
												<br>
												<div class="radio">
													<label> <form:radiobutton path="gender"
															value="male" name="gender" /><span class="circle"></span><span
														class="check"></span> Male
													</label> <label> <form:radiobutton path="gender"
															value="female" name="gender" /><span class="circle"></span><span
														class="check"></span> Female
													</label>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<div class="form-group label-floating">
														<label class="control-label">Mobile Number</label>
														<form:input type="text" class="form-control"
															path="mobileNo" name="mobileNo" />
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group label-floating">
														<label class="control-label">Zip Code</label>
														<form:input type="text" class="form-control"
															path="pincode" name="pincode" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12">
													<div class="form-group label-floating">
														<label class="control-label">Address</label>
														<form:input type="text" class="form-control"
															name="address" path="address" />
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-md-3">
													<div class="form-group label-floating">
														<form:select class="selectpicker"
															data-style="btn btn-primary btn-round" data-size="7"
															tabindex="-98" style="background-color: #ec407a"
															path="stateId" name="stateId" id="stateId">
															<c:forEach var="s" items="${liststate}">
																<form:option value="${s.stateId}" label="${s.name}" />
															</c:forEach>
														</form:select>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group label-floating">
														<form:select class="selectpicker"
															data-style="btn btn-primary btn-round"
															title="Single Select" data-size="7" tabindex="-98"
															style="background-color: #ec407a" path="city_id"
															name="city_id" id="cityId">>
											<c:forEach var="c" items="${listcity}">
																<form:option value="${c.city_id}" label="${c.name}" />
															</c:forEach>
														</form:select>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group label-floating">
														<form:select class="selectpicker"
															data-style="btn btn-primary btn-round"
															title="Single Select" data-size="7" tabindex="-98"
															style="background-color: #ec407a" path="areaId"
															id="areaId">
															<c:forEach var="a" items="${listarea}">
																<form:option value="${a.areaId}" label="${a.name}" />
															</c:forEach>
														</form:select>
													</div>
												</div>
											</div>

											<div class="clearfix"></div>

											<c:choose>
												<c:when test="${edit}">
													<input class="btn btn-primary btn-round" type="submit"
														value="Update" formaction="/easypgadmin/user/updateUser" />
												</c:when>
												<c:otherwise>
													<input class="btn btn-primary btn-round" type="submit"
														value="Register" formaction="/easypgadmin/user/addUser" />
												</c:otherwise>
											</c:choose>
											<input class="btn btn-primary btn-round" type="submit"
												value="Back" formaction="/easypgadmin/user/userList" />
								</form:form>
							</div>
						</div>
					</div>
				</div>

				<%@include file="../footer.jsp"%>
			</div>
		</div>
		<script type="text/javascript">
			$("#stateId")
					.change(
							function() {
								var stateId = $(this).val();
								//alert("stateId : "+stateId);
								$
										.ajax({
											type : 'GET',
											url : "/easypadmin/area/getCities/"
													+ stateId,
											success : function(data) {

												var slctSubcat = $('#cityId'), option = "";
												slctSubcat.empty();
												var select = "<option value='0'> --- Select city ---</option>";

												for (var i = 0; i < data.length; i++) {
													option = option
															+ "<option value='"+data[i].city_id + "'>"
															+ data[i].name
															+ "</option>";
												}
												slctSubcat.append(select);
												slctSubcat.append(option);
											},
											error : function() {
												alert("error");
											}
										});
							});
		</script>
		<script type="text/javascript">
			$("#cityId")
					.change(
							function() {
								var cityId = $(this).val();

								$
										.ajax({
											type : 'GET',
											url : "/easypadmin/area/getAreas/"
													+ cityId,
											success : function(data) {

												var slctSubcat = $('#areaId'), option = "";
												slctSubcat.empty();
												var select = "<option value='0'> --- Select area ---</option>";

												for (var i = 0; i < data.length; i++) {
													option = option
															+ "<option value='"+data[i].areaId + "'>"
															+ data[i].name
															+ "</option>";
												}
												slctSubcat.append(select);
												slctSubcat.append(option);
											},
											error : function() {
												alert("error");
											}
										});
							});
		</script>
</body>
<%@include file="../corejsfiles.jsp"%>
</html>