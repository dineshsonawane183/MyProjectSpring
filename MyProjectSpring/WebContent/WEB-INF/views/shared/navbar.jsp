<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




	<script>
		window.userRole = '${userRole}';
	
	</script>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${contextRoot}/home">My Site</a>
		</div>

		<ul class="nav navbar-nav">

			<security:authorize access="hasAuthority('ADMIN')">
				<li id="listCustomers"><a href="${contextRoot}/manage/product">Manage
						Products</a></li>
				<li id="manageCustomers"><a
					href="${contextRoot}/manage/customer">Manage Customer
				
					</a></li>
			</security:authorize>




			<security:authorize access="hasAuthority('USER')">
				<li id="listCustomers"><a href="${contextRoot}/user/view/product">View 
						Products</a></li>
			
			</security:authorize>





			<li id="contact"><a href="${contextRoot}/contact">Contact</a>
			<li id="about"><a href="${contextRoot}/about">About</a></li>


			<security:authorize access="hasAuthority('ACCOUNTANT')">
				<li id="about"><a href="${contextRoot}/orderWorkspace.jsp">Order
						Section</a></li>

			</security:authorize>

		</ul>

		<ul class="nav navbar-nav navbar-right">

			<security:authorize access="isAnonymous()">

				<li id="signup"><a href="${contextRoot}/signUpPage">Sign Up</a></li>
				<li id="login"><a href="${contextRoot}/login">Login</a></li>
			</security:authorize>

			<security:authorize access="isAuthenticated()">
				<%
					Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				
				String str=authentication.getName();
			
				str=str.substring(0, 1).toUpperCase().concat(str.substring(1));
				%>
				<li class="dropdown" id="userModel"><a
					class="btn btn-default dropdown-toggle" href="javascript:void(0)"
					id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"> <span class="glyphicon glyphicon-user"></span>

						&nbsp;&nbsp; <%=str%>
						&nbsp;&nbsp;&nbsp;&nbsp;<span class="caret"></span>
				</a>

					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">


						<li id="logout"><a href="${contextRoot}/logout">Logout</a></li>



					</ul></li>
			</security:authorize>
		</ul>

	</div>
</nav>
