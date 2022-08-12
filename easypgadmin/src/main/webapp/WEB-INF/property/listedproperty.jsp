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
									<h4 class="card-title">Listed Properties</h4>
									<div class="table-responsive">
										<table class="table">
											<thead>
												<div class="material-datatables">
													<div id="datatables_wrapper"
														class="dataTables_wrapper form-inline dt-bootstrap">
														<div class="row">
															<div class="col-sm-6"></div>
															<div class="col-sm-6">
																<div id="datatables_filter" class="dataTables_filter"></div>
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
																			<th tabindex="0" aria-controls="datatables"
																				rowspan="1" colspan="1" style="width: 150px;"
																				aria-sort="ascending"
																				aria-label="Name: activate to sort column descending">Property
																				title</th>
																			<th tabindex="0" aria-controls="datatables"
																				rowspan="1" colspan="1" style="width: 150px;"
																				aria-label="Position: activate to sort column ascending">Rent</th>
																			<th tabindex="0" aria-controls="datatables"
																				rowspan="1" colspan="1" style="width: 150px;"
																				aria-label="Office: activate to sort column ascending">Status</th>
																			<th tabindex="0" aria-controls="datatables"
																				rowspan="1" colspan="1" style="width: 150px;"
																				aria-label="Office: activate to sort column ascending">Type</th>
																			<th tabindex="0" aria-controls="datatables"
																				rowspan="1" colspan="1" style="width: 150px;"
																				aria-label="Office: activate to sort column ascending">Fname</th>
																			<th tabindex="0" aria-controls="datatables"
																				rowspan="1" colspan="1" style="width: 150px;"
																				aria-label="Office: activate to sort column ascending">Lname</th>
																		</tr>
																	</thead>
																	<tbody>
																		<c:forEach items="${propertyList}" var="property">
																			<tr role="row" class="odd">
																				<td tabindex="0" class="sorting_1">${property.title}</td>
																				<td>${property.rent}</td>
																				<td>${property.status}</td>
																				<td>${property.type}</td>
																				<td>${property.fname}</td>
																				<td>${property.lname}</td>


																				<td class="td-actions text-right"><a
																					href="/easypgadmin/property/deleteProperty/${property.propertyId}">
																						<button type="button" rel="tooltip"
																							class="btn btn-simple btn-danger btn-icon remove"
																							rel="tooltip" data-placement="bottom"
																							title="Remove"
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



												<%@include file="../footer.jsp"%>
												</div>
												</div>
</body>
<!--   Core JS Files   -->
</html>
