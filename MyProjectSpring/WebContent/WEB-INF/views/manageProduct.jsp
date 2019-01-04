<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<div class="content">



		<!-- to display the actual products -->
		<div class="col-md-9">

			<!-- Added breadcrumb component -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">
					
						<script>
							window.categoryId = '';
						</script>
					
						<ol class="breadcrumb">


							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>


						</ol>
					</c:if>
					
					
					<c:if test="${userClickCategoryProducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>
					
						<ol class="breadcrumb">


							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>


						</ol>
					</c:if>
					

				</div>


			</div>


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
<div class="row">

	<div class="col-md-offset-2 col-md-8">

		<div class="panel panel-primary">

			<div class="panel-heading">

				<h4>Product Management</h4>

			</div>

			<div class="panel-body">
				<form class="form-horizontal" action="${contextRoot}/manage/product/add"
					method="POST" enctype="multipart/form-data">

				<%-- 	<c:if test="${ not empty edit_val }">
						<input type="hidden" name="action" value="update" />
					</c:if>
					<c:if test="${ empty edit_val }">
						<input type="hidden" name="action" value="add" />
					</c:if> --%>


					<div class="form-group">
						<label class="control-label col-md-4">Product Id</label>
						<div class="col-md-8">
							<input type="text" name="id" class="form-control"
								placeholder="Product ID" value="${product.getId()}" readonly />

						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4">Product Name</label>
						<div class="col-md-8">
							<input type="text" name="name" class="form-control"
								placeholder="Product Name" value="${product.getName()}" />

						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4">Brand</label>
						<div class="col-md-8">
							<input type="text" name="brand" class="form-control"
								placeholder="Brand " value="${product.getBrand()}" />
						</div>
					</div>



					<div class="form-group">
						<label class="control-label col-md-4">Description</label>
						<div class="col-md-8">
							<input type="text" name="description" class="form-control"
								placeholder="Description" value="${product.getDescription()}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4">UnitPrice</label>
						<div class="col-md-8">
							<input type="text" name="unitPrice" class="form-control"
								placeholder="UnitPrice" value="${product.getUnitPrice()}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4">Quantity</label>
						<div class="col-md-8">
							<input type="text" name="quantity" class="form-control"
								placeholder="Quantity" value="${product.getQuantity()}" />
						</div>
					</div>
					
					<div class="form-group">
					<label class="control-label col-md-4">Upload a image:</label>
					<div class="col-md-8">
					<input type="file" name="file" />
					</div>
					  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4">Active</label>
						<div class="col-md-8">
							<input type="radio" name="active" value="true" /> Active<br>
							<input type="radio" name="active" value="false">
							InActive<br>
						</div>
					</div>

					<div class="form-group">

						<div class="col-md-offset-4 col-md-4">


							<c:if test="${ not empty edit_val }">
								<input type="submit" name="submit" value="Update Product"
									class="btn btn-primary" />
							</c:if>
							<c:if test="${ empty edit_val }">
								<input type="submit" name="submit" value="Add Product"
									class="btn btn-primary" />
							</c:if>
						</div>
					</div>

				</form>

			</div>

		</div>

	</div>

</div>



<div class="container">
<div class="row">
	<table id="ProductTable"  border="3px" solid
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
