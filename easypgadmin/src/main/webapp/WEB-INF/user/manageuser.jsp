<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html> 
<html lang="en"> 

<meta http-equiv="content-type" content="text/html;charset=utf-8" />

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
									<i class="material-icons">assignment</i>
								</div>

								<div class="card-content">
									<h4 class="card-title">User</h4>
									<button type="button" rel="tooltip"
										class="btn btn-info btn-simple" rel="tooltip"
										data-placement="bottom" title="Add"
										style="margin-left: 91%; margin-top: -4%">
										<a href="/easypgadmin/user/userRegistrationPage"><i
											class="material-icons icon-image-preview"
											style="color: #ec407a; font-size: 50px">add_box</i>
									</button>
									</a>
									<div class="row">
									<div class="col-md-3">
											<div class="form-group label-floating">
												<a href="/easypgadmin/user/userList">
													<button type="button" rel="tooltip"
														class="btn btn-info btn-simple" rel="tooltip"
														data-placement="bottom" title="View">All Users
														<i class="material-icons">person</i>
													</button>
												</a>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group label-floating">
												<a href="/easypgadmin/user/landlordList">
													<button type="button" rel="tooltip"
														class="btn btn-info btn-simple" rel="tooltip"
														data-placement="bottom" title="View">Landlords
														<i class="material-icons">person</i>
													</button>
												</a>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group label-floating">
												<a href="/easypgadmin/user/tenantList">
													<button type="button" rel="tooltip"
														class="btn btn-info btn-simple" rel="tooltip"
														data-placement="bottom" title="View">Tenants
														<i class="material-icons">person</i>
													</button>
												</a>
											</div>
										</div>
									</div>
									<div class="toolbar">
									</div>

									<div class="material-datatables">
										<div id="datatables_wrapper"
											class="dataTables_wrapper form-inline dt-bootstrap">
											<div class="row">
												<div class="col-sm-6">
													
												</div>
												<div class="col-sm-6">
													<div id="datatables_filter" class="dataTables_filter">
														</div>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-12">
													<table id="datatables"
														class="table table-striped table-no-bordered table-hover dataTable dtr-inline"
														cellspacing="0" width="100%" style="width: 100%;"
														role="grid" aria-describedby="datatables_info">
														<thead>
															<tr role="row">
																<th  tabindex="0"
																	aria-controls="datatables" rowspan="1" colspan="1"
																	style="width: 160px;" aria-sort="ascending"
																	aria-label="Name: activate to sort column descending">First
																	Name</th>
																<th  tabindex="0"
																	aria-controls="datatables" rowspan="1" colspan="1"
																	style="width: 160px;" aria-sort="ascending"
																	aria-label="Name: activate to sort column descending">Last
																	Name</th>

																<th  tabindex="0"
																	aria-controls="datatables" rowspan="1" colspan="1"
																	style="width: 220px;"
																	aria-label="Position: activate to sort column ascending">EmailID</th>
																<th  tabindex="0"
																	aria-controls="datatables" rowspan="1" colspan="1"
																	style="width: 150px;"
																	aria-label="Office: activate to sort column ascending">Contact
																	No</th>
																<th  tabindex="0"
																	aria-controls="datatables" rowspan="1" colspan="1"
																	style="width: 150px;"
																	aria-label="Position: activate to sort column ascending">DOB</th>
																<th  tabindex="0"
																	aria-controls="datatables" rowspan="1" colspan="1"
																	style="width: 150px;"
																	aria-label="Position: activate to sort column ascending">Gender</th>
																
															</tr>
														</thead>
														
														<tbody>
															<c:forEach items="${userList}" var="user">
																<tr role="row" class="odd">
																	<td tabindex="0" class="sorting_1">${user.fname}</td>
																	<td>${user.lname}</td>
																	<td>${user.email}</td>
																	<td>${user.mobileNo}</td>
																	<td>${user.dob}</td>
																	<td>${user.gender}</td>
																	
																	<td class="td-actions text-right"><a
																		href="/easypgadmin/user/viewUser/${user.userId}">
																			<button type="button" rel="tooltip"
																				class="btn btn-info btn-simple" rel="tooltip"
																				data-placement="bottom" title="View">
																				<i class="material-icons">person</i>
																			</button>
																	</a> <a href="/easypgadmin/user/editUser/${user.userId}">
																			<button type="button" rel="tooltip"
																				class="btn btn-success btn-simple" rel="tooltip"
																				data-placement="bottom" title="Edit">
																				<i class="material-icons">edit</i>
																			</button>
																	</a> <a href="/easypgadmin/user/deleteUser/${user.userId}">
																			<button type="button" rel="tooltip"
																				class="btn btn-simple btn-danger btn-icon remove"
																				rel="tooltip" data-placement="bottom" title="Remove"
																				onclick="demo.showSwal('delete-message')">
																				<i class="material-icons">close</i>
																			</button>
																	</a></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
									
										</div>
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