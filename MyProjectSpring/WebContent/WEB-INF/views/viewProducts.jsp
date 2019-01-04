<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="content">


	<c:if test="${not empty message}">
		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-danger fade in">${message}</div>
			</div>
		</div>
	</c:if>

	<div class="container">
		<c:if test="${ not empty msg}">
			<div class="row">
				<div class="col-xs-12 col-md-offset-2 col-md-8">
					<div class="alert alert-success fade in">${msg}</div>
				</div>
			</div>
		</c:if>


		<div class="container">


			<ol class="breadcrumb">


				<li><a href="${contextRoot}/home">Home</a></li>

				<li><a href="${contextRoot}/user/view/product">View All Product</a></li>


			</ol>


			<div class="row">
				<table id="ProductTable" border="3px" solid
					class="table table-striped table-borderd">
					<thead>
						<tr>

							<th>product Id</th>
							<th>product Name</th>
							<th>product Code</th>
							<th>product Brand</th>
							<th>product Description</th>
							<th>product UnitPrice</th>
							<th>product Quantity</th>

							<th></th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>

			</div>
		</div>
	</div>
</div>
