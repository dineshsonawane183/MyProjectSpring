<div class="container">
	<%@ taglib prefix="security"
		uri="http://www.springframework.org/security/tags"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="row">
		<div class="col-xs-12">

			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/user/view/product">Products</a></li>
				<li class="active">${product.name}</li>
			</ol>
		</div>

	</div>

	<div class="row">
		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">

				<img src="${images}/${product.code}.jpg" class="img img-responsive" />

			</div>

		</div>
		<div class="col-xs-12 col-sm-8">

			<h3>${product.name}</h3>
			<hr>

			${product.description}
			<hr>

			<h4>&#8377; &nbsp;${product.unitPrice}</h4>

			<h6>Qty. Available: ${product.quantity}</h6>



			<security:authorize access="isAnonymous() or hasAuthority('USER')">
				<c:choose>
					<c:when test="${product.quantity < 1}">

						<a href="javascript:void(0)" class="btn btn-success disabled">
							<strike> <span>Add To Cart</span>
						</a>
						</strike>

						
					</c:when>
					<c:otherwise>

						<a href="#" class="btn btn-success"> <span
							class="glyphicon glyphicon-shopping-cart"></span>Add to Cart
						</a>
					</c:otherwise>
					
					
				</c:choose>
				
				<a href="${contextRoot}/user/view/product" class="btn btn-warning">
							Continue Shopping</a>
			</security:authorize>


			<security:authorize access="hasAuthority('ADMIN')">
				<a href="${contextRoot}/manage/${product.id}/product"
					class="btn btn-success"> <span
					class="glyphicon glyphicon-pencil"></span> Edit
				</a>
				
				
						<a href="${contextRoot}/manage/product" class="btn btn-warning">
							Back To The Manage Page</a>
			</security:authorize>



		</div>


	</div>





</div>