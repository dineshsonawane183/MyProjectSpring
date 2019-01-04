<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<c:set var="css" value="${contextRoot}/resources/css" />
<c:set var="js" value="${contextRoot}/resources/js" />
<c:set var="images" value="${contextRoot}/resources/images" />
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

</head>
<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'
</script>


<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">


<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

<div class="wrapper">

	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>
	<!-- Page Content -->

	<div class="content">

		<div class="container">


			<!-- User Clicked Home -->
			<c:if test="${UserClickedHome eq 'true'}">
				<%@include file="home.jsp"%>
			</c:if>


			<!-- User Clicked Contact  -->
			<c:if test="${UserClickedContact eq 'true'}">
				<%@include file="contact.jsp"%>
			</c:if>


			<!-- User Clicked Contact  -->
			<c:if test="${UserClickedAbout eq 'true'}">
				<%@include file="about.jsp"%>
			</c:if>
			<!-- User Clicked sign up Page -->
			<c:if test="${UserClickedSignUp eq 'true'}">
				<%@include file="signup.jsp"%>
			</c:if>

			<c:if test="${userClickedManageProduct eq 'true'}">
				<%@include file="manageProduct.jsp"%>
			</c:if>
			<c:if test="${userClickedViewProducts eq 'true'}">
				<%@include file="viewProducts.jsp"%>
			</c:if>

			<c:if test="${userClickedViewSingleProduct eq 'true'}">
				<%@include file="viewSingleProduct.jsp"%>
			</c:if>


		</div>

	</div>




	<!-- Footer comes here -->
	<%@include file="./shared/footer.jsp"%>

	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>

	<script src="${js}/jquery.validate.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>


	<security:authorize access="isAnonymous()">
		<script src="${js}/registerForm.js"></script>


	</security:authorize>
	<!-- DataTable Plugin -->
	<script src="${js}/jquery.dataTables.js"></script>

	<!-- DataTable Bootstrap Script -->
	<script src="${js}/dataTables.bootstrap.js"></script>

	<!-- DataTable Bootstrap Script -->
	<script src="${js}/bootbox.min.js"></script>

	<!-- Self coded javascript -->
	<script src="${js}/myapp.js"></script>

</div>

</body>

</html>